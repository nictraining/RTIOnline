package com.example.RtiPioApi.service.pio;

import com.example.RtiPioApi.dto.pio.DisposeRequestDTO;
import com.example.RtiPioApi.dto.pio.PaginationInfoDTO;
import com.example.RtiPioApi.dto.pio.PioDashboardStats;
import com.example.RtiPioApi.dto.pio.RtiRequestListDTO;
import com.example.RtiPioApi.dto.pio.RtiRequestPagedResponse;
import com.example.RtiPioApi.dto.pio.RtiRequestQuery;
import com.example.RtiPioApi.entity.pio.AdditionalPayment;
import com.example.RtiPioApi.entity.pio.CommentsCpio;
import com.example.RtiPioApi.entity.pio.DeemedPio;
import com.example.RtiPioApi.entity.pio.PioDetails;
import com.example.RtiPioApi.entity.pio.ReminderDpio;
import com.example.RtiPioApi.entity.pio.RtiApplication;
import com.example.RtiPioApi.entity.pio.RtiAppeal;
import com.example.RtiPioApi.exception.ResourceNotFoundException;
import com.example.RtiPioApi.exception.UnauthorizedException;
import com.example.RtiPioApi.repository.pio.AdditionalPaymentRepository;
import com.example.RtiPioApi.repository.pio.CommentsCpioRepository;
import com.example.RtiPioApi.repository.pio.DeemedPioRepository;
import com.example.RtiPioApi.repository.pio.PioDetailsRepository;
import com.example.RtiPioApi.repository.pio.ReminderDpioRepository;
import com.example.RtiPioApi.repository.pio.RtiApplicationRepository;
import com.example.RtiPioApi.repository.pio.RtiAppealRepository;
import com.example.RtiPioApi.util.AppConstants;
import com.example.RtiPioApi.util.DateFormatter;
import com.example.RtiPioApi.util.FileStorageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Transactional
public class PioService {

    private static final Logger logger = LoggerFactory.getLogger(PioService.class);

    private final RtiApplicationRepository rtiApplicationRepository;
    private final RtiAppealRepository rtiAppealRepository;
    private final AdditionalPaymentRepository additionalPaymentRepository;
    private final CommentsCpioRepository commentsCpioRepository;
    private final DeemedPioRepository deemedPioRepository;
    private final ReminderDpioRepository reminderDpioRepository;
    private final PioDetailsRepository pioDetailsRepository;
    private final FileStorageUtil fileStorageUtil;

    @Autowired
    public PioService(RtiApplicationRepository rtiApplicationRepository,
                      RtiAppealRepository rtiAppealRepository,
                      AdditionalPaymentRepository additionalPaymentRepository,
                      CommentsCpioRepository commentsCpioRepository,
                      DeemedPioRepository deemedPioRepository,
                      ReminderDpioRepository reminderDpioRepository,
                      PioDetailsRepository pioDetailsRepository,
                      FileStorageUtil fileStorageUtil) {
        this.rtiApplicationRepository = rtiApplicationRepository;
        this.rtiAppealRepository = rtiAppealRepository;
        this.additionalPaymentRepository = additionalPaymentRepository;
        this.commentsCpioRepository = commentsCpioRepository;
        this.deemedPioRepository = deemedPioRepository;
        this.reminderDpioRepository = reminderDpioRepository;
        this.pioDetailsRepository = pioDetailsRepository;
        this.fileStorageUtil = fileStorageUtil;
    }


    public PioDashboardStats getPioDashboardStatistics(String pioId) {
        logger.info("Calculating dashboard statistics for PIO: {}", pioId);
        PioDashboardStats stats = new PioDashboardStats();

        PioDetails pioDetails = pioDetailsRepository.findByPioIdAndActiveIdle(pioId, "Y")
                .orElseThrow(() -> new ResourceNotFoundException("Active PIO details not found for ID: " + pioId));


        List<RtiApplication> pioApplications = rtiApplicationRepository.findByPioId(pioId);
        List<String> pioApplicationRegistrationNos = pioApplications.stream()
                .map(RtiApplication::getRegistrationNo)
                .collect(Collectors.toList());

        // 2. RTI REQUESTS – New (requestStatus = 'N' or 'H' and closing_date IS NULL and not ActionStatus ('4C', '4M', '30'))
        stats.setNewRequests((int) rtiApplicationRepository.countNewRequestsByPioId(pioId));

        // 3. RTI REQUESTS – Under Process (requestStatus = 'P' or 'C' or 'F' and closing_date IS NULL and not ActionStatus '4C')
        stats.setRtiRequestsUnderProcess((int) rtiApplicationRepository.countUnderProcessRequestsByPioId(pioId));

        // 4. RTI REQUESTS – Total, Disposed, Pending
        stats.setTotalRequests(pioApplications.size());
        stats.setTotalRequestsDisposed((int) rtiApplicationRepository.countByPioIdAndClosingDateIsNotNull(pioId));
        stats.setTotalRequestsPending((int) rtiApplicationRepository.countByPioIdAndClosingDateIsNull(pioId)); // Total pending

        // 5. PENDING FOR DISPOSED OFF - More Than 20 Days
        // Logic: Requests with no closing date, status 'N' or 'P', currentActionStatus not '4C', received > 20 days ago
        LocalDate twentyDaysAgo = LocalDate.now().minusDays(20);
        stats.setPendingMoreThan20Days((int) rtiApplicationRepository.countPending20DaysByPioId(
                pioId, List.of("N", "P"), AppConstants.CURRENT_ACTION_STATUS_REJECTED, twentyDaysAgo));

        // 6. DISPOSED WITHIN 5 DAYS (Actual logic: checks for >24 days - appears to be a logic issue in doc, interpreting as doc says)
        // Logic: requestStatus = 'P', currentActionStatus = '30', received > 24 days ago
        LocalDate twentyFourDaysAgo = LocalDate.now().minusDays(24);
        stats.setToBeDisposedWithin5Days((int) rtiApplicationRepository.countDisposedIn5DaysByPioId(
                pioId, twentyFourDaysAgo));

        // Combining the two "PENDING FOR DISPOSED OFF" from the main dashboard section (if needed as a single sum)
        stats.setPendingForDisposedOff(stats.getPendingMoreThan20Days() + stats.getToBeDisposedWithin5Days());

        // 7. Additional Payment (Demanded & Received)
        stats.setAdditionalPaymentDemanded((int) additionalPaymentRepository.countByRegistrationNoInAndPaid(pioApplicationRegistrationNos, "N"));
        stats.setAdditionalPaymentReceived((int) additionalPaymentRepository.countByRegistrationNoInAndPaid(pioApplicationRegistrationNos, "Y"));

        // 8. Actions (Third Party Info, Documents Called, Documents Received)
        stats.setThirdPartyInfoRequired((int) rtiApplicationRepository.countByPioIdAndCurrentActionStatusAndClosingDateIsNull(pioId, AppConstants.CURRENT_ACTION_STATUS_THIRD_PARTY_INFO));
        stats.setDocumentsCalled((int) rtiApplicationRepository.countByPioIdAndCurrentActionStatus(pioId, AppConstants.CURRENT_ACTION_STATUS_DOC_CALL));
        // Assuming DOC_RECVD has a status like '4D' or is simply when document_id is not null after DOC_CALL
        stats.setDocumentsReceived((int) rtiApplicationRepository.countByPioIdAndCurrentActionStatusAndDocumentIdIsNotNull(pioId, AppConstants.CURRENT_ACTION_STATUS_DOC_RECEIVED));

        // 9. Forwarded/Reply/Acknowledgement from DPIO
        stats.setForwardedToDpio((int) rtiApplicationRepository.countForwardedDpioByPioId(pioId, AppConstants.DPIO_FLAG_FORWARDED_SENT));
        stats.setRepliesFromDpio((int) rtiApplicationRepository.countReplyDpioByPioId(pioId, AppConstants.DPIO_FLAG_REPLY_RECEIVED));
        stats.setNewAcknowledgementsFromDpio((int) reminderDpioRepository.countByPioIdAndReplyIsNotNull(pioId));

        // 10. Comments by AA (Sought & PIO Comments)
        // Using the newly added findByCpioApp method
        List<String> combinedRegistrationNos = pioApplicationRegistrationNos;
        combinedRegistrationNos.addAll(rtiAppealRepository.findByCpioApp(pioDetails.getPioCode()).stream().map(RtiAppeal::getRegistrationNo).collect(Collectors.toList()));
        stats.setCommentsSoughtByAa((int) commentsCpioRepository.countByRegistrationNoInAndFlag(combinedRegistrationNos, AppConstants.COMMENTS_FLAG_SOUGHT));
        stats.setCommentsGivenByPio((int) commentsCpioRepository.countByRegistrationNoInAndFlag(combinedRegistrationNos, AppConstants.COMMENTS_FLAG_REPLIED));

        // 11. Appeals (Raised & Disposed)
        // Appeals raised where this PIO is the cpio_app (whose decision is appealed)
        stats.setTotalAppealsRaised((int) rtiAppealRepository.countByCpioApp(pioDetails.getPioCode()));
        stats.setTotalAppealsDisposed((int) rtiAppealRepository.countByCpioAppAndClosingDateIsNotNull(pioDetails.getPioCode()));

        logger.info("Finished calculating dashboard statistics for PIO: {}", pioId);
        return stats;
    }

    public RtiRequestPagedResponse getFilteredRtiRequests(RtiRequestQuery rtiRequestQuery, String pioId) {
        String recordType = rtiRequestQuery.getRecordType();
        int page = rtiRequestQuery.getOffset() / rtiRequestQuery.getLimit(); // Calculate page number
        Pageable pageable = PageRequest.of(page, rtiRequestQuery.getLimit(), Sort.by("entryDate").descending());

        Page<RtiApplication> rtiApplicationPage;
        long totalCount;

        switch (recordType) {
            case AppConstants.RECORD_TYPE_PENDING_20_DAYS:
                LocalDate twentyDaysAgo = LocalDate.now().minusDays(20);
                List<String> pendingStatuses = List.of("N", "P");
                rtiApplicationPage = rtiApplicationRepository.findPending20DaysByPioId(
                        pioId, pendingStatuses, AppConstants.CURRENT_ACTION_STATUS_REJECTED, twentyDaysAgo, pageable);
                totalCount = rtiApplicationRepository.countPending20DaysByPioId(
                        pioId, pendingStatuses, AppConstants.CURRENT_ACTION_STATUS_REJECTED, twentyDaysAgo);
                break;
            case AppConstants.RECORD_TYPE_NEW:
                rtiApplicationPage = rtiApplicationRepository.findByPioIdAndRequestStatusAndClosingDateIsNullAndCurrentActionStatus(
                        pioId, AppConstants.REQUEST_STATUS_NEW, AppConstants.CURRENT_ACTION_STATUS_NEW_L, pageable);
                totalCount = rtiApplicationRepository.countByPioIdAndRequestStatusAndClosingDateIsNullAndCurrentActionStatus(
                        pioId, AppConstants.REQUEST_STATUS_NEW, AppConstants.CURRENT_ACTION_STATUS_NEW_L);
                break;
            case AppConstants.RECORD_TYPE_UNDER_PROCESS:
                rtiApplicationPage = rtiApplicationRepository.findUnderProcessByPioId(pioId, pageable);
                totalCount = rtiApplicationRepository.countUnderProcessByPioId(pioId);
                break;
            case AppConstants.RECORD_TYPE_DISPOSED_IN_5_DAYS:
                LocalDate twentyFourDaysAgo = LocalDate.now().minusDays(24); // As per doc's apparent logic issue
                rtiApplicationPage = rtiApplicationRepository.findDisposedIn5DaysByPioId(
                        pioId, twentyFourDaysAgo, pageable);
                totalCount = rtiApplicationRepository.countDisposedIn5DaysByPioId(
                        pioId, twentyFourDaysAgo);
                break;
            case AppConstants.RECORD_TYPE_ADDITIONAL_PAYMENT_DEMANDED:
                rtiApplicationPage = rtiApplicationRepository.findAdditionalPaymentDemandedByPioId(pioId, pageable);
                totalCount = rtiApplicationRepository.countAdditionalPaymentDemandedByPioId(pioId);
                break;
            case AppConstants.RECORD_TYPE_ADDITIONAL_PAYMENT_RECEIVED:
                rtiApplicationPage = rtiApplicationRepository.findAdditionalPaymentReceivedByPioId(pioId, pageable);
                totalCount = rtiApplicationRepository.countAdditionalPaymentReceivedByPioId(pioId);
                break;
            case AppConstants.RECORD_TYPE_THIRD_PARTY_INFO_REQUIRED:
                rtiApplicationPage = rtiApplicationRepository.findByPioIdAndCurrentActionStatusAndClosingDateIsNull(
                        pioId, AppConstants.CURRENT_ACTION_STATUS_THIRD_PARTY_INFO, pageable);
                totalCount = rtiApplicationRepository.countByPioIdAndCurrentActionStatusAndClosingDateIsNull(
                        pioId, AppConstants.CURRENT_ACTION_STATUS_THIRD_PARTY_INFO);
                break;
            case AppConstants.RECORD_TYPE_DOC_CALL:
                rtiApplicationPage = rtiApplicationRepository.findByPioIdAndCurrentActionStatus(
                        pioId, AppConstants.CURRENT_ACTION_STATUS_DOC_CALL, pageable);
                totalCount = rtiApplicationRepository.countByPioIdAndCurrentActionStatus(
                        pioId, AppConstants.CURRENT_ACTION_STATUS_DOC_CALL);
                break;
            case AppConstants.RECORD_TYPE_DOC_RECVD:
                rtiApplicationPage = rtiApplicationRepository.findByPioIdAndCurrentActionStatusAndDocumentIdIsNotNull(
                        pioId, AppConstants.CURRENT_ACTION_STATUS_DOC_RECEIVED, pageable);
                totalCount = rtiApplicationRepository.countByPioIdAndCurrentActionStatusAndDocumentIdIsNotNull(
                        pioId, AppConstants.CURRENT_ACTION_STATUS_DOC_RECEIVED);
                break;
            case AppConstants.RECORD_TYPE_FORWARDED_DPIO:
                rtiApplicationPage = rtiApplicationRepository.findForwardedDpioByPioId(
                        pioId, AppConstants.DPIO_FLAG_FORWARDED_SENT, pageable);
                totalCount = rtiApplicationRepository.countForwardedDpioByPioId(
                        pioId, AppConstants.DPIO_FLAG_FORWARDED_SENT);
                break;
            case AppConstants.RECORD_TYPE_REPLY_DPIO:
                rtiApplicationPage = rtiApplicationRepository.findReplyDpioByPioId(
                        pioId, AppConstants.DPIO_FLAG_REPLY_RECEIVED, pageable);
                totalCount = rtiApplicationRepository.countReplyDpioByPioId(
                        pioId, AppConstants.DPIO_FLAG_REPLY_RECEIVED);
                break;
            case AppConstants.RECORD_TYPE_ACK_DPIO:
                rtiApplicationPage = rtiApplicationRepository.findAckDpioByPioId(pioId, pageable);
                totalCount = rtiApplicationRepository.countAckDpioByPioId(pioId);
                break;
            case AppConstants.RECORD_TYPE_COMMENTS_SOUGHT_BY_AA:
                rtiApplicationPage = rtiApplicationRepository.findCommentsSoughtByAaByPioId(pioId, pageable);
                totalCount = rtiApplicationRepository.countCommentsSoughtByAaByPioId(pioId);
                break;
            case AppConstants.RECORD_TYPE_COMMENTS_GIVEN_BY_PIO:
                rtiApplicationPage = rtiApplicationRepository.findCommentsGivenByPioByPioId(pioId, pageable);
                totalCount = rtiApplicationRepository.countCommentsGivenByPioByPioId(pioId);
                break;
            default:
                logger.warn("Unsupported record type requested: {}", recordType);
                throw new IllegalArgumentException("Unsupported record_type: " + recordType);
        }


        List<RtiRequestListDTO> dtoList = rtiApplicationPage.getContent().stream().map(app -> {
            RtiRequestListDTO dto = new RtiRequestListDTO(
                    app.getRegistrationNo(),
                    app.getApplicantName(),
                    app.getRecvdDate(),
                    app.getEntryDate(),
                    app.getCurrentActionStatus(),
                    app.getDocumentId()
            );


            if (recordType.equals(AppConstants.RECORD_TYPE_FORWARDED_DPIO) && app.getRecvdDate() != null) {

                dto.setTargetCompletionDate(DateFormatter.format(app.getRecvdDate().plusDays(30)));
                dto.setDaysSinceReceived(ChronoUnit.DAYS.between(app.getRecvdDate(), LocalDate.now()));
            }
            if (recordType.equals(AppConstants.RECORD_TYPE_REPLY_DPIO) && app.getReplyDocumentUrl() != null) {

                deemedPioRepository.findByRegistrationNoInAndFlagIn(
                                List.of(app.getRegistrationNo()), List.of(AppConstants.DPIO_FLAG_REPLY_RECEIVED))
                        .stream().findFirst().ifPresent(dpio -> {
                            dto.setDateOfReply(dpio.getReplyDate() != null ? DateFormatter.format(dpio.getReplyDate()) : null);
                            dto.setReplyContent(dpio.getReplyContent());
                            dto.setFilename(dpio.getReplyFilename());
                        });
            }
            if (recordType.equals(AppConstants.RECORD_TYPE_ACK_DPIO)) {

                reminderDpioRepository.findByRegistrationNo(app.getRegistrationNo())
                        .stream().findFirst().ifPresent(rdpio -> {

                            dto.setDpioName(rdpio.getDpioId());
                            dto.setReminderDate(rdpio.getReminderDate() != null ? DateFormatter.format(rdpio.getReminderDate()) : null);
                            dto.setReplyContent(rdpio.getReply());
                        });
            }

            return dto;
        }).collect(Collectors.toList());

        PaginationInfoDTO pagination = new PaginationInfoDTO(rtiRequestQuery.getLimit(), rtiRequestQuery.getOffset(), totalCount);
        return new RtiRequestPagedResponse("success", dtoList, pagination);
    }


    public RtiApplication getRtiApplicationDetails(String applicationId, String pioId) {
        RtiApplication application = rtiApplicationRepository.findById(applicationId)
                .orElseThrow(() -> {
                    logger.warn("RTI Application not found with ID: {}", applicationId);
                    return new ResourceNotFoundException("RTI Application not found with ID: " + applicationId);
                });

        if (!pioId.equals(application.getPioId())) {
            logger.warn("PIO {} attempted to access unauthorized application {}.", pioId, applicationId);
            throw new UnauthorizedException("You are not authorized to view this RTI application.");
        }

        return application;
    }


    public RtiApplication disposeRtiRequest(String applicationId, DisposeRequestDTO disposeDTO, MultipartFile file, String pioId) {
        RtiApplication application = rtiApplicationRepository.findById(applicationId)
                .orElseThrow(() -> {
                    logger.warn("RTI Application not found with ID: {}", applicationId);
                    return new ResourceNotFoundException("RTI Application not found with ID: " + applicationId);
                });

        if (!pioId.equals(application.getPioId())) {
            logger.warn("PIO {} attempted to dispose unauthorized application {}.", pioId, applicationId);
            throw new UnauthorizedException("You are not authorized to dispose this RTI application.");
        }

        if (application.getClosingDate() != null || AppConstants.REQUEST_STATUS_DISPOSED_OFF.equals(application.getRequestStatus())) {
            logger.warn("Attempted to dispose an already disposed application: {}", applicationId);
            throw new IllegalStateException("RTI Application " + applicationId + " is already disposed.");
        }


        if (file != null && !file.isEmpty()) {
            try {
                String fileUrl = fileStorageUtil.uploadFile(file);
                application.setReplyDocumentUrl(fileUrl);
                logger.info("Reply document uploaded for application {}: {}", applicationId, fileUrl);
            } catch (Exception e) {
                logger.error("Failed to upload reply document for application {}: {}", applicationId, e.getMessage(), e);

                throw new RuntimeException("Failed to upload reply document: " + e.getMessage());
            }
        }

        application.setResponseDetails(disposeDTO.getResponseDetails());
        application.setClosingDate(LocalDateTime.now());
        application.setRequestStatus(AppConstants.REQUEST_STATUS_DISPOSED_OFF);

        application.setCurrentActionStatus(AppConstants.CURRENT_ACTION_STATUS_DISPOSED);

        RtiApplication updatedApplication = rtiApplicationRepository.save(application);
        logger.info("RTI Application {} successfully disposed by PIO {}", applicationId, pioId);
        return updatedApplication;
    }


    public List<RtiAppeal> getAppealsRelatedToPio(String pioId) {
        PioDetails pioDetails = pioDetailsRepository.findById(pioId)
                .orElseThrow(() -> new ResourceNotFoundException("PIO details not found for ID: " + pioId));

        String pioCode = pioDetails.getPioCode();
        logger.info("Fetching appeals related to PIO Code: {}", pioCode);


        List<RtiAppeal> appeals = rtiAppealRepository.findByCpioApp(pioCode);


        for (RtiAppeal appeal : appeals) {
            rtiApplicationRepository.findById(appeal.getRequestNo()).ifPresent(originalApp -> {
                appeal.setOriginalPioId(originalApp.getPioId());
                appeal.setOriginalPioResponseDetails(originalApp.getResponseDetails());
            });
        }

        return appeals;
    }
}

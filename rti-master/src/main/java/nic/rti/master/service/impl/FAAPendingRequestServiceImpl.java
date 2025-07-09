package nic.rti.master.service.impl;

import lombok.RequiredArgsConstructor;
import nic.rti.master.dao.FAAPendingRequestRepository;
import nic.rti.master.dto.*;
import nic.rti.master.service.FAAPendingRequestService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FAAPendingRequestServiceImpl implements FAAPendingRequestService {

    private final FAAPendingRequestRepository faaRepo;

    @Override
    public FinalResponseDTO fetchPendingRequests(PendingRequestDTO requestDTO) {
        String recordsType = requestDTO.getRecordsType();
        Integer applId = requestDTO.getApplId();
        Integer limit = requestDTO.getLimit();
        Integer offset = requestDTO.getOffset();

        List<PendingRequestResponseDTO> result;
        long totalCount;

        switch (recordsType) {
            case "UNDER_PROCESS":
                result = faaRepo.fetchUnderProcess(applId, limit, offset);
                totalCount = faaRepo.countUnderProcess(applId);
                break;
            case "COMMENT_CPIO":
                result = faaRepo.fetchCommentCPIO(applId, limit, offset);
                totalCount = faaRepo.countCommentCPIO(applId);
                break;
            case "MODIFY":
                result = faaRepo.fetchModify(applId, limit, offset);
                totalCount = faaRepo.countModify(applId);
                break;
            case "NEW":
                result = faaRepo.fetchNew(applId, limit, offset);
                totalCount = faaRepo.countNew(applId);
                break;
            case "PENDING_20_DAYS":
                result = faaRepo.fetchPending20Days(applId, limit, offset);
                totalCount = faaRepo.countPending20Days(applId);
                break;
            default:
                throw new IllegalArgumentException("Invalid record type: " + recordsType);
        }

        boolean hasMore = totalCount > (offset + result.size());
        PaginationDTO pagination = new PaginationDTO(limit, offset, totalCount, hasMore);

        return new FinalResponseDTO("success", result, pagination);
    }
}

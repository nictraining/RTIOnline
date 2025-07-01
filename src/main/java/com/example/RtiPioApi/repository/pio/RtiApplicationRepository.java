package com.example.RtiPioApi.repository.pio; // Updated package

import com.example.RtiPioApi.entity.pio.RtiApplication; // Updated import
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface RtiApplicationRepository extends JpaRepository<RtiApplication, String> {

    Optional<RtiApplication> findByRegistrationNoAndPioId(String registrationNo, String pioId);


    List<RtiApplication> findByPioId(String pioId); // Added this method

    @Query("SELECT COUNT(r) FROM RtiApplication r WHERE r.pioId = :pioId " +
            "AND (r.requestStatus = 'N' OR r.requestStatus = 'H') AND r.closingDate IS NULL " +
            "AND r.currentActionStatus NOT IN ('4C', '4M', '30')")
    long countNewRequestsByPioId(@Param("pioId") String pioId);


    @Query("SELECT COUNT(r) FROM RtiApplication r WHERE r.pioId = :pioId " +
            "AND (r.requestStatus = 'P' OR r.requestStatus = 'C' OR r.requestStatus = 'F') AND r.closingDate IS NULL " +
            "AND r.currentActionStatus <> '4C'")
    long countUnderProcessRequestsByPioId(@Param("pioId") String pioId);


    long countByPioIdAndClosingDateIsNotNull(@Param("pioId") String pioId);


    long countByPioIdAndClosingDateIsNull(@Param("pioId") String pioId);



    @Query("SELECT r FROM RtiApplication r WHERE r.pioId = :pioId " +
            "AND r.closingDate IS NULL AND r.requestStatus IN :statuses " +
            "AND r.currentActionStatus <> :actionStatus AND r.recvdDate < :twentyDaysAgo")
    Page<RtiApplication> findPending20DaysByPioId(
            @Param("pioId") String pioId,
            @Param("statuses") List<String> statuses,
            @Param("actionStatus") String actionStatus,
            @Param("twentyDaysAgo") LocalDate twentyDaysAgo,
            Pageable pageable);

    @Query("SELECT COUNT(r) FROM RtiApplication r WHERE r.pioId = :pioId " +
            "AND r.closingDate IS NULL AND r.requestStatus IN :statuses " +
            "AND r.currentActionStatus <> :actionStatus AND r.recvdDate < :twentyDaysAgo")
    long countPending20DaysByPioId(
            @Param("pioId") String pioId,
            @Param("statuses") List<String> statuses,
            @Param("actionStatus") String actionStatus,
            @Param("twentyDaysAgo") LocalDate twentyDaysAgo);


    Page<RtiApplication> findByPioIdAndRequestStatusAndClosingDateIsNullAndCurrentActionStatus(
            String pioId, String requestStatus, String currentActionStatus, Pageable pageable);


    long countByPioIdAndRequestStatusAndClosingDateIsNullAndCurrentActionStatus(
            String pioId, String requestStatus, String currentActionStatus);

    @Query("SELECT r FROM RtiApplication r WHERE r.pioId = :pioId " +
            "AND r.requestStatus = 'P' AND r.closingDate IS NULL " +
            "AND r.currentActionStatus NOT IN ('4C', '4L', '30')")
    Page<RtiApplication> findUnderProcessByPioId(
            @Param("pioId") String pioId, Pageable pageable);


    @Query("SELECT COUNT(r) FROM RtiApplication r WHERE r.pioId = :pioId " +
            "AND r.requestStatus = 'P' AND r.closingDate IS NULL " +
            "AND r.currentActionStatus NOT IN ('4C', '4L', '30')")
    long countUnderProcessByPioId(@Param("pioId") String pioId);



    @Query("SELECT r FROM RtiApplication r WHERE r.pioId = :pioId " +
            "AND r.requestStatus = 'P' AND r.currentActionStatus = '30' " +
            "AND r.recvdDate < :twentyFourDaysAgo")
    Page<RtiApplication> findDisposedIn5DaysByPioId(
            @Param("pioId") String pioId, @Param("twentyFourDaysAgo") LocalDate twentyFourDaysAgo, Pageable pageable);


    @Query("SELECT COUNT(r) FROM RtiApplication r WHERE r.pioId = :pioId " +
            "AND r.requestStatus = 'P' AND r.currentActionStatus = '30' " +
            "AND r.recvdDate < :twentyFourDaysAgo")
    long countDisposedIn5DaysByPioId(
            @Param("pioId") String pioId, @Param("twentyFourDaysAgo") LocalDate twentyFourDaysAgo);



    @Query("SELECT r FROM RtiApplication r JOIN AdditionalPayment ap ON r.registrationNo = ap.registrationNo " +
            "WHERE r.pioId = :pioId AND ap.paid = 'N'")
    Page<RtiApplication> findAdditionalPaymentDemandedByPioId(@Param("pioId") String pioId, Pageable pageable);

    @Query("SELECT COUNT(r) FROM RtiApplication r JOIN AdditionalPayment ap ON r.registrationNo = ap.registrationNo " +
            "WHERE r.pioId = :pioId AND ap.paid = 'N'")
    long countAdditionalPaymentDemandedByPioId(@Param("pioId") String pioId);


    @Query("SELECT r FROM RtiApplication r JOIN AdditionalPayment ap ON r.registrationNo = ap.registrationNo " +
            "WHERE r.pioId = :pioId AND ap.paid = 'Y'")
    Page<RtiApplication> findAdditionalPaymentReceivedByPioId(@Param("pioId") String pioId, Pageable pageable);


    @Query("SELECT COUNT(r) FROM RtiApplication r JOIN AdditionalPayment ap ON r.registrationNo = ap.registrationNo " +
            "WHERE r.pioId = :pioId AND ap.paid = 'Y'")
    long countAdditionalPaymentReceivedByPioId(@Param("pioId") String pioId);


    Page<RtiApplication> findByPioIdAndCurrentActionStatusAndClosingDateIsNull(
            String pioId, String currentActionStatus, Pageable pageable);


    long countByPioIdAndCurrentActionStatusAndClosingDateIsNull(
            String pioId, String currentActionStatus);



    Page<RtiApplication> findByPioIdAndCurrentActionStatus(String pioId, String currentActionStatus, Pageable pageable);


    long countByPioIdAndCurrentActionStatus(String pioId, String currentActionStatus);



    Page<RtiApplication> findByPioIdAndCurrentActionStatusAndDocumentIdIsNotNull(
            String pioId, String currentActionStatus, Pageable pageable);


    long countByPioIdAndCurrentActionStatusAndDocumentIdIsNotNull(
            String pioId, String currentActionStatus);



    @Query("SELECT r FROM RtiApplication r JOIN DeemedPio dp ON r.registrationNo = dp.registrationNo " +
            "WHERE r.pioId = :pioId AND dp.flag = :dpioFlag")
    Page<RtiApplication> findForwardedDpioByPioId(@Param("pioId") String pioId, @Param("dpioFlag") String dpioFlag, Pageable pageable);


    @Query("SELECT COUNT(r) FROM RtiApplication r JOIN DeemedPio dp ON r.registrationNo = dp.registrationNo " +
            "WHERE r.pioId = :pioId AND dp.flag = :dpioFlag")
    long countForwardedDpioByPioId(@Param("pioId") String pioId, @Param("dpioFlag") String dpioFlag);



    @Query("SELECT r FROM RtiApplication r JOIN DeemedPio dp ON r.registrationNo = dp.registrationNo " +
            "WHERE r.pioId = :pioId AND dp.flag = :dpioFlag AND dp.replyDate IS NOT NULL")
    Page<RtiApplication> findReplyDpioByPioId(@Param("pioId") String pioId, @Param("dpioFlag") String dpioFlag, Pageable pageable);


    @Query("SELECT COUNT(r) FROM RtiApplication r JOIN DeemedPio dp ON r.registrationNo = dp.registrationNo " +
            "WHERE r.pioId = :pioId AND dp.flag = :dpioFlag AND dp.replyDate IS NOT NULL")
    long countReplyDpioByPioId(@Param("pioId") String pioId, @Param("dpioFlag") String dpioFlag);


    @Query("SELECT r FROM RtiApplication r JOIN ReminderDpio rd ON r.registrationNo = rd.registrationNo " +
            "WHERE rd.pioId = :pioId AND rd.reply IS NOT NULL")
    Page<RtiApplication> findAckDpioByPioId(@Param("pioId") String pioId, Pageable pageable);


    @Query("SELECT COUNT(r) FROM RtiApplication r JOIN ReminderDpio rd ON r.registrationNo = rd.registrationNo " +
            "WHERE rd.pioId = :pioId AND rd.reply IS NOT NULL")
    long countAckDpioByPioId(@Param("pioId") String pioId);



    @Query("SELECT r FROM RtiApplication r JOIN CommentsCpio cc ON r.registrationNo = cc.registrationNo " +
            "WHERE r.pioId = :pioId AND cc.flag = 'S'")
    Page<RtiApplication> findCommentsSoughtByAaByPioId(@Param("pioId") String pioId, Pageable pageable);


    @Query("SELECT COUNT(r) FROM RtiApplication r JOIN CommentsCpio cc ON r.registrationNo = cc.registrationNo " +
            "WHERE r.pioId = :pioId AND cc.flag = 'S'")
    long countCommentsSoughtByAaByPioId(@Param("pioId") String pioId);



    @Query("SELECT r FROM RtiApplication r JOIN CommentsCpio cc ON r.registrationNo = cc.registrationNo " +
            "WHERE r.pioId = :pioId AND cc.flag = 'R'")
    Page<RtiApplication> findCommentsGivenByPioByPioId(@Param("pioId") String pioId, Pageable pageable);

    @Query("SELECT COUNT(r) FROM RtiApplication r JOIN CommentsCpio cc ON r.registrationNo = cc.registrationNo " +
            "WHERE r.pioId = :pioId AND cc.flag = 'R'")
    long countCommentsGivenByPioByPioId(@Param("pioId") String pioId);
}

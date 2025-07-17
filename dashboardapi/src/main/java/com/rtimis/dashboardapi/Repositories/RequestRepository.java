package com.rtimis.dashboardapi.repository;

import com.rtimis.dashboardapi.model.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RequestRepository extends JpaRepository<Request, Long> {

    @Query("SELECT COUNT(r) FROM Request r WHERE r.userCode = :userCode AND r.recvdDate IS NOT NULL AND r.requestStatus = 'N' AND r.closingDate IS NULL")
    Long countRegistered(String userCode);

    @Query("SELECT COUNT(r) FROM Request r WHERE r.userCode = :userCode AND r.closingDate IS NOT NULL AND r.dispatchDate IS NULL AND r.recvdDate IS NOT NULL")
    Long countDisposed(String userCode);

    @Query("SELECT COUNT(r) FROM Request r WHERE r.userCode = :userCode AND r.closingDate IS NULL")
    Long countPending(String userCode);
}

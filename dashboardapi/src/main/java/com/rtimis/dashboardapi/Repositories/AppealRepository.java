package com.rtimis.dashboardapi.repository;

import com.rtimis.dashboardapi.model.Appeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AppealRepository extends JpaRepository<Appeal, Long> {

    @Query("SELECT COUNT(a) FROM Appeal a WHERE a.userCode = :userCode AND a.recvdDate IS NOT NULL AND a.astatus = 'F' AND a.closingDate IS NULL")
    Long countRegistered(String userCode);

    @Query("SELECT COUNT(a) FROM Appeal a WHERE a.userCode = :userCode AND a.closingDate IS NOT NULL AND a.dispatchDate IS NULL AND a.recvdDate IS NOT NULL")
    Long countDisposed(String userCode);

    @Query("SELECT COUNT(a) FROM Appeal a WHERE a.userCode = :userCode AND a.closingDate IS NULL")
    Long countPending(String userCode);
}

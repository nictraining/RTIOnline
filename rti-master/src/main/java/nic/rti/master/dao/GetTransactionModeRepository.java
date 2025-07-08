package nic.rti.master.dao;

import nic.rti.master.entity.TransactionMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetTransactionModeRepository extends JpaRepository<TransactionMode, String> {
}

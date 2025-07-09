package nic.rti.master.dao;


import nic.rti.master.entity.ReceiptType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetReceiptTypeRepository extends JpaRepository<ReceiptType, String> {
}

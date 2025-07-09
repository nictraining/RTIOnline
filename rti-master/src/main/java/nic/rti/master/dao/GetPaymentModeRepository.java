package nic.rti.master.dao;

import nic.rti.master.entity.PaymentMode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GetPaymentModeRepository extends JpaRepository<PaymentMode, String> {
}

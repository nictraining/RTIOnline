package com.example.RtiPioApi.repository.pio;

import com.example.RtiPioApi.entity.pio.AdditionalPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AdditionalPaymentRepository extends JpaRepository<AdditionalPayment, Long> {

    long countByRegistrationNoInAndPaid(List<String> registrationNos, String paidStatus);



    List<AdditionalPayment> findByRegistrationNoAndPaid(String registrationNo, String paid);
}

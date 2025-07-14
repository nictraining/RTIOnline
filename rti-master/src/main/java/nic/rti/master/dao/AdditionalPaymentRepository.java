package nic.rti.master.repository;

import com.example.piodatech.entity.AdditionalPayment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AdditionalPaymentRepository extends JpaRepository<AdditionalPayment, String> {

    @Query(value = "SELECT COUNT(*) FROM \"RTIMIS\".\"Request\" R JOIN \"RTIMIS\".\"AdditionalPayment\" AP ON R.registration_no = AP.registration_no WHERE R.pio_id = :pioId AND R.closing_date IS NULL AND AP.paid = 'N' AND R.requestStatus IN ('N', 'P') AND R.currentActionStatus = '4C'", nativeQuery = true)
    Long countPaymentDemanded(@Param("pioId") Integer pioId);

    @Query(value = "SELECT COUNT(*) FROM \"RTIMIS\".\"Request\" R JOIN \"RTIMIS\".\"AdditionalPayment\" AP ON R.registration_no = AP.registration_no WHERE R.pio_id = :pioId AND R.closing_date IS NULL AND AP.paid = 'Y' AND R.requestStatus IN ('N', 'P') AND R.currentActionStatus = '4D'", nativeQuery = true)
    Long countPaymentReceived(@Param("pioId") Integer pioId);
}

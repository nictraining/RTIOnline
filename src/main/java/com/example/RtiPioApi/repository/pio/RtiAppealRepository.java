
package com.example.RtiPioApi.repository.pio;

import com.example.RtiPioApi.entity.pio.RtiAppeal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface RtiAppealRepository extends JpaRepository<RtiAppeal, String> {

    List<RtiAppeal> findByRequestNo(String requestNo);


    long countByCpioAppAndClosingDateIsNotNull(@Param("cpioApp") String cpioApp);


    long countByCpioApp(@Param("cpioApp") String cpioApp);



    List<RtiAppeal> findByCpioAppAndStatus(String cpioApp, String status);


    long countByClosingDateIsNullAndAppealFilingDateBefore(LocalDateTime filingDateBefore);


    List<RtiAppeal> findByCpioApp(String cpioApp);
}

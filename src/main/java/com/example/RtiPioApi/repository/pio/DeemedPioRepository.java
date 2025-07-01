package com.example.RtiPioApi.repository.pio;

import com.example.RtiPioApi.entity.pio.DeemedPio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeemedPioRepository extends JpaRepository<DeemedPio, Long> {

    List<DeemedPio> findByRegistrationNoInAndFlagIn(List<String> registrationNos, List<String> flags);

    long countByRegistrationNoInAndFlag(List<String> registrationNos, String flag);
}

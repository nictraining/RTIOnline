package com.example.RtiPioApi.repository.pio;

import com.example.RtiPioApi.entity.pio.PioDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PioDetailsRepository extends JpaRepository<PioDetails, String> {

    Optional<PioDetails> findByPioIdAndActiveIdle(String pioId, String activeIdle);
}


package com.example.RtiPioApi.repository.pio;

import com.example.RtiPioApi.entity.pio.ReminderDpio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface ReminderDpioRepository extends JpaRepository<ReminderDpio, Long> {
    long countByPioIdAndReplyIsNotNull(String pioId);


    List<ReminderDpio> findByRegistrationNo(String registrationNo);
}


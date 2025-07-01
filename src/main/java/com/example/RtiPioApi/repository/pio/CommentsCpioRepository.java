package com.example.RtiPioApi.repository.pio;

import com.example.RtiPioApi.entity.pio.CommentsCpio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CommentsCpioRepository extends JpaRepository<CommentsCpio, Long> {

    long countByRegistrationNoInAndFlag(List<String> registrationNos, String flag);


    List<CommentsCpio> findByRegistrationNoAndFlag(String registrationNo, String flag);
}

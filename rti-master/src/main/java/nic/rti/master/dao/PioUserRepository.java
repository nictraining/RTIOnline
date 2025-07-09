package nic.rti.master.repository;

import nic.rti.master.entity.PioUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PioUserRepository extends JpaRepository<PioUser, Integer> {
    Optional<PioUser> findByUsername(String username);
}
package com.example.rti.repository;

import com.example.rti.entity.NetUser;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface NetUserRepository extends JpaRepository<NetUser, Integer> {
    Optional<NetUser> findByUserName(String userName);
}

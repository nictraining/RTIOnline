package com.example.RtiPioApi.repository.user;

import com.example.RtiPioApi.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
// CORRECTED: JpaRepository should be parameterized with the Entity class (User) and its ID type (String)
public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByUsername(String username);

    Optional<User> findByUserId(String userId);
}

package nic.rti.master.repository;

import nic.rti.master.entity.GetNetUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetNetUserRepository extends JpaRepository<GetNetUser, String> {
}
package nic.rti.master.repository;

import nic.rti.master.entity.GetPIODetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetPIODetailsRepository extends JpaRepository<GetPIODetails, Integer> {
}
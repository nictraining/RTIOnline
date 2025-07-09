package nic.rti.master.repository;

import nic.rti.master.entity.GetNodalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetNodalDetailsRepository extends JpaRepository<GetNodalDetails, Integer> {
}
package nic.rti.master.dao;

import nic.rti.master.entity.RequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestRepository extends JpaRepository<RequestEntity, Long> {
    Long countByStatus(String status);
}

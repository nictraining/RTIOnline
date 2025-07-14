package nic.rti.master.dao;

import nic.rti.master.entity.AppealEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppealRepository extends JpaRepository<AppealEntity, Long> {
    Long countByStatus(String status);
}

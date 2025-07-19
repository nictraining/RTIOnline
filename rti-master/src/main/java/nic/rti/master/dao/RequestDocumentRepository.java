package nic.rti.master.dao;

import nic.rti.master.entity.RequestDocumentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestDocumentRepository extends JpaRepository<RequestDocumentEntity, Long> {
    Long countByCalledTrue();
}

package nic.rti.master.dao;


import nic.rti.master.entity.AppealReason;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetAppealReasonRepository extends JpaRepository<AppealReason, String> {
}

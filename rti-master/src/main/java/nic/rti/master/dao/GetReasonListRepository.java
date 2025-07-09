package nic.rti.master.dao;


import nic.rti.master.entity.ReasonList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetReasonListRepository extends JpaRepository<ReasonList, String> {
}

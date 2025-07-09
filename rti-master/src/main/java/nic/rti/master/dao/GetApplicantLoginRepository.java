package nic.rti.master.dao;


import nic.rti.master.entity.ApplicantLogin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetApplicantLoginRepository extends JpaRepository<ApplicantLogin,String> {
}

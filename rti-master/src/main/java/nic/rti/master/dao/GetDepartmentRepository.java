package nic.rti.master.repository;

import nic.rti.master.entity.GetDepartment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetDepartmentRepository extends JpaRepository<GetDepartment, Integer> {
}
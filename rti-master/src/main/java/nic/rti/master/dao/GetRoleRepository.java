package nic.rti.master.dao;


import nic.rti.master.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetRoleRepository extends JpaRepository<Role, String> {
}

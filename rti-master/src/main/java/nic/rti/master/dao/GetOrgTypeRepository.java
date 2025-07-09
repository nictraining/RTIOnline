package nic.rti.master.dao;

import nic.rti.master.entity.OrgType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GetOrgTypeRepository extends JpaRepository<OrgType, String> {
}

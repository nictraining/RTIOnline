package nic.rti.master.dao;

import nic.rti.master.entity.ActionCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetActionCategoryRepository extends JpaRepository<ActionCategory,String> {
}

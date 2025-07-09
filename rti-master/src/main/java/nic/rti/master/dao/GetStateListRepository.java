package nic.rti.master.dao;

import nic.rti.master.entity.GetStateList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetStateListRepository extends JpaRepository<GetStateList, String> {
}

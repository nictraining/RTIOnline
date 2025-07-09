package nic.rti.master.dao;

import nic.rti.master.entity.UserList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GetUserListRepository extends JpaRepository<UserList, String> {
}

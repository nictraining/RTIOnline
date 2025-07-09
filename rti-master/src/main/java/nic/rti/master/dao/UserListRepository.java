package nic.rti.master.dao;

import nic.rti.master.entity.UserList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserListRepository extends JpaRepository<UserList, String> {
    UserList findByUserName(String userName);  
}

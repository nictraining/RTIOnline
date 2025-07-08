package nic.rti.master.service;

import nic.rti.master.dao.GetUserListRepository;
import nic.rti.master.entity.UserList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetUserListService {

    @Autowired
    private GetUserListRepository userListRepository;

    public List<UserList> getUserList() {
        return userListRepository.findAll(Sort.by("userName"));
    }

}

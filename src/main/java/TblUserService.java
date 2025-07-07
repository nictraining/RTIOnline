package nic.rti.master.service;

import nic.rti.master.entity.TblUser;
import nic.rti.master.dao.TblUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TblUserService {

    @Autowired
    private TblUserRepository tblUserRepository;

    public List<TblUser> getAllUsers() {
        return tblUserRepository.findAll();
    }
    public TblUser addUser(TblUser user) {
        return tblUserRepository.save(user);
    }
}
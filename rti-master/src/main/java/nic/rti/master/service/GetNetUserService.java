package nic.rti.master.service;

import nic.rti.master.entity.GetNetUser;
import nic.rti.master.repository.GetNetUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GetNetUserService {
    @Autowired
    private GetNetUserRepository netUserRepository;

    public List<GetNetUser> getAllUsers() {
        return netUserRepository.findAll();
    }

    public Optional<GetNetUser> getUserById(String userCode) {
        return netUserRepository.findById(userCode);
    }
}


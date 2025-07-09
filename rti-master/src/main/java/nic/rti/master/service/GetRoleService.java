package nic.rti.master.service;


import nic.rti.master.dao.GetRoleRepository;
import nic.rti.master.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetRoleService {

    @Autowired
    private GetRoleRepository roleRepository;

    public List<Role> getRole(){
        return roleRepository.findAll(Sort.by(Sort.Direction.ASC,"description"));
    }

}

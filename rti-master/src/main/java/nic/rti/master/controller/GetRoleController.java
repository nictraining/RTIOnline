package nic.rti.master.controller;


import nic.rti.master.entity.Role;
import nic.rti.master.service.GetRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetRoleController {

    @Autowired
    private GetRoleService roleService;

    @GetMapping(value = "/GetRole", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Role>> getRole(){
        List<Role> role = roleService.getRole();
        if(role != null && !role.isEmpty()){
            return new ResponseEntity<>(role, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

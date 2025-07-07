package com.example.RTI.online.controller;

import com.example.RTI.online.entity.TblUser;
import com.example.RTI.online.service.TblUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/RTI-online")
public class TblUserController {
    @Autowired
    private TblUserService tblUserService;

    @GetMapping("/GetUserList")
    public List<TblUser> getAllUsers() {
        return tblUserService.getAllUsers();
    }

    @PostMapping("/addUser")
    public TblUser addUser(@RequestBody TblUser user) {
        return tblUserService.addUser(user);
    }
}
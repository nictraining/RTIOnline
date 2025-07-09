package nic.rti.master.controller;

import nic.rti.master.entity.GetNetUser;
import nic.rti.master.service.GetNetUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/rti-master")
public class GetNetUserController {

    @Autowired
    private GetNetUserService netUserService;

    @GetMapping("/GetApplicantlogin")
    public List<GetNetUser> getAllApplicants() {
        return netUserService.getAllUsers();
    }

    @GetMapping("/GetApplicantlogin/{userCode}")
    public Optional<GetNetUser> getUserById(@PathVariable String userCode) {
        return netUserService.getUserById(userCode);
    }
}
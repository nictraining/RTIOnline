package nic.rti.master.controller;

package nic.rti.master.controller;

import nic.rti.master.entity.TblUser;
import nic.rti.master.service.TblUserService;
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
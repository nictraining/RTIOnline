package nic.rti.master.controller;

import nic.rti.master.entity.UserList;
import nic.rti.master.service.GetUserListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetUserListController {

    @Autowired
    private GetUserListService userListService;

    @GetMapping(value = "/GetUserList", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<UserList> getUserList() {
        return userListService.getUserList();
    }

}

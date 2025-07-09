package nic.rti.master.controller;

import nic.rti.master.entity.GetStateList;
import nic.rti.master.service.GetStateListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetStateListController {

    @Autowired
    private GetStateListService getStateListService;

    @GetMapping(value = "/GetStateList", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GetStateList> getStates() {
        return getStateListService.getAllStates();
    }
}

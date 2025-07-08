package nic.rti.master.controller;


import nic.rti.master.entity.ReasonList;
import nic.rti.master.service.GetReasonListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetReasonListController {

    @Autowired
    private GetReasonListService reasonListService;

    @GetMapping(value = "/GetReasonList", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReasonList> getReasonList() {
        return reasonListService.getReasonList();
    }

}

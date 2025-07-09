package nic.rti.master.controller;

import nic.rti.master.entity.GetNodalDetails;
import nic.rti.master.service.GetNodalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rti-master")
public class GetNodalDetailsController {

    @Autowired
    private GetNodalDetailsService service;

    @GetMapping("/GetNodalOfficerList")
    public List<GetNodalDetails> getAll() {
        return service.getAll();
    }

}
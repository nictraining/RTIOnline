package nic.rti.master.controller;

import nic.rti.master.entity.GetPIODetails;
import nic.rti.master.service.GetPIODetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rti-master")
public class GetPIODetailsController {

    @Autowired
    private GetPIODetailsService service;

    @GetMapping("/GetSPIOList")
    public List<GetPIODetails> getAll() {
        return service.getAll();
    }

}
package nic.rti.master.controller;

import nic.rti.master.entity.GetPIODetails;
import nic.rti.master.service.GetPIODetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GetPIODetailsController {

    @Autowired
    private GetPIODetailsService service;

    @GetMapping("/GetSPIOList")
    public ResponseEntity<List<GetPIODetails>> getAll() {
        List<GetPIODetails> all = service.getAll();
        if(all != null && !all.isEmpty()){
            return new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
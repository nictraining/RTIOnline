package nic.rti.master.controller;

import nic.rti.master.entity.GetNodalDetails;
import nic.rti.master.service.GetNodalDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GetNodalDetailsController {

    @Autowired
    private GetNodalDetailsService service;

    @GetMapping("/GetNodalOfficerList")
    public ResponseEntity<List<GetNodalDetails>> getAll() {

        List<GetNodalDetails> all = service.getAll();
        if(all !=null && !all.isEmpty()){
            return  new ResponseEntity<>(all, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
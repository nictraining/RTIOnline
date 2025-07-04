package nic.rti.master.controller;


import nic.rti.master.dao.GetTitleRepository;
import nic.rti.master.entity.Title;
import nic.rti.master.service.GetTitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetTitleController {

    @Autowired
    private GetTitleService titleService;

    @GetMapping(value = "/GetTitle", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Title>> getTitle() {

        List<Title> title = titleService.getTitle();
        if(title != null && !title.isEmpty()){
            return new ResponseEntity<>(title, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}

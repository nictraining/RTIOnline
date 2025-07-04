package nic.rti.master.controller;


import nic.rti.master.entity.ReasonList;
import nic.rti.master.service.GetReasonListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetReasonListController {

    @Autowired
    private GetReasonListService reasonListService;

    @GetMapping(value = "/GetReasonList", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getReasonList()
    {
        try{
            List<ReasonList> reasonList = reasonListService.getReasonList();
            if(reasonList !=null && !reasonList.isEmpty()){
                return new ResponseEntity<>(reasonList,HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getCause().getMessage(), HttpStatus.CONFLICT);
        }

    }

}

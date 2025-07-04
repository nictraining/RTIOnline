package nic.rti.master.controller;


import nic.rti.master.entity.AppealReason;
import nic.rti.master.service.GetAppealReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAppealReasonController {

    @Autowired
    private GetAppealReasonService getAppealReasonService;

    @GetMapping(value = "/GetAppealReason", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getAppealReason() {
        try{
            List<AppealReason> appealReason = getAppealReasonService.getAppealReason();
            if(appealReason != null && !appealReason.isEmpty()){
                return new ResponseEntity<>(appealReason, HttpStatus.OK);
            }
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }catch (RuntimeException e){
            return new ResponseEntity<>(e.getCause().getMessage(),HttpStatus.CONFLICT);
        }

    }

}

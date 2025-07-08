package nic.rti.master.controller;


import nic.rti.master.entity.AppealReason;
import nic.rti.master.service.GetAppealReasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetAppealReasonController {

    @Autowired
    private GetAppealReasonService getAppealReasonService;

    @GetMapping(value = "/GetAppealReason", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<AppealReason> getAppealReason() {
        return getAppealReasonService.getAppealReason();
    }

}

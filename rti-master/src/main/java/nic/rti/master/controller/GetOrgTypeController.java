package nic.rti.master.controller;


import nic.rti.master.entity.OrgType;
import nic.rti.master.service.GetOrgTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetOrgTypeController {

    @Autowired
    private GetOrgTypeService orgTypeService;

    @GetMapping(value = "/GetOrgType", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<OrgType> getOrgType() {
        return orgTypeService.getOrgType();
    }

}

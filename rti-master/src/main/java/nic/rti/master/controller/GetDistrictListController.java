package nic.rti.master.controller;


import nic.rti.master.entity.DistrictList;
import nic.rti.master.service.GetDistrictListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetDistrictListController {

    @Autowired
    private GetDistrictListService getDistrictListService;

    @GetMapping(value = "/GetDistrictList", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DistrictList> getDistrictList(@RequestParam String state_code) {
        return getDistrictListService.getDistrictList(state_code);
    }
}

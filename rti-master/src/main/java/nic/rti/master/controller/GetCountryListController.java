package nic.rti.master.controller;

import nic.rti.master.entity.GetCountryList;
import nic.rti.master.service.GetCountryListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetCountryListController {

    @Autowired
    private GetCountryListService getCountryListService;

    @GetMapping(value = "/GetCountryList", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<GetCountryList> getCountryList() {
        List<GetCountryList> GetCountryList = getCountryListService.getCountryList();
        return GetCountryList;
    }
}

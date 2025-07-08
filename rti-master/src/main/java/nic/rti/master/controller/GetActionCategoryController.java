package nic.rti.master.controller;

import nic.rti.master.entity.ActionCategory;
import nic.rti.master.service.GetActionCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetActionCategoryController {

    @Autowired
    private GetActionCategoryService actionCategoryService;

    @GetMapping(value = "/GetActionCategory", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ActionCategory> getActionCategory(){
        return actionCategoryService.getActionCategory();
    }

}

package nic.rti.master.controller;


import nic.rti.master.entity.Category;
import nic.rti.master.service.GetCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetCategoryController {

    @Autowired
    private GetCategoryService categoryService;

    @GetMapping(value = "/GetCategory", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Category> getCategoryList(){
        return categoryService.getCategoryList();
    }

}

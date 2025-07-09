package nic.rti.master.controller;

import nic.rti.master.entity.GetDepartment;
import nic.rti.master.service.GetDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rti-master")
public class GetDepartmentController {

    @Autowired
    private GetDepartmentService service;

    @GetMapping("/GetDepartmentList")
    public List<GetDepartment> getDepartments() {
        return service.getAllDepartments();
    }
}
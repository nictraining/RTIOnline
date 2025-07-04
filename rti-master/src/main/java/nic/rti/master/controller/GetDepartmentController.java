package nic.rti.master.controller;

import nic.rti.master.entity.GetDepartment;
import nic.rti.master.service.GetDepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GetDepartmentController {

    @Autowired
    private GetDepartmentService service;

    @GetMapping("/GetDepartmentList")
    public ResponseEntity<?> getDepartments() {
        try{
            List<GetDepartment> allDepartments = service.getAllDepartments();
            if(allDepartments !=null && !allDepartments.isEmpty()){
                return new ResponseEntity<>(allDepartments, HttpStatus.OK);
            }
            return  new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }catch(RuntimeException e){
            return new  ResponseEntity<>(e.getCause().getMessage(),HttpStatus.CONFLICT);
        }

    }
}
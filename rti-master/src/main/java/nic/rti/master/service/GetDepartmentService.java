package nic.rti.master.service;

import nic.rti.master.entity.GetDepartment;
import nic.rti.master.repository.GetDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetDepartmentService {
    @Autowired
    private GetDepartmentRepository repository;
    public List<GetDepartment> getAllDepartments() {
        return repository.findAll();
    }
}
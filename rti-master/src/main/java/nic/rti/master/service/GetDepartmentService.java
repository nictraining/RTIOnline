package nic.rti.master.service;

import lombok.extern.slf4j.Slf4j;
import nic.rti.master.entity.GetDepartment;
import nic.rti.master.repository.GetDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GetDepartmentService {
    @Autowired
    private GetDepartmentRepository repository;
    public List<GetDepartment> getAllDepartments() {
        try{
            return repository.findAll();
        }catch (Exception e){
            log.error("Exception",e);
            throw new RuntimeException(e);
        }

    }
}
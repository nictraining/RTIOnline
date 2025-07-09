package nic.rti.master.service;

import nic.rti.master.dao.GetApplicantLoginRepository;
import nic.rti.master.entity.ApplicantLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetApplicantLoginService {

    @Autowired
    private GetApplicantLoginRepository applicantLoginRepository;

    public List<ApplicantLogin> getApplicantLogin(){
        return applicantLoginRepository.findAll(Sort.by("name"));
    }

}

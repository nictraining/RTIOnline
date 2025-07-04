package nic.rti.master.service;

import lombok.extern.slf4j.Slf4j;
import nic.rti.master.dao.GetApplicantLoginRepository;
import nic.rti.master.entity.ApplicantLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class GetApplicantLoginService {

    @Autowired
    private GetApplicantLoginRepository applicantLoginRepository;

    public List<ApplicantLogin> getApplicantLogin(){
        try{
            return  applicantLoginRepository.findAll(Sort.by("name"));

        }catch (Exception e){
            log.error("failed to fetch data",e);
            return Collections.emptyList();
        }


    }

}

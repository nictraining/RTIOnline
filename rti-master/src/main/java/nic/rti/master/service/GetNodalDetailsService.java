package nic.rti.master.service;

import lombok.extern.slf4j.Slf4j;
import nic.rti.master.entity.GetNodalDetails;
import nic.rti.master.repository.GetNodalDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class GetNodalDetailsService {

    @Autowired
    private GetNodalDetailsRepository repository;

    public List<GetNodalDetails> getAll() {
        try{
            return repository.findAll();
        }catch (Exception e){
            log.error("Exception",e);
            return Collections.emptyList();
        }

    }
}
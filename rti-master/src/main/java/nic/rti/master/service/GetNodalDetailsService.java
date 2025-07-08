package nic.rti.master.service;

import nic.rti.master.entity.GetNodalDetails;
import nic.rti.master.repository.GetNodalDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetNodalDetailsService {

    @Autowired
    private GetNodalDetailsRepository repository;

    public List<GetNodalDetails> getAll() {
        return repository.findAll();
    }
}
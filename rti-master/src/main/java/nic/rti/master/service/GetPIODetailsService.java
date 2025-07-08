package nic.rti.master.service;

import nic.rti.master.entity.GetPIODetails;
import nic.rti.master.repository.GetPIODetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPIODetailsService {

    @Autowired
    private GetPIODetailsRepository repository;

    public List<GetPIODetails> getAll() {
        return repository.findAll();
    }
}
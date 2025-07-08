package nic.rti.master.service;

import nic.rti.master.dao.GetStateListRepository;
import nic.rti.master.entity.GetStateList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetStateListService {

    @Autowired
    private GetStateListRepository getStateListRepository;

    public List<GetStateList> getAllStates() {
        return getStateListRepository.findAll();
    }
}

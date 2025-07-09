package nic.rti.master.service;

import nic.rti.master.dao.GetCountryListRepository;
import nic.rti.master.entity.GetCountryList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCountryListService {

    @Autowired
    private GetCountryListRepository getCountryListRepository;

    public List<GetCountryList> getCountryList() {
        List<GetCountryList> getCountryList = getCountryListRepository.getCountryList();
        return getCountryList;
    }
}


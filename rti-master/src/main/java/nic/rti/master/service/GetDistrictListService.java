package nic.rti.master.service;

import nic.rti.master.dao.GetDistrictListRepository;
import nic.rti.master.entity.DistrictList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetDistrictListService {

    @Autowired
    private GetDistrictListRepository getDistrictListRepository;

    public List<DistrictList> getDistrictList(String stateCode) {
        return getDistrictListRepository.findByStateCode(stateCode, Sort.by("district"));
    }

}

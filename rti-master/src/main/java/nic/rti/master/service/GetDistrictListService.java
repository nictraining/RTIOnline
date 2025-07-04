package nic.rti.master.service;

import lombok.extern.slf4j.Slf4j;
import nic.rti.master.dao.GetDistrictListRepository;
import nic.rti.master.entity.DistrictList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class GetDistrictListService {

    @Autowired
    private GetDistrictListRepository getDistrictListRepository;

    public List<DistrictList> getDistrictList(String stateCode) {
        try{
            return getDistrictListRepository.findByStateCode(stateCode, Sort.by("district"));
        }catch (Exception e){
            log.error("Exception",e);
            return Collections.emptyList();
        }

    }

}

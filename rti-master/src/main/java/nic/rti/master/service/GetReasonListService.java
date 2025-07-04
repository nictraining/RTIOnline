package nic.rti.master.service;


import lombok.extern.slf4j.Slf4j;
import nic.rti.master.dao.GetReasonListRepository;
import nic.rti.master.entity.ReasonList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GetReasonListService {

    @Autowired
    private GetReasonListRepository reasonListRepository;

    public List<ReasonList> getReasonList() {
        try{
            return reasonListRepository.findAll(Sort.by("reasonDtls"));

        }catch (Exception e){
            log.error("Exception",e);
            throw new RuntimeException(e);
        }
    }

}

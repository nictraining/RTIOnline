package nic.rti.master.service;


import nic.rti.master.dao.GetReasonListRepository;
import nic.rti.master.entity.ReasonList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetReasonListService {

    @Autowired
    private GetReasonListRepository reasonListRepository;

    public List<ReasonList> getReasonList() {
        return reasonListRepository.findAll(Sort.by("reasonDtls"));
    }

}

package nic.rti.master.service;


import lombok.extern.slf4j.Slf4j;
import nic.rti.master.dao.GetAppealReasonRepository;
import nic.rti.master.entity.AppealReason;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
@Slf4j
@Service
public class GetAppealReasonService {

    @Autowired
    private GetAppealReasonRepository getAppealReasonRepository;

    public List<AppealReason> getAppealReason() {
         try{
             return getAppealReasonRepository.findAll(Sort.by("appReason"));
         }catch (Exception e){
             log.error("Exception",e);
             throw new RuntimeException(e);
         }

    }

}

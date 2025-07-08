package nic.rti.master.service;


import nic.rti.master.dao.GetAppealReasonRepository;
import nic.rti.master.entity.AppealReason;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAppealReasonService {

    @Autowired
    private GetAppealReasonRepository getAppealReasonRepository;

    public List<AppealReason> getAppealReason() {
        return getAppealReasonRepository.findAll(Sort.by("appReason"));
    }

}

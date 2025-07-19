package nic.rti.master.service.impl;

import nic.rti.master.dao.RequestRepository;
import nic.rti.master.dao.AppealRepository;
import nic.rti.master.dao.RequestDocumentRepository;
import nic.rti.master.service.GetDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetDashboardServiceImpl implements GetDashboardService {

    @Autowired
    private RequestRepository requestRepository;

    @Autowired
    private AppealRepository appealRepository;

    @Autowired
    private RequestDocumentRepository documentRepository;

    @Override
    public Long getNewRequestCount() {
        return requestRepository.countByStatus("NEW");
    }

    @Override
    public Long getNewAppealCount() {
        return appealRepository.countByStatus("NEW");
    }

    @Override
    public Long getDocumentCalledCount() {
        return documentRepository.countByCalledTrue();
    }
}

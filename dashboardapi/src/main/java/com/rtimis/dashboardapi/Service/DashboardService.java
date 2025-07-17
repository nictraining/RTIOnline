package com.rtimis.dashboardapi.service;

import com.rtimis.dashboardapi.repository.RequestRepository;
import com.rtimis.dashboardapi.repository.AppealRepository;
import com.rtimis.dashboardapi.dto.DashboardResponse;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {

    private final RequestRepository requestRepository;
    private final AppealRepository appealRepository;

    public DashboardService(RequestRepository requestRepository, AppealRepository appealRepository) {
        this.requestRepository = requestRepository;
        this.appealRepository = appealRepository;
    }

    public DashboardResponse getDashboardStats(String userCode) {
        DashboardResponse response = new DashboardResponse();

        response.getRequests().put("registered", String.valueOf(requestRepository.countRegistered(userCode)));
        response.getRequests().put("disposed", String.valueOf(requestRepository.countDisposed(userCode)));
        response.getRequests().put("pending", String.valueOf(requestRepository.countPending(userCode)));

        response.getAppeals().put("registered", String.valueOf(appealRepository.countRegistered(userCode)));
        response.getAppeals().put("disposed", String.valueOf(appealRepository.countDisposed(userCode)));
        response.getAppeals().put("pending", String.valueOf(appealRepository.countPending(userCode)));

        return response;
    }
}

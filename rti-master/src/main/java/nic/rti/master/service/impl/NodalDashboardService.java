package com.example.rtionlinepj.service;

import com.example.rtionlinepj.dao.NodalDashboardDao;
import com.example.rtionlinepj.dto.NodalDashboardSummaryDto;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NodalDashboardService {

    private final NodalDashboardDao dao;

    public NodalDashboardService(NodalDashboardDao dao) {
        this.dao = dao;
    }

    @Transactional(readOnly = true)
    public NodalDashboardSummaryDto getSummary(long orgCode) {
        return dao.fetchSummary(orgCode);
    }
}

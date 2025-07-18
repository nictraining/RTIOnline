package com.example.rtionlinepj.dao;

import com.example.rtionlinepj.dto.NodalDashboardSummaryDto;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NodalDashboardDao {

    private final JdbcTemplate jdbcTemplate;

    public NodalDashboardDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public NodalDashboardSummaryDto fetchSummary(long orgCode) throws DataAccessException {
        long newRequests = countNewRequests(orgCode);
        long newAppeals  = countNewAppeals(orgCode);   // currently returns 0 (TODO)
        long docCalled   = countDocCalled(orgCode);    // request-side real + appeal-side TODO
        return new NodalDashboardSummaryDto(newRequests, newAppeals, docCalled);
    }

    private long countNewRequests(long orgCode) {
        String sql = """
            SELECT COUNT(*) 
            FROM "RTIMIS"."Request" r
            WHERE r.orgcode = ?
              AND (r.pio_id IS NULL OR r.pio_id = 0)
              AND r.requeststatus = 'N'
              AND (r.currentactionstatus IN ('4M','00') OR r.currentactionstatus IS NULL)
              AND r.closingdate IS NULL
              AND SUBSTRING(r.registrationno,14,1) <> '7'
            """;
        return jdbcTemplate.queryForObject(sql, Long.class, orgCode);
    }


    private long countNewAppeals(long orgCode) {
        return 0L; // TODO implement once Appeal schema confirmed
    }

    private long countDocCalled(long orgCode) {
        long reqCount = countDocCalledRequests(orgCode);
        long appCount = 0L; // TODO implement appeals once schema known
        return reqCount + appCount;
    }

    private long countDocCalledRequests(long orgCode) {
        String sql = """
            SELECT COUNT(*)
            FROM "RTIMIS"."Request" r
            WHERE r.orgcode = ?
              AND r.currentactionstatus = '4L'
              AND r.closingdate IS NULL
            """;
        return jdbcTemplate.queryForObject(sql, Long.class, orgCode);
    }
}

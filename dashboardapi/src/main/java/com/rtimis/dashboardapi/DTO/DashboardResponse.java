package com.rtimis.dashboardapi.dto;

import java.util.HashMap;
import java.util.Map;

public class DashboardResponse {

    private Map<String, String> requests = new HashMap<>();
    private Map<String, String> appeals = new HashMap<>();

    public Map<String, String> getRequests() {
        return requests;
    }

    public Map<String, String> getAppeals() {
        return appeals;
    }
}

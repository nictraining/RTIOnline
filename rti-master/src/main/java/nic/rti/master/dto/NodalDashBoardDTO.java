package com.example.rtionlinepj.dto;

public class NodalDashboardSummaryDto {
    private long newRequests;
    private long newAppeals;
    private long documentRequests;

    public NodalDashboardSummaryDto() {}

    public NodalDashboardSummaryDto(long newRequests, long newAppeals, long documentRequests) {
        this.newRequests = newRequests;
        this.newAppeals = newAppeals;
        this.documentRequests = documentRequests;
    }

    public long getNewRequests() {
        return newRequests;
    }

    public void setNewRequests(long newRequests) {
        this.newRequests = newRequests;
    }

    public long getNewAppeals() {
        return newAppeals;
    }

    public void setNewAppeals(long newAppeals) {
        this.newAppeals = newAppeals;
    }

    public long getDocumentRequests() {
        return documentRequests;
    }

    public void setDocumentRequests(long documentRequests) {
        this.documentRequests = documentRequests;
    }
}

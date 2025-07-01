package com.example.RtiPioApi.dto.pio;

import java.util.List;

public class RtiRequestPagedResponse {
    private String status;
    private List<RtiRequestListDTO> data;
    private PaginationInfoDTO pagination;

    public RtiRequestPagedResponse(String status, List<RtiRequestListDTO> data, PaginationInfoDTO pagination) {
        this.status = status;
        this.data = data;
        this.pagination = pagination;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<RtiRequestListDTO> getData() {
        return data;
    }

    public void setData(List<RtiRequestListDTO> data) {
        this.data = data;
    }

    public PaginationInfoDTO getPagination() {
        return pagination;
    }

    public void setPagination(PaginationInfoDTO pagination) {
        this.pagination = pagination;
    }
}



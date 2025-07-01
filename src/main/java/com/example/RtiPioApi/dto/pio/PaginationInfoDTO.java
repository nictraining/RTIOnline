package com.example.RtiPioApi.dto.pio;

public class PaginationInfoDTO {
    private Integer limit;
    private Integer offset;
    private Long totalCount;

    public PaginationInfoDTO(Integer limit, Integer offset, Long totalCount) {
        this.limit = limit;
        this.offset = offset;
        this.totalCount = totalCount;
    }

    // Getters
    public Integer getLimit() {
        return limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    // Setters (if needed for DTO construction via JSON deserialization)
    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
}

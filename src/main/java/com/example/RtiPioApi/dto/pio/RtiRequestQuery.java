package com.example.RtiPioApi.dto.pio;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class RtiRequestQuery {
    @NotBlank(message = "Record type cannot be empty")
    private String recordType; // e.g., "PENDING_20_DAYS", "NEW", "UNDER_PROCESS"

    @NotNull(message = "CPIO ID cannot be null")
    private String cpioId; // Central Public Information Officer ID

    @Min(value = 0, message = "Limit must be a non-negative number")
    private Integer limit = 50; // Maximum number of records to return (default: 50)

    @Min(value = 0, message = "Offset must be a non-negative number")
    private Integer offset = 0;

    // Getters and Setters
    public String getRecordType() {
        return recordType;
    }

    public void setRecordType(String recordType) {
        this.recordType = recordType;
    }

    public String getCpioId() {
        return cpioId;
    }

    public void setCpioId(String cpioId) {
        this.cpioId = cpioId;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }
}


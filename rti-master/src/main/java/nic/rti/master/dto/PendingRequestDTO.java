package nic.rti.master.dto;

import lombok.Data;

@Data
public class PendingRequestDTO {
    private String recordsType;
    private Integer applId;
    private Integer limit=50;
    private Integer offset=0;
}

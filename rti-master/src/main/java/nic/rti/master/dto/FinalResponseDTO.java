package nic.rti.master.dto;

import java.util.List;
import lombok.Data;

@Data
public class FinalResponseDTO {
    private String status;
    private List<PendingRequestResponseDTO> data;
    private PaginationDTO pagination;
    // constructor
    public FinalResponseDTO(String status, List<PendingRequestResponseDTO> data, PaginationDTO pagination) {
        this.status = status;
        this.data = data;
        this.pagination = pagination;
    }

}

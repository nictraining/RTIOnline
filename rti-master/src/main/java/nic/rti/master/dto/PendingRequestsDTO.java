package nic.rti.master.dto;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class PendingRequestsDTO {

    private String registrationNo;
    private String name;
    private LocalDate receivedDate;
    private LocalDateTime entryDate;
}

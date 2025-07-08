package nic.rti.master.dto;

import lombok.Data;

@Data
public class PendingRequestResponseDTO {
    private String registrationNo;
    private String name;
    private String recvDate;
    private String entryDate;
    private String documentId; // nullable for some types
    private String commentsDate; // nullable
    private String comments;     // nullable
    private String pioName;      // nullable
}


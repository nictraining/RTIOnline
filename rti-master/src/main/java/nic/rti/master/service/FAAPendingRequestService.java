package nic.rti.master.service;

import nic.rti.master.dto.FinalResponseDTO;
import nic.rti.master.dto.PendingRequestDTO;

public interface FAAPendingRequestService {
    FinalResponseDTO fetchPendingRequests(PendingRequestDTO requestDTO);
}

package nic.rti.master.service;

import nic.rti.master.dto.PendingRequestsDTO;
import nic.rti.master.entity.Request;
import org.springframework.data.domain.Page;

public interface PendingRequestService {
    Page<PendingRequestsDTO> getPendingRequests(int orgCode, int page, int size);

    Request saveRequest(Request dto);
}

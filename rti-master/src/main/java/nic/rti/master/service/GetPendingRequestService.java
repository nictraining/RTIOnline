// antika


package nic.rti.master.service;

import nic.rti.master.dao.PendingRequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GetPendingRequestService {

    @Autowired
    private PendingRequestRepository pendingRequestRepository;

    public List<Map<String, Object>> getPendingRequests(String recordsType, String applId, int limit, int offset) {
    switch (recordsType.toUpperCase()) {
        case "UNDER_PROCESS":
            return pendingRequestRepository.getUnderProcess(applId, limit, offset);
        case "COMMENT_CPIO":
            return pendingRequestRepository.getCommentCpio(applId, limit, offset);
        case "MODIFY":
            return pendingRequestRepository.getModify(applId, limit, offset);
        case "NEW":
            return pendingRequestRepository.getNew(applId, limit, offset);
        case "PENDING_20_DAYS":
            return pendingRequestRepository.getPending20Days(applId, limit, offset);
        default:
            throw new IllegalArgumentException("Invalid records_type. Allowed: UNDER_PROCESS, COMMENT_CPIO, MODIFY, NEW, PENDING_20_DAYS");
    }
}


}


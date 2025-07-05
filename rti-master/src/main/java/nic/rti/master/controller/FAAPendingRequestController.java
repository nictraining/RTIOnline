package nic.rti.master.controller;

import lombok.RequiredArgsConstructor;
import nic.rti.master.dto.FinalResponseDTO;
import nic.rti.master.dto.PendingRequestDTO;
import nic.rti.master.service.FAAPendingRequestService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.InvalidParameterException;


@RestController
@RequestMapping("/rti-faa")
@RequiredArgsConstructor
public class FAAPendingRequestController {

    private final FAAPendingRequestService pendingRequestService;

    @GetMapping("/pending-requests")
    public FinalResponseDTO getPendingRequests(
            @RequestParam String records_type,
            @RequestParam Integer appl_id,
            @RequestParam(required = false, defaultValue = "50") Integer limit,
            @RequestParam(required = false, defaultValue = "0") Integer offset
    ) {
        PendingRequestDTO dto = new PendingRequestDTO();
        dto.setRecordsType(records_type);
        dto.setApplId(appl_id);
        dto.setLimit(limit);
        dto.setOffset(offset);

        return pendingRequestService.fetchPendingRequests(dto);
    }
    //EndPoint
    //http://localhost:8080/rti-master/rti-faa/pending-requests?records_type=UNDER_PROCESS&appl_id=123&limit=10&offset=0
}

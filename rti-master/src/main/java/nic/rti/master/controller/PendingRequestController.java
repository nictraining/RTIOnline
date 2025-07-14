package nic.rti.master.controller;

import nic.rti.master.dto.PendingRequestsDTO;
import nic.rti.master.entity.Request;
import nic.rti.master.service.PendingRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rti-nodal")
public class PendingRequestController {

    @Autowired
    private PendingRequestService service;

    @GetMapping("/pending-requests")
    public ResponseEntity<?> getPendingRequests(
            @RequestParam(defaultValue = "1") int org_code,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        try {
            if (org_code <= 0) {
                return ResponseEntity.badRequest().body("Invalid organization code.");
            }

            Page<PendingRequestsDTO> result = service.getPendingRequests(org_code, page, size);
            return ResponseEntity.ok(result);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body("Bad request: " + e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Server error: " + e.getMessage());
        }
    }

    @PostMapping("/request")
    public ResponseEntity<Request> saveRequest(@RequestBody Request dto) {
        Request saved = service.saveRequest(dto);
        return ResponseEntity.ok(saved);
    }

}

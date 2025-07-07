// antika

package nic.rti.master.controller;

import nic.rti.master.service.GetPendingRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/rti-faa")
public class GetPendingRequestController {

    @Autowired
    private GetPendingRequestService service;

    @GetMapping("/pending-requests")
    public ResponseEntity<?> getPendingRequests(
            @RequestParam String records_type,
            @RequestParam String appl_id,
            @RequestParam(defaultValue = "50") Integer limit,
            @RequestParam(defaultValue = "0") Integer offset
    ) {
        try {
            List<Map<String, Object>> data = service.getPendingRequests(records_type, appl_id, limit, offset);
            Map<String, Object> response = new HashMap<>();
            response.put("status", "success");
            response.put("data", data);
            response.put("pagination", Map.of(
                    "limit", limit,
                    "offset", offset,
                    "total_count", data.size(),
                    "has_more", data.size() == limit
            ));

            return ResponseEntity.ok(response);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(Map.of(
                    "status", "error",
                    "error_code", "INVALID_RECORD_TYPE",
                    "message", e.getMessage(),
                    "timestamp", new Date().toString()
            ));
        } catch (Exception e) {
            e.printStackTrace(); 
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("status", "error");
            errorResponse.put("error_code", "DATABASE_ERROR");
            errorResponse.put("message", e.getMessage());
            errorResponse.put("timestamp", new Date().toString());

            return ResponseEntity.internalServerError().body(errorResponse);
        }
    }
}

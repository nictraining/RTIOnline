package nic.rti.master.controller;

import nic.rti.master.service.GetDashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/nodal")
@CrossOrigin
public class NodalDashboardController {

    @Autowired
    private GetDashboardService dashboardService;

    @GetMapping("/dashboard/counts")
    public ResponseEntity<Map<String, Long>> getDashboardCounts() {
        Map<String, Long> result = new HashMap<>();
        result.put("newRequests", dashboardService.getNewRequestCount());
        result.put("newAppeals", dashboardService.getNewAppealCount());
        result.put("calledDocuments", dashboardService.getDocumentCalledCount());
        return ResponseEntity.ok(result);
    }
}

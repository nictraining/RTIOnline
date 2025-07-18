package com.example.rtionlinepj.controller;

import com.example.rtionlinepj.dto.ApiResponse;
import com.example.rtionlinepj.dto.NodalDashboardSummaryDto;
import com.example.rtionlinepj.service.NodalDashboardService;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rti-nodal")
public class NodalDashboardController {

    private final NodalDashboardService service;

    public NodalDashboardController(NodalDashboardService service) {
        this.service = service;
    }

    @GetMapping("/nodal-dashboard-summary")
    public ResponseEntity<?> getDashboardSummary(
            @RequestParam(name = "org_code") Long orgCode) {

        // Validate required query param; 400 if missing (per doc). :contentReference[oaicite:1]{index=1}
        if (orgCode == null) {
            ApiResponse<Void> resp = new ApiResponse<>("error", null, "Missing org_code");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(resp);
        }

        try {
            NodalDashboardSummaryDto summary = service.getSummary(orgCode);
            ApiResponse<NodalDashboardSummaryDto> resp = new ApiResponse<>("success", summary);
            return ResponseEntity.ok(resp); // success format from doc. :contentReference[oaicite:2]{index=2}
        } catch (DataAccessException ex) {
            ApiResponse<Void> resp = new ApiResponse<>("error", null, "Internal Server Error");
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(resp); // per doc. :contentReference[oaicite:3]{index=3}
        }
    }
}



    package com.rtimis.dashboardapi.Controller;
    import java.util.Map;

    import com.rtimis.dashboardapi.dto.DashboardResponse;
    import com.rtimis.dashboardapi.service.DashboardService;
    import org.springframework.http.ResponseEntity;
    import org.springframework.web.bind.annotation.*;

    @RestController
    @RequestMapping("/rti-citizen/dashboard")
    public class DashboardController {

        private final DashboardService dashboardService;

        public DashboardController(DashboardService dashboardService) {
            this.dashboardService = dashboardService;
        }

        @GetMapping("/{citizen_user_code}")
        public ResponseEntity<?> getDashboard(@PathVariable("citizen_user_code") String citizenUserCode) {
            DashboardResponse response = dashboardService.getDashboardStats(citizenUserCode);
            return ResponseEntity.ok().body(Map.of("status", "success", "data", response));
        }
    }

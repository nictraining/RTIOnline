package nic.rti.master.controller;

import nic.rti.master.dto.DashboardMetricsDTO;
import nic.rti.master.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/aa")

public class DashboardController {
    //rest api endpoint for FE for dashboard data
    @Autowired

    private DashboardService dashboardService;

    @GetMapping("/dashboard")
    public DashboardMetricsDTO dashboardMetricsDTO(@RequestParam String username){
        return dashboardService.getDashboardDataForUser(username);
    }

    @GetMapping("/test")
    public String testEndpoint() {
        return "DashboardController is working!";
    }


}

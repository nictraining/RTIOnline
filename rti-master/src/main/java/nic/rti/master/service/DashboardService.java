package nic.rti.master.service;

import nic.rti.master.dto.DashboardMetricsDTO;
import org.springframework.stereotype.Service;

@Service
public class DashboardService {
    public DashboardMetricsDTO getDashboardDataForUser(String username){
        //let's take some random data  later will take from DB
        return new DashboardMetricsDTO(

                2,
                1,
                3,
                4,
                "Tripura Public Service Commision", 
                "Appeallate Authority",
                username

        );
    }
}

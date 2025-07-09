package nic.rti.master.controller;


import nic.rti.master.entity.PaymentMode;
import nic.rti.master.service.GetPaymentModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetPaymentModeController {

    @Autowired
    private GetPaymentModeService paymentModeService;

    @GetMapping(value = "/GetPaymentMode", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PaymentMode> getPaymentMode() {
        return paymentModeService.getPaymentMode();
    }

}

package nic.rti.master.controller;


import nic.rti.master.entity.TransactionMode;
import nic.rti.master.service.GetTransactionModeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.print.attribute.standard.Media;
import java.util.List;

@RestController
public class GetTransactionModeController {

    @Autowired
    private GetTransactionModeService transactionModeService;

    @GetMapping(value = "/GetTransactionMode", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TransactionMode> getTransactionMode() {
        return transactionModeService.getTransactionMode();
    }

}

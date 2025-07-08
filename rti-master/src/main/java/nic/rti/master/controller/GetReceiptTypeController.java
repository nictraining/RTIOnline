package nic.rti.master.controller;


import nic.rti.master.entity.ReceiptType;
import nic.rti.master.service.GetReceiptTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GetReceiptTypeController {

    @Autowired
    private GetReceiptTypeService receiptTypeService;

    @GetMapping(value = "/GetReceiptType", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReceiptType> getReceiptType() {
        return receiptTypeService.getReceiptType();
    }

}

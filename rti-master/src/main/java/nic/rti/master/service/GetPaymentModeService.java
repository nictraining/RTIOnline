package nic.rti.master.service;


import nic.rti.master.dao.GetPaymentModeRepository;
import nic.rti.master.entity.PaymentMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetPaymentModeService {

    @Autowired
    private GetPaymentModeRepository paymentModeRepository;

    public List<PaymentMode> getPaymentMode() {
        return paymentModeRepository.findAll(Sort.by("payDetails"));
    }
}

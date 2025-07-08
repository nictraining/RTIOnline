package nic.rti.master.service;


import nic.rti.master.dao.GetReceiptTypeRepository;
import nic.rti.master.entity.ReceiptType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetReceiptTypeService {

    @Autowired
    private GetReceiptTypeRepository receiptTypeRepository;

    public List<ReceiptType> getReceiptType(){
        return receiptTypeRepository.findAll(Sort.by("rDetails"));
    }

}

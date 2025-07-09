package nic.rti.master.service;


import nic.rti.master.dao.GetTitleRepository;
import nic.rti.master.entity.Title;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetTitleService {

    @Autowired
    private GetTitleRepository titleRepository;

    public List<Title> getTitle(){
        return titleRepository.findAll(Sort.by("titleName"));
    }

}

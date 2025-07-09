package nic.rti.master.service;


import nic.rti.master.dao.GetActionCategoryRepository;
import nic.rti.master.entity.ActionCategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetActionCategoryService {

    @Autowired
    private GetActionCategoryRepository actionCategoryRepository;

    public List<ActionCategory> getActionCategory(){
        return actionCategoryRepository.findAll(Sort.by("actionName"));
    }

}

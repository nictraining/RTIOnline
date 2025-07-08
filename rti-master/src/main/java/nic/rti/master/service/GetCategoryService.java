package nic.rti.master.service;


import nic.rti.master.dao.GetCategoryRepository;
import nic.rti.master.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetCategoryService {

    @Autowired
    private GetCategoryRepository categoryRepository;

    public List<Category> getCategoryList(){
        return categoryRepository.findAll(Sort.by(Sort.Direction.ASC,"categoryAddedDate"));
    }

}

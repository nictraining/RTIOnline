package nic.rti.master.service;

import lombok.extern.slf4j.Slf4j;
import nic.rti.master.dao.GetOrgTypeRepository;
import nic.rti.master.entity.OrgType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class GetOrgTypeService {

    @Autowired
    private GetOrgTypeRepository orgTypeRepository;

    public List<OrgType> getOrgType()
    {   try{
        return orgTypeRepository.findAll(Sort.by("orgTypeDesc"));
    }catch (Exception e){
        log.error("Exception",e);
        throw new RuntimeException(e);
    }


    }

}

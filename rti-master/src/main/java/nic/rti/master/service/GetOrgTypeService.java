package nic.rti.master.service;

import nic.rti.master.dao.GetOrgTypeRepository;
import nic.rti.master.entity.OrgType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetOrgTypeService {

    @Autowired
    private GetOrgTypeRepository orgTypeRepository;

    public List<OrgType> getOrgType() {
        return orgTypeRepository.findAll(Sort.by("orgTypeDesc"));
    }

}

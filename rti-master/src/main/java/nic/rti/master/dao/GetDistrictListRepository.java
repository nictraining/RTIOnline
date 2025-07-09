package nic.rti.master.dao;

import nic.rti.master.entity.DistrictList;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GetDistrictListRepository extends JpaRepository<DistrictList, String> {

    List<DistrictList> findByStateCode(String StateCode, Sort sort);

}

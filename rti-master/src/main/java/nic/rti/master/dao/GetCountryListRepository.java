package nic.rti.master.dao;

import nic.rti.master.entity.GetCountryList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GetCountryListRepository extends JpaRepository<GetCountryList, Integer> {

    @Query("SELECT cl FROM GetCountryList cl")
        List<GetCountryList> getCountryList();
}


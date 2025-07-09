package nic.rti.master.dao;

import nic.rti.master.entity.Title;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GetTitleRepository extends JpaRepository<Title, String> {
}

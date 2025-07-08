package nic.rti.master.dao;

import nic.rti.master.entity.Category;
import nic.rti.master.entity.CompositeKeysForCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GetCategoryRepository extends JpaRepository<Category, CompositeKeysForCategory> {
}

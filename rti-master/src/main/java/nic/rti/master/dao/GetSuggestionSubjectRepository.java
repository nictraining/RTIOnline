package nic.rti.master.dao;

import nic.rti.master.entity.SuggestionSubject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface GetSuggestionSubjectRepository extends JpaRepository<SuggestionSubject, String> {
}

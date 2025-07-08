package nic.rti.master.service;


import nic.rti.master.dao.GetSuggestionSubjectRepository;
import nic.rti.master.entity.SuggestionSubject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetSuggestionSubjectService {

    @Autowired
    private GetSuggestionSubjectRepository suggestionSubjectRepository;

    public List<SuggestionSubject> getSuggestionSubject() {
        return suggestionSubjectRepository.findAll(Sort.by("suggSub"));
    }

}

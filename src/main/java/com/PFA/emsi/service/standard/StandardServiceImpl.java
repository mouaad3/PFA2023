package com.PFA.emsi.service.standard;

import com.PFA.emsi.Request.StandardRequest;
import com.PFA.emsi.model.Clause;
import com.PFA.emsi.model.Standard;
import com.PFA.emsi.repository.ClauseRepository;
import com.PFA.emsi.repository.StandardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandardServiceImpl implements StandardService {

    private final StandardRepository standardRepository;
    private final ClauseRepository clauseRepository;

    @Autowired
    public StandardServiceImpl(StandardRepository standardRepository, ClauseRepository clauseRepository) {
        this.standardRepository = standardRepository;
        this.clauseRepository = clauseRepository;
    }

    public List<Standard> getAllStandards() {
        return standardRepository.findAll();
    }

    public Standard getStandardById(Long id) {
        return standardRepository.findById(id).orElse(null);
    }

    public Standard createStandard(StandardRequest standardRequest) {
        Standard standard = new Standard();
        standard.setName(standardRequest.getName());
        standard.setDescription(standardRequest.getDescription());

        // Fetch the existing clauses based on their IDs
        List<Clause> clauses = clauseRepository.findAllById(standardRequest.getClauseIds());

        // Set the clauses in the standard entity
        standard.setClauses(clauses);

        return standardRepository.save(standard);
    }


    public Standard updateStandard(Long id, Standard updatedStandard) {
        Standard standard = getStandardById(id);
        if (standard != null) {
            standard.setName(updatedStandard.getName());
            standard.setDescription(updatedStandard.getDescription());
            standard.setClauses(updatedStandard.getClauses());
            return standardRepository.save(standard);
        }
        return null;
    }

    public void deleteStandard(Long id) {
        standardRepository.deleteById(id);
    }
}

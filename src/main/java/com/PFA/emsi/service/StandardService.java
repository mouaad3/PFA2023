package com.PFA.emsi.service;

import com.PFA.emsi.model.Standard;
import com.PFA.emsi.repository.StandardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StandardService {

    private final StandardRepository standardRepository;

    @Autowired
    public StandardService(StandardRepository standardRepository) {
        this.standardRepository = standardRepository;
    }

    public List<Standard> getAllStandards() {
        return standardRepository.findAll();
    }

    public Standard getStandardById(Long id) {
        return standardRepository.findById(id).orElse(null);
    }

    public Standard createStandard(Standard standard) {
        return standardRepository.save(standard);
    }

    public Standard updateStandard(Long id, Standard updatedStandard) {
        Standard standard = getStandardById(id);
        if (standard != null) {
            standard.setName(updatedStandard.getName());
            standard.setDescription(updatedStandard.getDescription());
            standard.setClauses(updatedStandard.getClauses());
            standard.setAudits(updatedStandard.getAudits());
            return standardRepository.save(standard);
        }
        return null;
    }

    public void deleteStandard(Long id) {
        standardRepository.deleteById(id);
    }
}

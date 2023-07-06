package com.PFA.emsi.service;

import com.PFA.emsi.model.Clause;
import com.PFA.emsi.repository.ClauseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClauseService {

    private final ClauseRepository clauseRepository;

    @Autowired
    public ClauseService(ClauseRepository clauseRepository) {
        this.clauseRepository = clauseRepository;
    }

    public List<Clause> getAllClauses() {
        return clauseRepository.findAll();
    }

    public Clause getClauseById(Long id) {
        Optional<Clause> optionalClause = clauseRepository.findById(id);
        return optionalClause.orElse(null);
    }

    public Clause createClause(Clause clause) {
        return clauseRepository.save(clause);
    }

    public Clause updateClause(Long id, Clause clause) {
        Optional<Clause> optionalClause = clauseRepository.findById(id);
        if (optionalClause.isPresent()) {
            clause.setId(id);
            return clauseRepository.save(clause);
        } else {
            return null;
        }
    }

    public boolean deleteClause(Long id) {
        Optional<Clause> optionalClause = clauseRepository.findById(id);
        if (optionalClause.isPresent()) {
            clauseRepository.delete(optionalClause.get());
            return true;
        } else {
            return false;
        }
    }
}

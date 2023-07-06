package com.PFA.emsi.service;

import com.PFA.emsi.model.ClauseResult;
import com.PFA.emsi.repository.ClauseResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClauseResultService {
    private final ClauseResultRepository clauseResultRepository;

    @Autowired
    public ClauseResultService(ClauseResultRepository clauseResultRepository) {
        this.clauseResultRepository = clauseResultRepository;
    }

    public List<ClauseResult> getAllClauseResults() {
        return clauseResultRepository.findAll();
    }

    public ClauseResult getClauseResultById(Long id) {
        Optional<ClauseResult> optionalClauseResult = clauseResultRepository.findById(id);
        return optionalClauseResult.orElse(null);
    }

    public ClauseResult createClauseResult(ClauseResult clauseResult) {
        return clauseResultRepository.save(clauseResult);
    }

    public ClauseResult updateClauseResult(Long id, ClauseResult clauseResult) {
        Optional<ClauseResult> optionalExistingClauseResult = clauseResultRepository.findById(id);
        if (optionalExistingClauseResult.isPresent()) {
            ClauseResult existingClauseResult = optionalExistingClauseResult.get();
            existingClauseResult.setClause(clauseResult.getClause());
            existingClauseResult.setProof(clauseResult.getProof());
            existingClauseResult.setAuditResult(clauseResult.getAuditResult());
            existingClauseResult.setState(clauseResult.getState());
            existingClauseResult.setActions(clauseResult.getActions());
            return clauseResultRepository.save(existingClauseResult);
        } else {
            return null;
        }
    }

    public boolean deleteClauseResult(Long id) {
        clauseResultRepository.deleteById(id);
        return false;
    }
}

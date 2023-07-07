package com.PFA.emsi.service.clauseResult;

import com.PFA.emsi.Request.ClauseResultRequest;
import com.PFA.emsi.model.ClauseResult;
import com.PFA.emsi.repository.ClauseResultRepository;
import com.PFA.emsi.service.clause.ClauseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClauseResultServiceImpl implements ClauseResultService{

    private final ClauseResultRepository clauseResultRepository;
    private final ClauseServiceImpl clauseService;

    @Autowired
    public ClauseResultServiceImpl(ClauseResultRepository clauseResultRepository, ClauseServiceImpl clauseService) {
        this.clauseResultRepository = clauseResultRepository;
        this.clauseService = clauseService;
    }

    public List<ClauseResult> getAllClauseResults() {
        return clauseResultRepository.findAll();
    }

    public ClauseResult getClauseResultById(Long id) {
        return clauseResultRepository.findById(id).orElse(null);
    }

    public ClauseResult createClauseResult(ClauseResultRequest clauseResultRequest) {
        ClauseResult clauseResult = new ClauseResult();
        clauseResult.setClauseId(clauseResultRequest.getClauseId());
        clauseResult.setState(clauseResultRequest.getState());
        return clauseResultRepository.save(clauseResult);
    }

    public boolean deleteClauseResult(Long id) {
        clauseResultRepository.deleteById(id);
        return false;
    }
}

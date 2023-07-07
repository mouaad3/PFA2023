package com.PFA.emsi.service.clauseResult;

import com.PFA.emsi.Request.ClauseResultRequest;
import com.PFA.emsi.model.ClauseResult;

import java.util.List;

public interface ClauseResultService {

    public List<ClauseResult> getAllClauseResults();
    public ClauseResult getClauseResultById(Long id);

    public ClauseResult createClauseResult(ClauseResultRequest clauseResultRequest);

    public boolean deleteClauseResult(Long id);
}

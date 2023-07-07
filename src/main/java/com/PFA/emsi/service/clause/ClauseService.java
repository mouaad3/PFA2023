package com.PFA.emsi.service.clause;

import com.PFA.emsi.model.Clause;

import java.util.List;

public interface ClauseService {

    public List<Clause> getAllClauses();

    public Clause getClauseById(Long id);

    public Clause createClause(Clause clause);
    public Clause updateClause(Long id, Clause clause);

    public boolean deleteClause(Long id);

}

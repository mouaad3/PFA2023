package com.PFA.emsi.Request;

import com.PFA.emsi.Enum.ClauseState;

public class ClauseResultRequest {
    private Long clauseId;
    private ClauseState state;

    public ClauseResultRequest(Long clauseId, ClauseState state) {
        this.clauseId = clauseId;
        this.state = state;
    }

    public ClauseResultRequest() {
    }

    public Long getClauseId() {
        return clauseId;
    }

    public void setClauseId(Long clauseId) {
        this.clauseId = clauseId;
    }

    public ClauseState getState() {
        return state;
    }

    public void setState(ClauseState state) {
        this.state = state;
    }

    // Constructors, getters, and setters
}

package com.PFA.emsi.Request;

public class ClauseRequest {
    private String name;
    private String requirements;
    private Long standardId;
    private Long clauseResultId;

    public ClauseRequest(String name, String requirements, Long standardId, Long clauseResultId) {
        this.name = name;
        this.requirements = requirements;
        this.standardId = standardId;
        this.clauseResultId = clauseResultId;
    }

    public ClauseRequest() {
        standardId=1L;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public Long getStandardId() {
        return standardId;
    }

    public void setStandardId(Long standardId) {
        this.standardId = standardId;
    }

    public Long getClauseResultId() {
        return clauseResultId;
    }

    public void setClauseResultId(Long clauseResultId) {
        this.clauseResultId = clauseResultId;
    }

    // Constructor, getters, and setters
}

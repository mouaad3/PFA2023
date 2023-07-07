package com.PFA.emsi.Request;

import java.util.List;

public class StandardRequest {
    private String name;
    private String description;
    private List<Long> clauseIds;

    public StandardRequest() {
    }

    public StandardRequest(String name, String description, List<Long> clauseIds) {
        this.name = name;
        this.description = description;
        this.clauseIds = clauseIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Long> getClauseIds() {
        return clauseIds;
    }

    public void setClauseIds(List<Long> clauseIds) {
        this.clauseIds = clauseIds;
    }

    // Constructors, getters, and setters
}

package com.PFA.emsi.Request;

import java.util.List;

public class ProofRequest {
    private String description;
    private Long clauseResultId;
    private List<Long> fileIds;

    public ProofRequest(String description, Long clauseResultId, List<Long> fileIds) {
        this.description = description;
        this.clauseResultId = clauseResultId;
        this.fileIds = fileIds;
    }

    public ProofRequest() {
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getClauseResultId() {
        return clauseResultId;
    }

    public void setClauseResultId(Long clauseResultId) {
        this.clauseResultId = clauseResultId;
    }

    public List<Long> getFileIds() {
        return fileIds;
    }

    public void setFileIds(List<Long> fileIds) {
        this.fileIds = fileIds;
    }

    // Constructors, getters, and setters
}

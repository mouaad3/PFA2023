package com.PFA.emsi.Request;

public class AuditResultRequest {
    private String description;
    private Long auditId;
    private Long clauseResultId;

    public AuditResultRequest() {
    }

    public AuditResultRequest(String description, Long auditId, Long clauseResultId) {
        this.description = description;
        this.auditId = auditId;
        this.clauseResultId = clauseResultId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getAuditId() {
        return auditId;
    }

    public void setAuditId(Long auditId) {
        this.auditId = auditId;
    }

    public Long getClauseResultId() {
        return clauseResultId;
    }

    public void setClauseResultId(Long clauseResultId) {
        this.clauseResultId = clauseResultId;
    }

    // Getters and setters
    // ...
}

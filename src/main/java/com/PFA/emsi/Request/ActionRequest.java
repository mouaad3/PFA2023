package com.PFA.emsi.Request;

import java.util.List;

public class ActionRequest {
    private String name;
    private String description;
    private Long clauseResultId;
    private List<Long> userIds;
    private Long auditId;

    public ActionRequest() {
    }

    public ActionRequest(String name, String description, Long clauseResultId, List<Long> userIds, Long auditId) {
        this.name = name;
        this.description = description;
        this.clauseResultId = clauseResultId;
        this.userIds = userIds;
        this.auditId = auditId;
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

    public Long getClauseResultId() {
        return clauseResultId;
    }

    public void setClauseResultId(Long clauseResultId) {
        this.clauseResultId = clauseResultId;
    }

    public List<Long> getUserIds() {
        return userIds;
    }

    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }

    public Long getAuditId() {
        return auditId;
    }

    public void setAuditId(Long auditId) {
        this.auditId = auditId;
    }
}

package com.PFA.emsi.Request;

import java.util.List;

public class ProcessRequest {
    private String name;
    private String description;
    private Long processManagerId;
    private List<Long> auditIds;
    private Long siteId;

    // Getters and setters

    public ProcessRequest(){

    }

    public ProcessRequest(String name, String description, Long processManagerId, List<Long> auditIds, Long siteId) {
        this.name = name;
        this.description = description;
        this.processManagerId = processManagerId;
        this.auditIds = auditIds;
        this.siteId = siteId;
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

    public Long getProcessManagerId() {
        return processManagerId;
    }

    public void setProcessManagerId(Long processManagerId) {
        this.processManagerId = processManagerId;
    }

    public List<Long> getAuditIds() {
        return auditIds;
    }

    public void setAuditIds(List<Long> auditIds) {
        this.auditIds = auditIds;
    }

    public Long getSiteId() {
        return siteId;
    }

    public void setSiteId(Long siteId) {
        this.siteId = siteId;
    }

    // Constructors, getters, and setters
}
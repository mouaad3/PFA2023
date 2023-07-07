package com.PFA.emsi.Request;

import java.time.LocalDateTime;
import java.util.List;
public class AuditRequest {
    private String name;
    private String description;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long standardId;
    private List<ActionRequest> actions;
    public AuditRequest() {
    }

    public AuditRequest(String name, String description, LocalDateTime startTime, LocalDateTime endTime, Long standardId, List<ActionRequest> actions) {
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.standardId = standardId;
        this.actions = actions;
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

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public Long getStandardId() {
        return standardId;
    }

    public void setStandardId(Long standardId) {
        this.standardId = standardId;
    }

    public List<ActionRequest> getActions() {
        return actions;
    }

    public void setActions(List<ActionRequest> actions) {
        this.actions = actions;
    }

    // Getters and Setters
}

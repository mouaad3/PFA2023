package com.PFA.emsi.Request;

import java.util.List;

public class SiteRequest {
    private String name;
    private String address;
    private String description;
    private Long organizationId;
    private List<Long> processIds;

    public SiteRequest(String name, String address, String description, Long organizationId, List<Long> processIds) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.organizationId = organizationId;
        this.processIds = processIds;
    }

    public SiteRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Long organizationId) {
        this.organizationId = organizationId;
    }

    public List<Long> getProcessIds() {
        return processIds;
    }

    public void setProcessIds(List<Long> processIds) {
        this.processIds = processIds;
    }

    // Constructors, Getters and Setters
}


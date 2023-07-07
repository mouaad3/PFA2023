package com.PFA.emsi.Request;

import java.util.List;

public class OrganizationRequest {
    private String name;
    private String description;
    private String address;
    private Long itManagerId;
    private List<Long> siteIds;

    // Constructors, getters, and setters

    public OrganizationRequest() {
    }

    public OrganizationRequest(String name, String description, String address, Long itManagerId, List<Long> siteIds) {
        this.name = name;
        this.description = description;
        this.address = address;
        this.itManagerId = itManagerId;
        this.siteIds = siteIds;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getItManagerId() {
        return itManagerId;
    }

    public void setItManagerId(Long itManagerId) {
        this.itManagerId = itManagerId;
    }

    public List<Long> getSiteIds() {
        return siteIds;
    }

    public void setSiteIds(List<Long> siteIds) {
        this.siteIds = siteIds;
    }
}

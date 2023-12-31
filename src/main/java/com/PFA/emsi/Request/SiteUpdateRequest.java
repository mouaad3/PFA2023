package com.PFA.emsi.Request;

public class SiteUpdateRequest {
    private String name;
    private String address;
    private String description;

    public SiteUpdateRequest() {
    }

    public SiteUpdateRequest(String name, String address, String description) {
        this.name = name;
        this.address = address;
        this.description = description;
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

    // Constructors, Getters and Setters
}

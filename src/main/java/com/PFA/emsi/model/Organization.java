package com.PFA.emsi.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "Organization")
public class Organization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "organization", cascade = CascadeType.ALL)
    private List<Site> sites;

    @OneToOne
    @JoinColumn(name = "it_manager_id")
    private User itManager;

    public Organization() {
    }

    public Organization(Long id, String name, String description, String address, List<Site> sites, User itManager) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.sites = sites;
        this.itManager = itManager;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Site> getSites() {
        return sites;
    }

    public void setSites(List<Site> sites) {
        this.sites = sites;
    }

    public User getItManager() {
        return itManager;
    }

    public void setItManager(User itManager) {
        this.itManager = itManager;
    }


// Constructors, getters, and setters
}

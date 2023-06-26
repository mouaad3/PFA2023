package com.PFA.emsi.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Site")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "organization_id", nullable = false)
    private Organization organization;

    @OneToMany(mappedBy = "site")
    private List<Process> processes;

    public Site() {
    }

    public Site(Long id, String name, String address, String description, Organization organization, List<Process> processes) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.description = description;
        this.organization = organization;
        this.processes = processes;
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

    public Organization getOrganization() {
        return organization;
    }

    public void setOrganization(Organization organization) {
        this.organization = organization;
    }

    public List<Process> getProcesses() {
        return processes;
    }

    public void setProcesses(List<Process> processes) {
        this.processes = processes;
    }


    // Constructors, getters, and setters
}

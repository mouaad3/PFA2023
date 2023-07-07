package com.PFA.emsi.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Process")
public class Process {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToOne
    @JoinColumn(name = "process_manager_id", nullable = false)
    private User processManager;

    @OneToMany
    private List<Audit> audit;

    @ManyToOne(cascade=CascadeType.ALL)
    private Site site;


    public Process() {
    }

    public Process(Long id, String name, String description, User processManager, List<Audit> audit, Site site) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.processManager = processManager;
        this.audit = audit;
        this.site = site;
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

    public User getProcessManager() {
        return processManager;
    }

    public void setProcessManager(User processManager) {
        this.processManager = processManager;
    }

    public List<Audit> getAudit() {
        return audit;
    }

    public void setAudit(List<Audit> audit) {
        this.audit = audit;
    }

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }
}

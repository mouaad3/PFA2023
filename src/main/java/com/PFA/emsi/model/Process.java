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

    @ManyToOne
    @JoinColumn(name = "site_id", nullable = false)
    private Site site;

    @OneToOne
    @JoinColumn(name = "process_manager_id", nullable = false)
    private User processManager;

    @OneToOne(mappedBy = "process", cascade = CascadeType.ALL)
    private Audit audit;

    public Process() {
    }

    public Process(Long id, String name, String description, Site site, User processManager, Audit audit) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.site = site;
        this.processManager = processManager;
        this.audit = audit;
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

    public Site getSite() {
        return site;
    }

    public void setSite(Site site) {
        this.site = site;
    }

    public User getProcessManager() {
        return processManager;
    }

    public void setProcessManager(User processManager) {
        this.processManager = processManager;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }
}

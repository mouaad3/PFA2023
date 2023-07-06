package com.PFA.emsi.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "Audit")
public class Audit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "start_time", nullable = false)
    private LocalDateTime startTime;

    @Column(name = "end_time", nullable = false)
    private LocalDateTime endTime;

    @ManyToOne
    @JoinTable(
            name = "user_audit",
            joinColumns = @JoinColumn(name = "audit_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private User auditors;

    @OneToOne
    @JoinColumn(name = "process_id", nullable = false)
    private Process process;

    @OneToOne(mappedBy = "audit", cascade = CascadeType.ALL)
    private AuditResult auditResult;

    @OneToMany(mappedBy = "audit", cascade = CascadeType.ALL)
    private List<Action> actions;

    @ManyToOne
    @JoinColumn(name = "standard_id")
    private Standard standard;


    public Audit() {
    }

    public Audit(Long id, String name, String description, LocalDateTime startTime, LocalDateTime endTime, User auditors, Process process, AuditResult auditResult, List<Action> actions, Standard standard) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startTime = startTime;
        this.endTime = endTime;
        this.auditors = auditors;
        this.process = process;
        this.auditResult = auditResult;
        this.actions = actions;
        this.standard = standard;
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

    public User getAuditors() {
        return auditors;
    }

    public void setAuditors(User auditors) {
        this.auditors = auditors;
    }

    public Process getProcess() {
        return process;
    }

    public void setProcess(Process process) {
        this.process = process;
    }

    public AuditResult getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(AuditResult auditResult) {
        this.auditResult = auditResult;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }

    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }
}


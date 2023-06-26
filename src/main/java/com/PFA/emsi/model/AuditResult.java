package com.PFA.emsi.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Audit_Result")
public class AuditResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "description", nullable = false)
    private String description;

    @OneToOne
    @JoinColumn(name = "audit_id")
    private Audit audit;


    @OneToMany(mappedBy = "auditResult", cascade = CascadeType.ALL)
    private List<ClauseResult> clauseResults;

    public AuditResult() {
    }

    public AuditResult(Long id, String description, Audit audit, List<ClauseResult> clauseResults) {
        this.id = id;
        this.description = description;
        this.audit = audit;
        this.clauseResults = clauseResults;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public List<ClauseResult> getClauseResults() {
        return clauseResults;
    }

    public void setClauseResults(List<ClauseResult> clauseResults) {
        this.clauseResults = clauseResults;
    }

    // Constructors, getters, and setters
}


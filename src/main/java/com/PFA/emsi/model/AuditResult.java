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


    @ManyToOne(cascade = CascadeType.ALL)
    private ClauseResult clauseResults;

    // Constructors, getters, and setters


    public AuditResult() {
    }

    public AuditResult(Long id, String description, Audit audit, ClauseResult clauseResults) {
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

    public ClauseResult getClauseResults() {
        return clauseResults;
    }

    public void setClauseResults(ClauseResult clauseResults) {
        this.clauseResults = clauseResults;
    }
}


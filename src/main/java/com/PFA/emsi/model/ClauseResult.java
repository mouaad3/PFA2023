package com.PFA.emsi.model;

import com.PFA.emsi.Enum.ClauseState;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Clause_Result")
public class ClauseResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "clause_id", nullable = false)
    private Clause clause;


    @OneToOne(mappedBy = "clauseResult")
    private Proof proof;


    @ManyToOne
    @JoinColumn(name = "audit_result_id")
    private AuditResult auditResult;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private ClauseState state;

    @OneToMany(mappedBy = "clauseResult", cascade = CascadeType.ALL)
    private List<Action> actions;

    public ClauseResult() {
    }

    public ClauseResult(Long id, Clause clause, Proof proof, AuditResult auditResult, ClauseState state, List<Action> actions) {
        this.id = id;
        this.clause = clause;
        this.proof = proof;
        this.auditResult = auditResult;
        this.state = state;
        this.actions = actions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Clause getClause() {
        return clause;
    }

    public void setClause(Clause clause) {
        this.clause = clause;
    }

    public Proof getProof() {
        return proof;
    }

    public void setProof(Proof proof) {
        this.proof = proof;
    }

    public AuditResult getAuditResult() {
        return auditResult;
    }

    public void setAuditResult(AuditResult auditResult) {
        this.auditResult = auditResult;
    }

    public ClauseState getState() {
        return state;
    }

    public void setState(ClauseState state) {
        this.state = state;
    }

    public List<Action> getActions() {
        return actions;
    }

    public void setActions(List<Action> actions) {
        this.actions = actions;
    }




    // Constructors, getters, and setters
}

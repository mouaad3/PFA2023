package com.PFA.emsi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "Clause")
public class Clause {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "requirements", nullable = false)
    private String requirements;

    @ManyToOne
    @JoinColumn(name = "standard_id", nullable = false)
    private Standard standard;

    @OneToOne(mappedBy = "clause", cascade = CascadeType.ALL)
    private ClauseResult clauseResult;

    public Clause() {
    }

    public Clause(Long id, String name, String requirements, Standard standard, ClauseResult clauseResult) {
        this.id = id;
        this.name = name;
        this.requirements = requirements;
        this.standard = standard;
        this.clauseResult = clauseResult;
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

    public String getRequirements() {
        return requirements;
    }

    public void setRequirements(String requirements) {
        this.requirements = requirements;
    }

    public Standard getStandard() {
        return standard;
    }

    public void setStandard(Standard standard) {
        this.standard = standard;
    }

    public ClauseResult getClauseResult() {
        return clauseResult;
    }

    public void setClauseResult(ClauseResult clauseResult) {
        this.clauseResult = clauseResult;
    }

    // Constructors, getters, and setters
}


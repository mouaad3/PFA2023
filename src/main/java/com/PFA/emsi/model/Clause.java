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

    @Column(name = "standardId", nullable = true)
    private Long standardId;

    @Column(name = "clauseResultId", nullable = true)
    private Long clauseResultId;

    public Clause() {
    }

    public Clause(Long id, String name, String requirements, Long standardId, Long clauseResultId) {
        this.id = id;
        this.name = name;
        this.requirements = requirements;
        this.standardId = standardId;
        this.clauseResultId = clauseResultId;
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

    public Long getStandardId() {
        return standardId;
    }

    public void setStandardId(Long standardId) {
        this.standardId = standardId;
    }

    public Long getClauseResultId() {
        return clauseResultId;
    }

    public void setClauseResultId(Long clauseResultId) {
        this.clauseResultId = clauseResultId;
    }
}


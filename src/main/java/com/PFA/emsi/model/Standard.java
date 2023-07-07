package com.PFA.emsi.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Standard")
public class Standard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany
    private List<Clause> clauses;

    public Standard() {
    }

    public Standard(Long id, String name, String description, List<Clause> clauses) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.clauses = clauses;
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

    public List<Clause> getClauses() {
        return clauses;
    }

    public void setClauses(List<Clause> clauses) {
        this.clauses = clauses;
    }
}


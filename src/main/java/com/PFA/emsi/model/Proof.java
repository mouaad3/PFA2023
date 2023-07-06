package com.PFA.emsi.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "Proof")
public class Proof {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "proof", cascade = CascadeType.ALL)
    private List<File> files;

    @Column(name = "description", nullable = false)
    private String description;
    @OneToOne
    @JoinColumn(name = "clause_result_id", nullable = false)
    private ClauseResult clauseResult;

    // Constructors, getters, and setters
    public Proof() {
    }

    public Proof(Long id, List<File> files, String description, ClauseResult clauseResult) {
        this.id = id;
        this.files = files;
        this.description = description;
        this.clauseResult = clauseResult;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<File> getFiles() {
        return files;
    }

    public void setFiles(List<File> files) {
        this.files = files;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ClauseResult getClauseResult() {
        return clauseResult;
    }

    public void setClauseResult(ClauseResult clauseResult) {
        this.clauseResult = clauseResult;
    }
}


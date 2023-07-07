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

    @Column(name = "clauseId")
    private Long clauseId;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = true)
    private ClauseState state;

    // Constructors, getters, and setters
    public ClauseResult() {
    }

    public ClauseResult(Long id, Long clauseId, ClauseState state) {
        this.id = id;
        this.clauseId = clauseId;
        this.state = state;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getClauseId() {
        return clauseId;
    }

    public void setClauseId(Long clauseId) {
        this.clauseId = clauseId;
    }

    public ClauseState getState() {
        return state;
    }

    public void setState(ClauseState state) {
        this.state = state;
    }
}

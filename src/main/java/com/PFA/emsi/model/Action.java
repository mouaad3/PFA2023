package com.PFA.emsi.model;

import jakarta.persistence.*;

import java.util.List;
@Entity
@Table(name = "Action")
public class Action {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "clause_result_id", nullable = false)
    private ClauseResult clauseResult;

    @ManyToMany
    @JoinTable(
            name = "Action_User",
            joinColumns = @JoinColumn(name = "action_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> users;

    @ManyToOne
    @JoinColumn(name = "audit_id", nullable = false)
    private Audit audit;

    public Action() {
    }

    public Action(Long id, String name, String description, ClauseResult clauseResult, List<User> users, Audit audit) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.clauseResult = clauseResult;
        this.users = users;
        this.audit = audit;
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

    public ClauseResult getClauseResult() {
        return clauseResult;
    }

    public void setClauseResult(ClauseResult clauseResult) {
        this.clauseResult = clauseResult;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public Audit getAudit() {
        return audit;
    }

    public void setAudit(Audit audit) {
        this.audit = audit;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    // Constructors, getters, and setters
}



package com.PFA.emsi.model;

import jakarta.persistence.*;


@Entity
@Table(name = "Trace")
public class Trace {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "affected", nullable = false)
    private String affected;

    @Column(name = "content", nullable = false)
    private String content;

    // Constructors, getters, and setters

    public Trace() {
    }

    public Trace(Long id, User user, String affected, String content) {
        this.id = id;
        this.user = user;
        this.affected = affected;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAffected() {
        return affected;
    }

    public void setAffected(String affected) {
        this.affected = affected;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }


}

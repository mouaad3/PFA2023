package com.PFA.emsi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "File")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Lob
    @Column(name = "content", nullable = false)
    private byte[] content;

    @ManyToOne
    @JoinColumn(name = "proof_id", nullable = false)
    private Proof proof;

    // Constructors, getters, and setters
    public File() {
    }
    public File(Long id, String name, byte[] content, Proof proof) {
        this.id = id;
        this.name = name;
        this.content = content;
        this.proof = proof;
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

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }

    public Proof getProof() {
        return proof;
    }

    public void setProof(Proof proof) {
        this.proof = proof;
    }
}

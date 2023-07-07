package com.PFA.emsi.Request;

public class FileRequest {
    private String name;
    private byte[] content;
    private Long proofId;

    public FileRequest() {
    }

    public FileRequest(String name, byte[] content, Long proofId) {
        this.name = name;
        this.content = content;
        this.proofId = proofId;
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

    public Long getProofId() {
        return proofId;
    }

    public void setProofId(Long proofId) {
        this.proofId = proofId;
    }

    // Constructors, getters, and setters
}

package com.PFA.emsi.Request;

public class TraceRequest {

    private Long userId;
    private String affected;
    private String content;

    public TraceRequest() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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


    public TraceRequest(Long userId, String affected, String content) {
        this.userId = userId;
        this.affected = affected;
        this.content = content;
    }

    // getters and setters
}
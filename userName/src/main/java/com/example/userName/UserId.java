package com.example.userName;

public class UserId {
    private final int id;
    private final String content;

    public UserId(int id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}

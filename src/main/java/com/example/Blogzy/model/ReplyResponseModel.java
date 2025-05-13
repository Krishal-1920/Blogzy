package com.example.Blogzy.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ReplyResponseModel {

    private String username;
    private String reply;
    private LocalDateTime createdAt;

    public ReplyResponseModel(String username, String reply, LocalDateTime createdAt) {
        this.username = username;
        this.reply = reply;
        this.createdAt = createdAt;
    }
}
package com.example.pdhbacktest.comment.model;

import lombok.Getter;

@Getter
public class CommentDto {
    private long id;
    private String comment;
    private String writer;

    public CommentDto(Comment comment) {
        this.id = comment.getId();
        this.comment = comment.getComment();
        this.writer = comment.getWriter();
    }
}

package com.example.pdhbacktest.board.model;

import com.example.pdhbacktest.comment.model.Comment;
import com.example.pdhbacktest.comment.model.CommentDto;
import lombok.Getter;

import java.util.List;

public class BoardDto {
    private String title;
    private String content;
    private String writer;

    @Getter
    public static class Register {
        private String title;
        private String content;
        private String writer;
        private List<Comment> comments;

        public Board toEntity() {
            Board board = new Board(null, title, content, writer, comments);
            return board;
        }
    }

    @Getter
    public static class Response {
        private String title;
        private String content;
        private String writer;
        private List<CommentDto> comments;

        public static Response from(Board board) {
            Response res = new Response();
            res.title = board.getTitle();
            res.content = board.getContent();
            res.writer = board.getWriter();
            res.comments = board.getComments().stream()
                    .map(CommentDto::new)
                    .toList();
            return res;
        }
    }
    @Getter
    public static class BoardList{
        private Long id;
        private String title;
        private String writer;
        private Long commentCount;

        public  BoardList(Long id, String title, String writer, Long commentCount) {
            this.id = id;
            this.title = title;
            this.writer = writer;
            this.commentCount = commentCount;
        }
    }
}

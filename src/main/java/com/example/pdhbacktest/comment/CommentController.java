package com.example.pdhbacktest.comment;

import com.example.pdhbacktest.comment.model.Comment;
import com.example.pdhbacktest.comment.model.CommentDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/comment")
public class CommentController {
    private CommentService commentService;
    @PostMapping("/register/{boardId}")
    public ResponseEntity<String> addComment(@PathVariable Long boardId, @RequestBody CommentDto commentDto) {
        commentService.addComment(boardId, commentDto);
        return ResponseEntity.ok("댓글 성공");
    }
}

package com.example.pdhbacktest.comment;

import com.example.pdhbacktest.board.BoardRepository;
import com.example.pdhbacktest.board.model.Board;
import com.example.pdhbacktest.comment.model.Comment;
import com.example.pdhbacktest.comment.model.CommentDto;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public void addComment(Long boardId, CommentDto commentDto) {
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        Comment comment = Comment.builder()
                .comment(commentDto.getComment())
                .writer(commentDto.getWriter())
                .board(board)
                .build();

        board.addComment(comment);
        commentRepository.save(comment);
    }
}

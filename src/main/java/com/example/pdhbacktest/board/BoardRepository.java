package com.example.pdhbacktest.board;

import com.example.pdhbacktest.board.model.Board;
import com.example.pdhbacktest.board.model.BoardDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
    List<Board> findAll();
}

package com.example.pdhbacktest.board;

import com.example.pdhbacktest.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody BoardDto.Register dto) {
        boardService.register(dto);
        return ResponseEntity.ok("성공");
    }

    @GetMapping("/read/{idx}")
    public ResponseEntity<BoardDto.Response> read(@PathVariable Long idx) {
        BoardDto.Response response = boardService.read(idx);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/list")
    public ResponseEntity<List<BoardDto.BoardList>> list() {
        return ResponseEntity.ok(boardService.list());
    }
}

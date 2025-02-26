package com.example.pdhbacktest.board;

import com.example.pdhbacktest.board.model.Board;
import com.example.pdhbacktest.board.model.BoardDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class BoardService {
    private final BoardRepository boardRepository;

    public void register(BoardDto.Register dto) {
        boardRepository.save(dto.toEntity());
    }

    public BoardDto.Response read(Long idx) {
        Optional<Board> result = boardRepository.findById(idx);
        if (result.isPresent()) {
            Board board = result.get();

            return BoardDto.Response.from(board);
        }
        return null;
    }

    public List<BoardDto.BoardList> list() {
        return boardRepository.findAll()
                .stream()
                .map(board -> new BoardDto.BoardList(
                        board.getId(),
                        board.getTitle(),
                        board.getWriter(),
                        (long) board.getComments().size() // 댓글 개수
                ))
                .toList();
    }
}

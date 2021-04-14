package com.jaehyeok.dugout.service.board;

import com.jaehyeok.dugout.domain.board.Board;
import com.jaehyeok.dugout.dto.board.BoardResponseDto;
import com.jaehyeok.dugout.dto.board.BoardSaveRequestDto;
import com.jaehyeok.dugout.dto.board.BoardUpdateRequestDto;
import com.jaehyeok.dugout.repository.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;
    // 게시판 - 목록 조회
    @Transactional
    public List<BoardResponseDto> findAll(){
        return boardRepository.findAll()
                .stream()
                .map(BoardResponseDto::new)
                .collect(Collectors.toList());
    }
    // 게시판 - 상세 조회
    @Transactional
    public BoardResponseDto findById(Long boardId){
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalAccessError("[boardId =" + boardId + "] 해당 게시판이 존재하지 않습니다."));
        return new BoardResponseDto(board);
    }
    // 게시판 - 등록
    @Transactional
    public Long save(BoardSaveRequestDto boardSaveRequestDto){
        return boardRepository.save(boardSaveRequestDto.toEntity())
                .getId();
    }
    // 게시판 - 수정
    @Transactional
    public Long update(Long boardId, BoardUpdateRequestDto boardUpdateRequestDto){
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalAccessError("[boardId=" + boardId + "] 해당 게시판이 존재하지 않습니다."));
        board.update(boardUpdateRequestDto.getName());
        return boardId;
    }
    // 게시판 - 삭제
    @Transactional
    public void delete(Long boardId){
        Board board = boardRepository.findById(boardId)
                .orElseThrow(() -> new IllegalAccessError("[boardId=" + boardId + "] 해당 게시판이 존재하지 않습니다."));
        boardRepository.delete(board);
    }
}

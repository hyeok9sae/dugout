package com.jaehyeok.dugout.controller.board;

import com.jaehyeok.dugout.dto.board.BoardResponseDto;
import com.jaehyeok.dugout.dto.board.BoardSaveRequestDto;
import com.jaehyeok.dugout.dto.board.BoardUpdateRequestDto;
import com.jaehyeok.dugout.service.board.BoardService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/board")
@RestController
public class BoardController {

    private final BoardService boardService;

    // 게시판 - 목록 조회
    @ApiOperation(value = "게시판 목록 조회 API", notes = "게시판 목록 리스트 반환")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<BoardResponseDto>> findAll(){
        List<BoardResponseDto> boardResponseDtoList = boardService.findAll();
        return new ResponseEntity<List<BoardResponseDto>>(boardResponseDtoList, HttpStatus.OK);
    }
    // 게시판 - 상세 조회
    @ApiOperation(value = "게시판 상세 조회 API", notes = "게시판 상세 정보 반환")
    @GetMapping(value = "/{boardId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<BoardResponseDto> findById(@PathVariable("boardId") Long boardId){
        BoardResponseDto boardResponseDto = boardService.findById(boardId);
        return new ResponseEntity<BoardResponseDto>(boardResponseDto, HttpStatus.OK);
    }
    // 게시판 - 등록
    @ApiOperation(value = "게시판 등록 API", notes = "게시판 등록 후 해당 id값 반환")
    @PostMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Long> save(@RequestBody BoardSaveRequestDto boardSaveRequestDto){
        Long savedBoardId = boardService.save(boardSaveRequestDto);
        return new ResponseEntity<Long>(savedBoardId, HttpStatus.CREATED);
    }
    // 게시판 - 수정
    @ApiOperation(value = "게시판 수정 API", notes = "게시판 수정 후 해당 id값 반환")
    @PutMapping(value = "/{boardId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Long> update(@PathVariable("boardId") Long boardId, @RequestBody BoardUpdateRequestDto boardUpdateRequestDto){
        Long updatedBoardId = boardService.update(boardId, boardUpdateRequestDto);
        return new ResponseEntity<Long>(updatedBoardId, HttpStatus.CREATED);
    }
    // 게시판 - 삭제
    @ApiOperation(value = "게시판 삭제 API", notes = "게시판 삭제 후 해당 id값 반환")
    @DeleteMapping(value = "/{boardId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Long> delete(@PathVariable("boardId") Long boardId){
        boardService.delete(boardId);
        return new ResponseEntity<Long>(boardId, HttpStatus.NO_CONTENT);
    }
}
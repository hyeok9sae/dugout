package cowlevel.gloria.dugout.controller.board;

import cowlevel.gloria.dugout.dto.board.BoardResponseDto;
import cowlevel.gloria.dugout.dto.board.BoardSaveRequestDto;
import cowlevel.gloria.dugout.dto.board.BoardUpdateRequestDto;
import cowlevel.gloria.dugout.service.board.BoardService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
@RequestMapping("/board")
@RestController
public class BoardController {

    private final BoardService boardService;

    @ApiOperation(value = "게시판 목록 조회")
    @GetMapping(value = "/all")
    public ResponseEntity<List<BoardResponseDto>> findAll(){
        List<BoardResponseDto> boardResponseDtoList = boardService.findAll();
        return new ResponseEntity<List<BoardResponseDto>>(boardResponseDtoList, HttpStatus.OK);
    }

    @ApiOperation(value = "게시판 상세 조회")
    @GetMapping(value = "/{id}")
    public ResponseEntity<BoardResponseDto> findById(@PathVariable Long id){
        BoardResponseDto boardResponseDto = boardService.findById(id);
        return new ResponseEntity<BoardResponseDto>(boardResponseDto, HttpStatus.OK);
    }

    @ApiOperation(value = "게시판 정보 등록")
    @PostMapping(value = "/up")
    public ResponseEntity<Long> save(@RequestBody BoardSaveRequestDto boardSaveRequestDto){
        Long saveBoardId = boardService.save(boardSaveRequestDto);
        return new ResponseEntity<Long>(saveBoardId, HttpStatus.OK);
    }

    @ApiOperation(value = "게시판 정보 수정")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Long> update(@PathVariable Long id, @RequestBody BoardUpdateRequestDto boardUpdateRequestDto){
        Long updateBoardId = boardService.update(id, boardUpdateRequestDto);
        return new ResponseEntity<Long>(updateBoardId, HttpStatus.OK);
    }

    @ApiOperation(value = "게시판 정보 삭제")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        boardService.delete(id);
        return new ResponseEntity<Long>(id, HttpStatus.OK);
    }
}

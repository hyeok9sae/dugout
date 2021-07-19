package cowlevel.gloria.dugout.controller.board;

import cowlevel.gloria.dugout.dto.board.Board;
import cowlevel.gloria.dugout.service.board.BoardService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @ApiOperation(value = "게시판 목록 조회")
    @GetMapping(value="/all")
    public ResponseEntity<List<Board>> findAllBoards(){
        List<Board> boards = boardService.findAllBoards();
        return new ResponseEntity<List<Board>>(boards, HttpStatus.OK);
    }

    @ApiOperation(value = "게시판 상세 조회")
    @GetMapping(value="/{id}")
    public ResponseEntity<Board> findBoardById(@PathVariable Long id){
        Board board = boardService.findBoardById(id);
        return new ResponseEntity<Board>(board, HttpStatus.OK);
    }

    @ApiOperation(value = "게시판 정보 등록")
    @PostMapping(value="")
    public ResponseEntity<Long> addBoard(@RequestBody Board board){
        boardService.addBoard(board);
        return new ResponseEntity<Long>(board.getId(), HttpStatus.CREATED);
    }

    @ApiOperation(value = "게시판 정보 수정")
    @PutMapping(value="/{id}")
    public ResponseEntity<Long> modifyBoard(@RequestBody Board board){
        boardService.modifyBoard(board);
        return new ResponseEntity<Long>(board.getId(), HttpStatus.CREATED);
    }

    @ApiOperation(value = "게시판 정보 삭제")
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Long> removeBoardById(@PathVariable Long id){
        boardService.removeBoardById(id);
        return new ResponseEntity<Long>(id, HttpStatus.NO_CONTENT);
    }
}

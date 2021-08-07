package cowlevel.gloria.dugout.controller.comment;

import cowlevel.gloria.dugout.dto.comment.CommentResponseDto;
import cowlevel.gloria.dugout.dto.comment.CommentSaveRequestDto;
import cowlevel.gloria.dugout.dto.comment.CommentUpdateRequestDto;
import cowlevel.gloria.dugout.service.comment.CommentService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
@RequestMapping("/comment")
@RestController
public class CommentController {

    private final CommentService commentService;

    @ApiOperation(value = "comment 목록 조회")
    @GetMapping(value = "/all")
    public ResponseEntity<List<CommentResponseDto>> findAll(){
        List<CommentResponseDto> commentResponseDtoList = commentService.findAll();
        return new ResponseEntity<List<CommentResponseDto>>(commentResponseDtoList, HttpStatus.OK);
    }

    @ApiOperation(value = "comment 상세 조회")
    @GetMapping(value = "/{id}")
    public ResponseEntity<CommentResponseDto> findById(@PathVariable Long id){
        CommentResponseDto commentResponseDto = commentService.findById(id);
        return new ResponseEntity<CommentResponseDto>(commentResponseDto, HttpStatus.OK);
    }

    @ApiOperation(value = "comment 등록")
    @PostMapping(value = "/up")
    public ResponseEntity<Long> save(@RequestBody CommentSaveRequestDto commentSaveRequestDto){
        Long savedCommentId = commentService.save(commentSaveRequestDto);
        return new ResponseEntity<Long>(savedCommentId, HttpStatus.OK);
    }

    @ApiOperation(value = "comment 수정")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Long> update(@PathVariable Long id, @RequestBody CommentUpdateRequestDto commentUpdateRequestDto) {
        Long updatedCommentId = commentService.update(id, commentUpdateRequestDto);
        return new ResponseEntity<Long>(updatedCommentId, HttpStatus.OK);
    }

    @ApiOperation(value = "comment 삭제")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        commentService.delete(id);
        return new ResponseEntity<Long>(id, HttpStatus.OK);
    }
}

package cowlevel.gloria.dugout.controller.comment;

import cowlevel.gloria.dugout.dto.comment.Comment;
import cowlevel.gloria.dugout.dto.user.User;
import cowlevel.gloria.dugout.service.comment.CommentService;
import cowlevel.gloria.dugout.service.user.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    @ApiOperation(value = "사용자 목록 조회")
    @GetMapping(value="/all")
    public ResponseEntity<List<Comment>> findAllComments(){
        List<Comment> comments = commentService.findAllComments();
        return new ResponseEntity<List<Comment>>(comments, HttpStatus.OK);
    }

    @ApiOperation(value = "사용자 상세 조회")
    @GetMapping(value="/{id}")
    public ResponseEntity<Comment> findCommentById(@PathVariable Long id){
        Comment comment = commentService.findCommentById(id);
        return new ResponseEntity<Comment>(comment, HttpStatus.OK);
    }

    @ApiOperation(value = "사용자 정보 등록")
    @PostMapping(value="")
    public ResponseEntity<Long> addComment(@RequestBody Comment comment){
        commentService.addComment(comment);
        return new ResponseEntity<Long>(comment.getId(), HttpStatus.CREATED);
    }

    @ApiOperation(value = "사용자 정보 수정")
    @PutMapping(value="/{id}")
    public ResponseEntity<Long> modifyComment(@RequestBody Comment comment){
        commentService.modifyComment(comment);
        return new ResponseEntity<Long>(comment.getId(), HttpStatus.CREATED);
    }

    @ApiOperation(value = "사용자 정보 삭제")
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Long> removeCommentById(@PathVariable Long id){
        commentService.removeCommentById(id);
        return new ResponseEntity<Long>(id, HttpStatus.NO_CONTENT);
    }
}

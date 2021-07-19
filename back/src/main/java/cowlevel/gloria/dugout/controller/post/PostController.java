package cowlevel.gloria.dugout.controller.post;

import cowlevel.gloria.dugout.dto.post.Post;
import cowlevel.gloria.dugout.service.post.PostService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {

    private final PostService postService;

    @ApiOperation(value = "게시글 목록 조회")
    @GetMapping(value = "/all")
    public ResponseEntity<List<Post>> findAllPosts(){
        List<Post> posts = postService.findAllPosts();
        return new ResponseEntity<List<Post>>(posts, HttpStatus.OK);
    }

    @ApiOperation(value = "게시글 상세 조회")
    @GetMapping(value = "")
    public ResponseEntity<Post> findPostById(@PathVariable Long id){
        Post post = postService.findPostById(id);
        return new ResponseEntity<Post>(post, HttpStatus.OK);
    }

    @ApiOperation(value = "게시글 정보 등록")
    @PostMapping(value="/{id}")
    public ResponseEntity<Long> addPost(@RequestBody Post post){
        postService.addPost(post);
        return new ResponseEntity<Long>(post.getId(), HttpStatus.CREATED);
    }

    @ApiOperation(value = "게시글 정보 수정")
    @PutMapping(value="/{id}")
    public ResponseEntity<Long> modifyPost(@RequestBody Post post){
        postService.modifyPost(post);
        return new ResponseEntity<Long>(post.getId(), HttpStatus.CREATED);
    }

    @ApiOperation(value = "게시글 정보 삭제")
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Long> removePostById(@PathVariable Long id){
        postService.removePostById(id);
        return new ResponseEntity<Long>(id, HttpStatus.NO_CONTENT);
    }
}

package cowlevel.gloria.dugout.controller.user;

import cowlevel.gloria.dugout.dto.user.User;
import cowlevel.gloria.dugout.service.user.UserService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import jdk.jfr.ContentType;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "사용자 목록 조회")
    @GetMapping(value="/all")
    public ResponseEntity<List<User>> findAllUsers() throws Exception {
        List<User> users = userService.findAllUsers();
        if (users.isEmpty()) {
            return new ResponseEntity<List<User>>(users, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @ApiOperation(value = "사용자 상세 조회")
    @GetMapping(value="/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id) throws Exception {
        User user = userService.findUserById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @ApiOperation(value = "사용자 정보 등록")
    @PostMapping(value="")
    public ResponseEntity<Long> addUser(User user, @RequestPart(required = false) MultipartFile file) throws IOException {
        userService.addUser(user, file);
        return new ResponseEntity<Long>(user.getId(), HttpStatus.CREATED);
    }

    @ApiOperation(value = "사용자 정보 수정")
    @PutMapping(value="/{id}")
    public ResponseEntity<Long> modifyUser(User user, @RequestPart(required = false) MultipartFile file) throws IOException {
        userService.modifyUser(user, file);
        return new ResponseEntity<Long>(user.getId(), HttpStatus.CREATED);
    }

    @ApiOperation(value = "사용자 정보 삭제")
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Long> removeUserById(@PathVariable Long id) throws Exception {
        userService.removeUserById(id);
        return new ResponseEntity<Long>(id, HttpStatus.NO_CONTENT);
    }

    @ApiOperation(value = "사용자 로그인")
    @PostMapping(value="/login")
    public ResponseEntity<User> login(@RequestBody User user){
        User userInfo = userService.login(user);
        if (userInfo != null) {
            return new ResponseEntity<User>(userInfo, HttpStatus.OK);
        }
        return new ResponseEntity<User>(new User(), HttpStatus.NO_CONTENT);
    }
}

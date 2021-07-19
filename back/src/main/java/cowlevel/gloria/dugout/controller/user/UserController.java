package cowlevel.gloria.dugout.controller.user;

import cowlevel.gloria.dugout.dto.user.User;
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
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "사용자 목록 조회")
    @GetMapping(value="/all")
    public ResponseEntity<List<User>> findAllUsers(){
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @ApiOperation(value = "사용자 상세 조회")
    @GetMapping(value="/{id}")
    public ResponseEntity<User> findUserById(@PathVariable Long id){
        User user = userService.findUserById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @ApiOperation(value = "사용자 정보 등록")
    @PostMapping(value="")
    public ResponseEntity<Long> addUser(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<Long>(user.getId(), HttpStatus.CREATED);
    }

    @ApiOperation(value = "사용자 정보 수정")
    @PutMapping(value="/{id}")
    public ResponseEntity<Long> modifyUser(@RequestBody User user){
        userService.modifyUser(user);
        return new ResponseEntity<Long>(user.getId(), HttpStatus.CREATED);
    }

    @ApiOperation(value = "사용자 정보 삭제")
    @DeleteMapping(value="/{id}")
    public ResponseEntity<Long> removeUserById(@PathVariable Long id){
        userService.removeUserById(id);
        return new ResponseEntity<Long>(id, HttpStatus.NO_CONTENT);
    }
}

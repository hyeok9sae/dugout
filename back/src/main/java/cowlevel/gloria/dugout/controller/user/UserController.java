package cowlevel.gloria.dugout.controller.user;

import cowlevel.gloria.dugout.dto.user.User;
import cowlevel.gloria.dugout.service.user.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "사용자 목록 조회")
    @GetMapping(value="all", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<User>> findAllUsers(){
        List<User> users = userService.findAllUsers();
        return new ResponseEntity<List<User>>(users, HttpStatus.OK);
    }

    @ApiOperation(value = "사용자 상세 조회")
    @GetMapping(value="{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<User> findUserById(@PathVariable Long id){
        User user = userService.findUserById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @ApiOperation(value = "사용자 정보 등록")
    @PostMapping(value="", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> addUser(@RequestBody User user){
        userService.addUser(user);
        return new ResponseEntity<String>("SUCCESS", HttpStatus.CREATED);
    }

    @ApiOperation(value = "사용자 정보 수정")
    @PutMapping(value="{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> modifyUser(@RequestBody User user){
        userService.modifyUser(user);
        return new ResponseEntity<String>("SUCCESS", HttpStatus.CREATED);
    }

    @ApiOperation(value = "사용자 정보 삭제")
    @DeleteMapping(value="{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<String> removeUserById(@PathVariable Long id){
        userService.removeUserById(id);
        return new ResponseEntity<String>("SUCCESS", HttpStatus.NO_CONTENT);
    }
}

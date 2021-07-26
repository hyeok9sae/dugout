package cowlevel.gloria.dugout.controller.user;

import cowlevel.gloria.dugout.dto.user.UserResponseDto;
import cowlevel.gloria.dugout.dto.user.UserSaveRequestDto;
import cowlevel.gloria.dugout.dto.user.UserUpdatePasswordRequestDto;
import cowlevel.gloria.dugout.dto.user.UserUpdateRequestDto;
import cowlevel.gloria.dugout.service.user.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    @ApiOperation(value = "유저 목록 조회 API")
    @GetMapping(value = "/all")
    public ResponseEntity<List<UserResponseDto>> findAll(){
        List<UserResponseDto> userResponseDtoList = userService.findAll();
        return new ResponseEntity<List<UserResponseDto>>(userResponseDtoList, HttpStatus.OK);
    }

    @ApiOperation(value = "유저 상세 조회 API")
    @GetMapping(value = "/{id}")
    public ResponseEntity<UserResponseDto> findById(@PathVariable Long id){
        UserResponseDto userResponseDto = userService.findById(id);
        return new ResponseEntity<UserResponseDto>(userResponseDto, HttpStatus.OK);
    }

    @ApiOperation(value = "유저 정보 등록 API")
    @PostMapping(value = "")
    public ResponseEntity<Long> save(UserSaveRequestDto userSaveRequestDto, @RequestPart(value = "image", required = false) MultipartFile file) throws IOException {
        Long savedUserId = userService.save(userSaveRequestDto, file);
        return new ResponseEntity<Long>(savedUserId, HttpStatus.OK);
    }

    @ApiOperation(value = "유저 정보 수정 API")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Long> update(@PathVariable Long id, @RequestBody UserUpdateRequestDto userUpdateRequestDto) throws IOException{
        Long updatedUserId = userService.update(id, userUpdateRequestDto);
        return new ResponseEntity<Long>(updatedUserId, HttpStatus.OK);
    }

    @ApiOperation(value = "유저 패스워드 수정 API")
    @PutMapping(value = "/password/{id}")
    public ResponseEntity<Long> updatePassword(@PathVariable Long id, @RequestBody UserUpdatePasswordRequestDto userUpdatePasswordRequestDto){
        Long updatedUserId = userService.updatePassword(id, userUpdatePasswordRequestDto);
        return new ResponseEntity<Long>(updatedUserId, HttpStatus.OK);
    }

    @ApiOperation(value = "유저 프로필 이미지 수정 API")
    @PutMapping(value = "/profile/{id}")
    public ResponseEntity<Long> updateProfileImage(@PathVariable Long id, @RequestPart(value = "image", required = false) MultipartFile file) throws IOException {
        Long updatedUserId = userService.updateProfileImage(id, file);
        return new ResponseEntity<Long>(updatedUserId, HttpStatus.OK);
    }

    @ApiOperation(value = "유저 정보 삭제 API")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        userService.delete(id);
        return new ResponseEntity<Long>(id, HttpStatus.OK);
    }
}

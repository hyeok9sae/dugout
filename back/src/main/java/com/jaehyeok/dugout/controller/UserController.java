package com.jaehyeok.dugout.controller;

import com.jaehyeok.dugout.dto.UserResponseDto;
import com.jaehyeok.dugout.dto.UserSaveRequestDto;
import com.jaehyeok.dugout.dto.UserUpdateRequestDto;
import com.jaehyeok.dugout.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    // 유저 - 목록 조회
    @ApiOperation(value = "유저 목록 조회 API", notes = "유저 목록 리스트 반환")
    @GetMapping(value = "", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<List<UserResponseDto>> findAll(){
        List<UserResponseDto> userResponseDtoList = userService.findAll();
        return new ResponseEntity<List<UserResponseDto>>(userResponseDtoList, HttpStatus.OK);
    }
    // 유저 - 상세 조회
    @ApiOperation(value = "유저 상세 조회 API", notes = "유저 상세 정보 반환")
    @GetMapping(value = "/{userId}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<UserResponseDto> findById(@PathVariable("userId") Long userId){
        UserResponseDto userResponseDto = userService.findById(userId);
        return new ResponseEntity<UserResponseDto>(userResponseDto, HttpStatus.OK);
    }
    // 유저 - 등록
    @ApiOperation(value = "유저 등록 API", notes = "유저 등록 후 해당 id값 반환")
    @PostMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Long> save(@RequestBody UserSaveRequestDto userSaveRequestDto){
        Long savedUserId = userService.save(userSaveRequestDto);
        return new ResponseEntity<Long>(savedUserId, HttpStatus.CREATED);
    }
    // 유저 - 수정
    @ApiOperation(value = "유저 수정 API", notes = "유저 수정 후 해당 id값 반환")
    @PutMapping(value = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Long> update(@PathVariable("userId") Long userId, @RequestBody UserUpdateRequestDto userUpdateRequestDto){
        Long updateduserId = userService.update(userId, userUpdateRequestDto);
        return new ResponseEntity<Long>(updateduserId, HttpStatus.CREATED);
    }
    // 유저 - 삭제
    @ApiOperation(value = "유저 삭제 API", notes = "유저 삭제 후 해당 id값 반환")
    @DeleteMapping(value = "/{userId}", produces = { MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Long> delete(@PathVariable("userId") Long userId){
        userService.delete(userId);
        return new ResponseEntity<Long>(userId, HttpStatus.NO_CONTENT);
    }
}
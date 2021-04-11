package com.jaehyeok.dugout.controller;

import com.jaehyeok.dugout.dto.UserSaveRequestDto;
import com.jaehyeok.dugout.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/user")
@RestController
public class UserController {

    private final UserService userService;

    // 유저 - 등록
    @PostMapping(value = "", produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<Long> save(@RequestBody UserSaveRequestDto userSaveRequestDto){
        Long savedUserId = userService.save(userSaveRequestDto);
        return new ResponseEntity<Long>(savedUserId, HttpStatus.CREATED);
    }
}

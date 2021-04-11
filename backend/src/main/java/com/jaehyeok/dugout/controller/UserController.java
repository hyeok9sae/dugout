package com.jaehyeok.dugout.controller;

import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @ApiOperation(value = "User Save", notes = "사용자 저장")
   @GetMapping(value = "/save")
    @ResponseBody
    public ResponseEntity saveUser(){

        return null;
    }
}

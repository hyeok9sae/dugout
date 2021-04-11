package com.jaehyeok.dugout.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserUpdateRequestDto {

    private String password;
    private String nickname;
    private String photo;
    private String stateComment;

    @Builder
    public UserUpdateRequestDto(String password, String nickname, String photo, String stateComment){
        this.password = password;
        this.nickname = nickname;
        this.photo = photo;
        this.stateComment = stateComment;
    }
}

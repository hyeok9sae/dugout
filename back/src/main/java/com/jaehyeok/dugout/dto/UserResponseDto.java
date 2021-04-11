package com.jaehyeok.dugout.dto;

import com.jaehyeok.dugout.domain.User;
import lombok.Getter;

@Getter
public class UserResponseDto {

    private Long id;
    private String email;
    private String password;
    private String nickname;
    private String photo;
    private String stateComment;
    private int isAdmin;

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.nickname = user.getNickname();
        this.photo = user.getPhoto();
        this.stateComment = user.getStateComment();
        this.isAdmin = user.getIsAdmin();
    }
}

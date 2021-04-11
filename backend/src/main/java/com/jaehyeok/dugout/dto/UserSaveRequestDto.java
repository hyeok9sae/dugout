package com.jaehyeok.dugout.dto;

import com.jaehyeok.dugout.domain.User;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UserSaveRequestDto {

    private String email;
    private String password;
    private String nickname;
    private String photo;
    private String stateComment;
    private int isAdmin;

    @Builder
    public UserSaveRequestDto(String email, String password, String nickname, String photo, String stateComment, int isAdmin){
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.photo = photo;
        this.stateComment = stateComment;
        this.isAdmin = isAdmin;
    }

    public User toEntity() {
        return User.builder()
                .email(email)
                .password(password)
                .nickname(nickname)
                .photo(photo)
                .stateComment(stateComment)
                .isAdmin(isAdmin)
                .build();
    }
}

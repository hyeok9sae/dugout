package com.jaehyeok.dugout.domain.user;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String password;
    private String nickname;
    private String photo;
    private String stateComment;
    private int isAdmin;

    @Builder
    public User(String email, String password, String nickname, String photo, String stateComment, int isAdmin){
        this.email = email;
        this.password = password;
        this.nickname = nickname;
        this.photo = photo;
        this.stateComment = stateComment;
        this.isAdmin = isAdmin;
    }

    public void update(String password, String nickname, String photo, String stateComment){
        this.password = password;
        this.nickname = nickname;
        this.photo = photo;
        this.stateComment = stateComment;
    }
}
CREATE TABLE user
(
    `id`             BIGINT          NOT NULL    AUTO_INCREMENT COMMENT '회원번호', 
    `email`          VARCHAR(45)     NOT NULL    COMMENT '이메일', 
    `password`       VARCHAR(45)     NOT NULL    COMMENT '비밀번호', 
    `nickname`       VARCHAR(16)     NOT NULL    COMMENT '닉네임', 
    `photo`          VARCHAR(255)    NULL        COMMENT '프로필사진', 
    `state_comment`  VARCHAR(50)     NULL        COMMENT '상태메세지', 
    `is_admin`       INT             NOT NULL    COMMENT '관리자', 
    PRIMARY KEY (id)
);

ALTER TABLE user COMMENT '회원';

CREATE UNIQUE INDEX UQ_user_1
    ON user(email);
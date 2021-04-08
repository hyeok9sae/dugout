CREATE TABLE user
(
    `id`             BIGINT          NOT NULL    AUTO_INCREMENT COMMENT '회원번호', 
    `email`          VARCHAR(45)     NOT NULL    COMMENT '이메일', 
    `pwd`            VARCHAR(45)     NOT NULL    COMMENT '비밀번호', 
    `nickname`       VARCHAR(16)     NOT NULL    COMMENT '닉네임', 
    `photo`          VARCHAR(255)    NULL        COMMENT '프로필사진', 
    `state_comment`  VARCHAR(255)    NULL        COMMENT '상태메세지', 
    `is_admin`       TINYINT         NOT NULL    COMMENT '관리자', 
    PRIMARY KEY (id)
);

ALTER TABLE user COMMENT '회원';

ALTER TABLE user
    ADD CONSTRAINT UC_user_email UNIQUE (email);
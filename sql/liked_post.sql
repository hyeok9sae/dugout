CREATE TABLE liked_post
(
    `id`        BIGINT     NOT NULL    AUTO_INCREMENT COMMENT '좋아요번호', 
    `is_liked`  TINYINT    NOT NULL    COMMENT '좋아요여부', 
    `user_id`   BIGINT     NOT NULL    COMMENT '회원번호', 
    `post_id`   BIGINT     NOT NULL    COMMENT '게시글번호', 
    PRIMARY KEY (id)
);

ALTER TABLE liked_post COMMENT '좋아요(게시글)';

ALTER TABLE liked_post
    ADD CONSTRAINT FK_liked_post_user_id_user_id FOREIGN KEY (user_id)
        REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE liked_post
    ADD CONSTRAINT FK_liked_post_post_id_post_id FOREIGN KEY (post_id)
        REFERENCES post (id) ON DELETE CASCADE ON UPDATE CASCADE;
CREATE TABLE liked_comment
(
    `id`          BIGINT     NOT NULL    AUTO_INCREMENT COMMENT '좋아요번호', 
    `is_liked`    TINYINT    NOT NULL    COMMENT '좋아요여부', 
    `user_id`     BIGINT     NOT NULL    COMMENT '회원번호', 
    `comment_id`  BIGINT     NOT NULL    COMMENT '댓글번호', 
    PRIMARY KEY (id)
);

ALTER TABLE liked_comment COMMENT '좋아요(댓글)';

ALTER TABLE liked_comment
    ADD CONSTRAINT FK_liked_comment_user_id_user_id FOREIGN KEY (user_id)
        REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE liked_comment
    ADD CONSTRAINT FK_liked_comment_comment_id_comment_id FOREIGN KEY (comment_id)
        REFERENCES comment (id) ON DELETE CASCADE ON UPDATE CASCADE;
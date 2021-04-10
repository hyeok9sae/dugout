CREATE TABLE good_comment
(
    `user_id`     BIGINT    NOT NULL    COMMENT '회원번호', 
    `comment_id`  BIGINT    NOT NULL    COMMENT '댓글번호', 
    PRIMARY KEY (user_id, comment_id)
);

ALTER TABLE good_comment COMMENT '좋아요(댓글)';

ALTER TABLE good_comment
    ADD CONSTRAINT FK_good_comment_user_id_user_id FOREIGN KEY (user_id)
        REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE good_comment
    ADD CONSTRAINT FK_good_comment_comment_id_comment_id FOREIGN KEY (comment_id)
        REFERENCES comment (id) ON DELETE CASCADE ON UPDATE CASCADE;
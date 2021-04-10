CREATE TABLE good_post
(
    `user_id`  BIGINT    NOT NULL    COMMENT '회원번호', 
    `post_id`  BIGINT    NOT NULL    COMMENT '게시글번호', 
    PRIMARY KEY (user_id, post_id)
);

ALTER TABLE good_post COMMENT '좋아요(게시글)';

ALTER TABLE good_post
    ADD CONSTRAINT FK_good_post_user_id_user_id FOREIGN KEY (user_id)
        REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE good_post
    ADD CONSTRAINT FK_good_post_post_id_post_id FOREIGN KEY (post_id)
        REFERENCES post (id) ON DELETE CASCADE ON UPDATE CASCADE;
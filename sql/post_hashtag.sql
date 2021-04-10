CREATE TABLE post_hashtag
(
    `post_id`     BIGINT    NOT NULL    COMMENT '게시글번호', 
    `hashtag_id`  BIGINT    NOT NULL    COMMENT '해시태그번호', 
    PRIMARY KEY (post_id, hashtag_id)
);

ALTER TABLE post_hashtag
    ADD CONSTRAINT FK_post_hashtag_post_id_post_id FOREIGN KEY (post_id)
        REFERENCES post (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE post_hashtag
    ADD CONSTRAINT FK_post_hashtag_hashtag_id_hashtag_id FOREIGN KEY (hashtag_id)
        REFERENCES hashtag (id) ON DELETE CASCADE ON UPDATE CASCADE;
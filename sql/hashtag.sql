CREATE TABLE hashtag
(
    `id`       BIGINT         NOT NULL    AUTO_INCREMENT COMMENT '해시태그번호', 
    `keyword`  VARCHAR(16)    NOT NULL    COMMENT '해시태그키워드', 
    `post_id`  BIGINT         NOT NULL    COMMENT '게시글번호', 
    PRIMARY KEY (id)
);

ALTER TABLE hashtag COMMENT '해시태그';

ALTER TABLE hashtag
    ADD CONSTRAINT FK_hashtag_post_id_post_id FOREIGN KEY (post_id)
        REFERENCES post (id) ON DELETE CASCADE ON UPDATE CASCADE;
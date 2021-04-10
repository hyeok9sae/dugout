CREATE TABLE hashtag
(
    `id`       BIGINT         NOT NULL    AUTO_INCREMENT COMMENT '해시태그번호', 
    `keyword`  VARCHAR(16)    NOT NULL    COMMENT '해시태그키워드', 
    PRIMARY KEY (id)
);

ALTER TABLE hashtag COMMENT '해시태그';
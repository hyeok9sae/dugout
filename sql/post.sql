CREATE TABLE post
(
    `id`             BIGINT          NOT NULL    AUTO_INCREMENT COMMENT '게시글번호', 
    `title`          VARCHAR(45)     NOT NULL    COMMENT '제목', 
    `content`        VARCHAR(255)    NOT NULL    COMMENT '본문', 
    `user_id`        BIGINT          NOT NULL    COMMENT '작성자', 
    `created_at`     DATETIME        NOT NULL    COMMENT '작성일', 
    `updated_at`     DATETIME        NULL        COMMENT '수정일', 
    `hits`           INT             NOT NULL    COMMENT '조회수', 
    `comment_count`  INT             NOT NULL    COMMENT '댓글수', 
    `good_count`     INT             NOT NULL    COMMENT '게시글좋아요수', 
    `board_id`       BIGINT          NOT NULL    COMMENT '게시판번호', 
    PRIMARY KEY (id)
);

ALTER TABLE post COMMENT '게시글';

ALTER TABLE post
    ADD CONSTRAINT FK_post_user_id_user_id FOREIGN KEY (user_id)
        REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE post
    ADD CONSTRAINT FK_post_board_id_board_board_id FOREIGN KEY (board_id)
        REFERENCES board (board_id) ON DELETE CASCADE ON UPDATE CASCADE;
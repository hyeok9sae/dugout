CREATE TABLE comment
(
    `id`          BIGINT          NOT NULL    AUTO_INCREMENT COMMENT '댓글번호', 
    `content`     VARCHAR(200)    NOT NULL    COMMENT '본문', 
    `user_id`     BIGINT          NOT NULL    COMMENT '작성자', 
    `created_at`  DATETIME        NOT NULL    COMMENT '작성일', 
    `updated_at`  DATETIME        NULL        COMMENT '수정일', 
    `good_count`  INT             NOT NULL    COMMENT '댓글좋아요수', 
    `post_id`     BIGINT          NOT NULL    COMMENT '게시글번호', 
    `parent`      BIGINT          NULL        COMMENT '부모댓글번호', 
    PRIMARY KEY (id)
);

ALTER TABLE comment COMMENT '댓글';

ALTER TABLE comment
    ADD CONSTRAINT FK_comment_user_id_user_id FOREIGN KEY (user_id)
        REFERENCES user (id) ON DELETE CASCADE ON UPDATE CASCADE;

ALTER TABLE comment
    ADD CONSTRAINT FK_comment_post_id_post_id FOREIGN KEY (post_id)
        REFERENCES post (id) ON DELETE CASCADE ON UPDATE CASCADE;
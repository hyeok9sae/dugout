CREATE TABLE board
(
    `board_id`  BIGINT         NOT NULL    AUTO_INCREMENT COMMENT '게시판번호', 
    `name`      VARCHAR(45)    NOT NULL    COMMENT '게시판이름', 
    PRIMARY KEY (board_id)
);

ALTER TABLE board COMMENT '팀별 게시판';

CREATE UNIQUE INDEX UQ_board_1
    ON board(name);
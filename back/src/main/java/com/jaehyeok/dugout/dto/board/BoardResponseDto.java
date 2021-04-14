package com.jaehyeok.dugout.dto.board;

import com.jaehyeok.dugout.domain.board.Board;
import lombok.Getter;

@Getter
public class BoardResponseDto {

    private Long id;
    private String name;

    public BoardResponseDto(Board board){
        this.id = board.getId();
        this.name = board.getName();
    }
}

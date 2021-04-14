package com.jaehyeok.dugout.dto.board;

import com.jaehyeok.dugout.domain.board.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardSaveRequestDto {

    private String name;

    @Builder
    public BoardSaveRequestDto(String name){
        this.name = name;
    }

    public Board toEntity(){
        return Board.builder()
                .name(name)
                .build();
    }
}

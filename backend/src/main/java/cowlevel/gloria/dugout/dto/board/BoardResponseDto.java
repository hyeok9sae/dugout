package cowlevel.gloria.dugout.dto.board;

import cowlevel.gloria.dugout.entity.board.Board;
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

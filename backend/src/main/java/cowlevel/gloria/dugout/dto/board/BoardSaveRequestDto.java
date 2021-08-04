package cowlevel.gloria.dugout.dto.board;

import cowlevel.gloria.dugout.entity.board.Board;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BoardSaveRequestDto {

    private String name;

    public Board toEntity(){
        return Board.builder()
                .name(name)
                .build();
    }
}

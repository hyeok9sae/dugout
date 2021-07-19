package cowlevel.gloria.dugout.mapper.board;

import cowlevel.gloria.dugout.dto.board.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    public List<Board> selectAllBoards();
    public Board selectBoardById(Long id);
    public boolean insertBoard(Board board);
    public boolean updateBoard(Board board);
    public boolean deleteBoardById(Long id);
}

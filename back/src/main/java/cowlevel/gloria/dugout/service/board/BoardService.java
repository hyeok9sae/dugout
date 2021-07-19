package cowlevel.gloria.dugout.service.board;

import cowlevel.gloria.dugout.dto.board.Board;

import java.util.List;

public interface BoardService {
    public List<Board> findAllBoards();
    public Board findBoardById(Long id);
    public boolean addBoard(Board board);
    public boolean modifyBoard(Board board);
    public boolean removeBoardById(Long id);
}

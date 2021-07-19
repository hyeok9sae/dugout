package cowlevel.gloria.dugout.service.board;

import cowlevel.gloria.dugout.dto.board.Board;
import cowlevel.gloria.dugout.mapper.board.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService{

    private final BoardMapper mapper;

    @Override
    public List<Board> findAllBoards() {
        return mapper.selectAllBoards();
    }

    @Override
    public Board findBoardById(Long id) {
        return mapper.selectBoardById(id);
    }

    @Override
    public boolean addBoard(Board board) {
        return mapper.insertBoard(board);
    }

    @Override
    public boolean modifyBoard(Board board) {
        return mapper.updateBoard(board);
    }

    @Override
    public boolean removeBoardById(Long id) {
        return mapper.deleteBoardById(id);
    }
}

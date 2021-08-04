package cowlevel.gloria.dugout.repository.board;

import cowlevel.gloria.dugout.entity.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
}

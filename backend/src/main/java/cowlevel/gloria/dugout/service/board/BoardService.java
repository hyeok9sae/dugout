package cowlevel.gloria.dugout.service.board;

import cowlevel.gloria.dugout.dto.board.BoardResponseDto;
import cowlevel.gloria.dugout.dto.board.BoardSaveRequestDto;
import cowlevel.gloria.dugout.dto.board.BoardUpdateRequestDto;
import cowlevel.gloria.dugout.entity.board.Board;
import cowlevel.gloria.dugout.repository.board.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional // board 목록 조회
    public List<BoardResponseDto> findAll(){
        return boardRepository.findAll()
                .stream()
                .map(BoardResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional // board 상세 조회
    public BoardResponseDto findById(Long id){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[id="+id+"] 해당 게시판이 존재하지 않습니다."));
        return new BoardResponseDto(board);
    }

    @Transactional // board 정보 등록
    public Long save(BoardSaveRequestDto boardSaveRequestDto) {
         return boardRepository.save(boardSaveRequestDto.toEntity())
                 .getId();
    }

    @Transactional // board 정보 수정
    public Long update(Long id, BoardUpdateRequestDto boardUpdateRequestDto){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[id="+id+"] 해당 게시판이 존재하지 않습니다."));
        board.update(boardUpdateRequestDto.getName());
        return id;
    }

    @Transactional // board 정보 삭제
    public Long delete(Long id){
        Board board = boardRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[id="+id+"] 해당 게시판이 존재하지 않습니다."));
        boardRepository.delete(board);
        return id;
    }
}

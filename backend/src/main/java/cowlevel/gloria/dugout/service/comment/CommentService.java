package cowlevel.gloria.dugout.service.comment;

import cowlevel.gloria.dugout.dto.comment.CommentResponseDto;
import cowlevel.gloria.dugout.dto.comment.CommentSaveRequestDto;
import cowlevel.gloria.dugout.dto.comment.CommentUpdateRequestDto;
import cowlevel.gloria.dugout.entity.comment.Comment;
import cowlevel.gloria.dugout.repository.comment.CommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Transactional // comment 목록 조회
    public List<CommentResponseDto> findAll(){
        return commentRepository.findAll()
                .stream()
                .map(CommentResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional // comment 상세 조회
    public CommentResponseDto findById(Long id){
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[id="+id+"] 해당 comment 가 존재하지 않습니다."));
        return new CommentResponseDto(comment);
    }

    @Transactional // comment 등록
    public Long save(CommentSaveRequestDto commentSaveRequestDto){
        return commentRepository.save(commentSaveRequestDto.toEntity())
                .getId();
    }

    @Transactional // comment 수정
    public Long update(Long id, CommentUpdateRequestDto commentUpdateRequestDto){
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[id="+id+"] 해당 comment 가 존재하지 않습니다."));
        comment.update(commentUpdateRequestDto.getContent());
        comment.updateUpdatedAt();
        return id;
    }

    @Transactional // comment 삭제
    public Long delete(Long id){
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[id="+id+"] 해당 유저가 존재하지 않습니다."));
        commentRepository.delete(comment);
        return id;
    }
}

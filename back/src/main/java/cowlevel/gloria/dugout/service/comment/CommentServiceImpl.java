package cowlevel.gloria.dugout.service.comment;

import cowlevel.gloria.dugout.dto.comment.Comment;
import cowlevel.gloria.dugout.mapper.comment.CommentMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommentServiceImpl implements CommentService{

    private final CommentMapper mapper;

    @Override
    public List<Comment> findAllComments() {
        return mapper.selectAllComments();
    }

    @Override
    public Comment findCommentById(Long id) {
        return mapper.selectCommentById(id);
    }

    @Override
    public boolean addComment(Comment comment) {
        return mapper.insertComment(comment);
    }

    @Override
    public boolean modifyComment(Comment comment) {
        return mapper.updateComment(comment);
    }

    @Override
    public boolean removeCommentById(Long id) {
        return mapper.deleteCommentById(id);
    }
}

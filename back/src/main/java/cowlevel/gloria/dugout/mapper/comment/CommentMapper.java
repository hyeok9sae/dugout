package cowlevel.gloria.dugout.mapper.comment;

import cowlevel.gloria.dugout.dto.comment.Comment;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CommentMapper {
    public List<Comment> selectAllComments();
    public Comment selectCommentById(Long id);
    public boolean insertComment(Comment comment);
    public boolean updateComment(Comment comment);
    public boolean deleteCommentById(Long id);
}

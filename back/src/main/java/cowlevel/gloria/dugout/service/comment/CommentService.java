package cowlevel.gloria.dugout.service.comment;

import cowlevel.gloria.dugout.dto.comment.Comment;

import java.util.List;

public interface CommentService {
    public List<Comment> findAllComments();
    public Comment findCommentById(Long id);
    public boolean addComment(Comment comment);
    public boolean modifyComment(Comment comment);
    public boolean removeCommentById(Long id);
}

package cowlevel.gloria.dugout.dto.comment;

import cowlevel.gloria.dugout.entity.comment.Comment;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class CommentResponseDto {

    private Long id;
    private String content;
    private Long userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int goodCount;
    private Long articleId;
    private Long parent;

    public CommentResponseDto(Comment comment) {
        this.id = comment.getId();
        this.content = comment.getContent();
        this.userId = comment.getUserId();
        this.createdAt = comment.getCreatedAt();
        this.updatedAt = comment.getUpdatedAt();
        this.goodCount = comment.getGoodCount();
        this.articleId = comment.getArticleId();
        this.parent = comment.getParent();
    }
}

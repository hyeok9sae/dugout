package cowlevel.gloria.dugout.dto.comment;

import cowlevel.gloria.dugout.entity.comment.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentSaveRequestDto {

    private String content;
//    private Long userId;
//    private LocalDateTime createdAt;
//    private LocalDateTime updatedAt;
//    private int goodCount;
//    private Long articleId;
//    private Long parent;

    public Comment toEntity(){
        return Comment.builder()
                .content(content)
//                .userId(userId)
//                .createdAt(createdAt)
//                .updatedAt(updatedAt)
//                .goodCount(goodCount)
//                .articleId(articleId)
//                .parent(parent)
                .build();
    }
}

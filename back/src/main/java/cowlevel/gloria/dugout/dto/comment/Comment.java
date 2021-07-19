package cowlevel.gloria.dugout.dto.comment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class Comment {
    private Long id;
    private String content;
    private Long userId;
    private Date createdAt;
    private Date updatedAt;
    private int goodCount;
    private Long postId;
    private Long parent;
}

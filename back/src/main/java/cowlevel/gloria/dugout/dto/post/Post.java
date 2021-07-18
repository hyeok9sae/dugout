package cowlevel.gloria.dugout.dto.post;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.Date;

@Getter
@Setter
@Component
public class Post {
    private Long id;
    private String title;
    private String content;
    private Long userId;
    private Date createdAt;
    private Date updatedAt;
    private int hits;
    private int commentCount;
    private int goodCount;
    private Long boardId;
    private String thumbnail;
}

package cowlevel.gloria.dugout.dto.article;

import cowlevel.gloria.dugout.entity.article.Article;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Date;

@Getter
public class ArticleResponseDto {
    private Long id;
    private String title;
    private String content;
    private Long userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private int hits;
    private int commentCount;
    private int goodCount;
    private Long boardId;

    public ArticleResponseDto(Article article){
        this.id = article.getId();
        this.title = article.getTitle();
        this.content = article.getContent();
        this.userId = article.getUserId();
        this.createdAt = article.getCreatedAt();
        this.updatedAt = article.getUpdatedAt();
        this.hits = article.getHits();
        this.commentCount = article.getCommentCount();
        this.goodCount = article.getGoodCount();
        this.boardId = article.getBoardId();
    }
}

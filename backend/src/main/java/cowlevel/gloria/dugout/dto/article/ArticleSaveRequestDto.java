package cowlevel.gloria.dugout.dto.article;

import cowlevel.gloria.dugout.entity.article.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ArticleSaveRequestDto {
    private String title;
    private String content;
//    private String userId;
//    private String createdAt;
//    private String updatedAt;
//    private int hits;
//    private int commentCount;
//    private int goodCount;
//    private Long boardId;

    public Article toEntity(){
        return Article.builder()
                .title(title)
                .content(content)
                .build();
    }
}

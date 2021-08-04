package cowlevel.gloria.dugout.entity.article;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "article")
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String title;

    @NotNull
    private String content;

    @NotNull
    @Column(name = "user_id")
    private Long userId;

    @NotNull
    @Column(name = "created_at")
    @CreatedDate
    private Date createdAt;

    @Column(name = "updated_at")
    @LastModifiedDate
    private Date updatedAt;

    @NotNull
    private int hits;

    @NotNull
    @Column(name = "comment_count")
    private int commentCount;

    @NotNull
    @Column(name = "good_count")
    private int goodCount;

    @NotNull
    @Column(name = "board_id")
    private Long boardId;

    @Builder
    public Article(String title, String content, Long userId, Date createdAt, Date updatedAt, int hits, int commentCount, int goodCount, Long boardId) {
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.hits = hits;
        this.commentCount = commentCount;
        this.goodCount = goodCount;
        this.boardId = boardId;
    }
}

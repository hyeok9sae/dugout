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
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

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

    @PrePersist
    public void setPrePersist(){
        this.hits = 0;
        this.commentCount = 0;
        this.goodCount = 0;
        this.userId = 0L;
        this.boardId = 0L;
        this.createdAt = LocalDateTime.now();
    }

    @Builder
    public Article(String title, String content, Long userId, LocalDateTime createdAt, LocalDateTime updatedAt, int hits, int commentCount, int goodCount, Long boardId) {
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

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

    public void updateHits(int hits){
        this.hits = hits+1;
    }

    public void updateUpdatedAt(){
        this.updatedAt = LocalDateTime.now();
    }
}

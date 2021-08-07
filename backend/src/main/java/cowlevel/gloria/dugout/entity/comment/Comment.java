package cowlevel.gloria.dugout.entity.comment;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

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
    @Column(name = "good_count")
    private int goodCount;

    @NotNull
    @Column(name = "article_id")
    private Long articleId;

    private Long parent;

    @PrePersist
    public void setPrePersist(){
        this.userId = 0L;
        this.createdAt = LocalDateTime.now();
        this.goodCount = 0;
        this.articleId = 0L;
        this.parent = 0L;
    }

    @Builder
    public Comment(String content, Long userId, LocalDateTime createdAt, LocalDateTime updatedAt, int goodCount, Long articleId, Long parent) {
        this.content = content;
        this.userId = userId;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.goodCount = goodCount;
        this.articleId = articleId;
        this.parent = parent;
    }

    public void update(String content){
        this.content = content;
    }

    public void updateUpdatedAt(){
        this.updatedAt = LocalDateTime.now();
    }
}

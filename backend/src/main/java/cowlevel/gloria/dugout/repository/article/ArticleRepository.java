package cowlevel.gloria.dugout.repository.article;

import cowlevel.gloria.dugout.entity.article.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleRepository extends JpaRepository<Article, Long> {
}

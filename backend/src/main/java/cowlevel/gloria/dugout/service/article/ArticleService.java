package cowlevel.gloria.dugout.service.article;

import cowlevel.gloria.dugout.dto.article.ArticleResponseDto;
import cowlevel.gloria.dugout.dto.article.ArticleSaveRequestDto;
import cowlevel.gloria.dugout.dto.article.ArticleUpdateRequestDto;
import cowlevel.gloria.dugout.entity.article.Article;
import cowlevel.gloria.dugout.repository.article.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional  // article 목록 조회
    public List<ArticleResponseDto> findAll(){
        return articleRepository.findAll()
                .stream()
                .map(ArticleResponseDto::new)
                .collect(Collectors.toList());
    }

    @Transactional // article 상세 조회
    public ArticleResponseDto findById(Long id){
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[id="+id+"] 해당 article 이 존재하지 않습니다."));
        article.updateHits(article.getHits()); // 조회수 + 1
        return new ArticleResponseDto(article);
    }

    @Transactional // article 등록
    public Long save(ArticleSaveRequestDto articleSaveRequestDto) {
        return articleRepository.save(articleSaveRequestDto.toEntity())
                .getId();
    }

    @Transactional // article 수정
    public Long update(Long id, ArticleUpdateRequestDto articleUpdateRequestDto){
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[id="+id+"] 해당 article 이 존재하지 않습니다."));
        article.update(articleUpdateRequestDto.getTitle(), articleUpdateRequestDto.getContent());
        article.updateUpdatedAt(); // update 시간 기록
        return id;
    }

    @Transactional // article 삭제
    public Long delete(Long id){
        Article article = articleRepository.findById(id)
                .orElseThrow(() -> new IllegalAccessError("[id="+id+"] 해당 article 이 존재하지 않습니다."));
        articleRepository.delete(article);
        return id;
    }
}

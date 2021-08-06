package cowlevel.gloria.dugout.controller.article;

import cowlevel.gloria.dugout.dto.article.ArticleResponseDto;
import cowlevel.gloria.dugout.dto.article.ArticleSaveRequestDto;
import cowlevel.gloria.dugout.dto.article.ArticleUpdateRequestDto;
import cowlevel.gloria.dugout.service.article.ArticleService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"*"})
@RequiredArgsConstructor
@RequestMapping("/article")
@RestController
public class ArticleController {

    private final ArticleService articleService;

    @ApiOperation(value = "article 목록 조회")
    @GetMapping(value = "/all")
    public ResponseEntity<List<ArticleResponseDto>> findAll(){
        List<ArticleResponseDto> articleResponseDtoList = articleService.findAll();
        return new ResponseEntity<List<ArticleResponseDto>>(articleResponseDtoList, HttpStatus.OK);
    }

    @ApiOperation(value = "article 상세 조회")
    @GetMapping(value = "/{id}")
    public ResponseEntity<ArticleResponseDto> findById(@PathVariable Long id){
        ArticleResponseDto articleResponseDto = articleService.findById(id);
        return new ResponseEntity<ArticleResponseDto>(articleResponseDto, HttpStatus.OK);
    }

    @ApiOperation(value = "article 등록")
    @PostMapping(value = "/up")
    public ResponseEntity<Long> save(@RequestBody ArticleSaveRequestDto articleSaveRequestDto){
        Long savedArticleId = articleService.save(articleSaveRequestDto);
        return new ResponseEntity<Long>(savedArticleId, HttpStatus.OK);
    }

    @ApiOperation(value = "article 수정")
    @PutMapping(value = "/{id}")
    public ResponseEntity<Long> update(@PathVariable Long id, @RequestBody ArticleUpdateRequestDto articleUpdateRequestDto){
        Long updatedArticleId = articleService.update(id, articleUpdateRequestDto);
        return new ResponseEntity<Long>(updatedArticleId, HttpStatus.OK);
    }

    @ApiOperation(value = "article 삭제")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        articleService.delete(id);
        return new ResponseEntity<Long>(id, HttpStatus.OK);
    }
}

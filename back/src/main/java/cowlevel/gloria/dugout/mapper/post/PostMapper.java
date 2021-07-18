package cowlevel.gloria.dugout.mapper.post;

import cowlevel.gloria.dugout.dto.post.Post;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface PostMapper {
    public List<Post> selectAllPosts();
    public Post selectPostById(Long id);
    public boolean insertPost(Post post);
    public boolean updatePost(Post post);
    public boolean deletePostById(Long id);
}

package cowlevel.gloria.dugout.service.post;

import cowlevel.gloria.dugout.dto.post.Post;
import cowlevel.gloria.dugout.mapper.post.PostMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    @Autowired
    private PostMapper mapper;

    @Override
    public List<Post> findAllPosts() {
        return mapper.selectAllPosts();
    }

    @Override
    public Post findPostById(Long id) {
        return mapper.selectPostById(id);
    }

    @Override
    public boolean addPost(Post post) {
        return mapper.insertPost(post);
    }

    @Override
    public boolean modifyPost(Post post) {
        return mapper.updatePost(post);
    }

    @Override
    public boolean removePostById(Long id) {
        return mapper.deletePostById(id);
    }
}

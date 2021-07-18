package cowlevel.gloria.dugout.service.post;

import cowlevel.gloria.dugout.dto.post.Post;

import java.util.List;

public interface PostService {
    public List<Post> findAllPosts();
    public Post findPostById(Long id);
    public boolean addPost(Post post);
    public boolean modifyPost(Post post);
    public boolean removePostById(Long id);
}

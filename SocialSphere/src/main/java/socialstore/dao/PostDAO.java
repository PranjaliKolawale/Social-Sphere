package socialstore.dao;

import java.util.*;
import socialstore.dto.PostDTO;
import socialstore.model.Post;
public interface PostDAO {
    int insert(Post post);
    List<PostDTO> viewAllPosts();
//    int countPost();
}

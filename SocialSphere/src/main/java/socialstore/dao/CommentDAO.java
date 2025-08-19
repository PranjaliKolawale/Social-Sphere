package socialstore.dao;

import java.util.*;
import socialstore.model.Comment;
import socialstore.dto.CommentDTO;
public interface CommentDAO {
    int addComment(Comment comment);
    List<CommentDTO> getAllCommentsforPost(int postId);
}

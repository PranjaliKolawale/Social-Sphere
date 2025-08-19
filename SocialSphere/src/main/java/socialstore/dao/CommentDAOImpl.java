package socialstore.dao;

import socialstore.dto.CommentDTO;
import socialstore.model.Comment;
import socialstore.model.Post;
import socialstore.util.DBUtil;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.*;

public class CommentDAOImpl implements CommentDAO{
    @Override
    public int addComment(Comment comment){
        try{
            String sql = "insert into comment(post_id, user_id, content) values(?, ?, ?)";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, comment.getPostId());
            preparedStatement.setInt(2, comment.getUserId());
            preparedStatement.setString(3, comment.getContent());

            int resCount = preparedStatement.executeUpdate();
            return resCount;

        }catch(SQLException e){
            e.printStackTrace();

        }
        return 0;
    }

    @Override
    public List<CommentDTO> getAllCommentsforPost(int postId){
        List<CommentDTO> comments = new ArrayList<>();
        try{
            String sql = "select c.comment_id, p.post_id, u.user_id, u.name AS username, c.timestamp_comment, c.content from comment c inner join post p on c.post_id = p.post_id inner join userdata u on c.user_id = u.user_id where c.post_id = ? order by c.timestamp_comment ASC";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, postId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                CommentDTO commentDTO = new CommentDTO(
                        resultSet.getInt("comment_id"),
                        resultSet.getInt("post_id"),
                        resultSet.getInt("user_id"),
                        resultSet.getString("username"),
                        resultSet.getTimestamp("timestamp_comment"),
                        resultSet.getString("content")

                );
                comments.add(commentDTO);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return comments;
    }


}

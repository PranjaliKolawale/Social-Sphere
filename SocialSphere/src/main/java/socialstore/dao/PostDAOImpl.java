package socialstore.dao;

import socialstore.dto.PostDTO;
import socialstore.model.User;
import socialstore.util.DBUtil;

import java.sql.*;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.*;

import socialstore.dao.UserDAO;
import socialstore.model.Post;
import socialstore.util.DBUtil;

public class PostDAOImpl implements PostDAO{
    @Override
    public int insert(Post post){
        try{
            String sql = "insert into post(user_id, content) values(?, ?)";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setInt(1, post.getUserId());
            preparedStatement.setString(2, post.getContent());

            int resCount = preparedStatement.executeUpdate();
            return resCount;

        }catch(SQLException e){
            e.printStackTrace();

        }
        return 0;
    }

    @Override
    public List<PostDTO> viewAllPosts(){
        List<PostDTO> posts = new ArrayList<>();
        try{
            Statement statement = DBUtil.getConnection().createStatement();
            String sql = "select p.post_id, p.user_id, u.name AS username, p.timestamp_post, p.content from post p inner join userdata u on p.user_id = u.user_id order by p.timestamp_post DESC";
            ResultSet resultSet = statement.executeQuery(sql);

            while(resultSet.next()){
                PostDTO postDTO = new PostDTO(
                        resultSet.getInt("user_id"),
                        resultSet.getInt("post_id"),
                        resultSet.getString("username"),
                        resultSet.getTimestamp("timestamp_post"),
                        resultSet.getString("content")

                );
                posts.add(postDTO);
            }
        }catch(SQLException e){
            e.printStackTrace();

        }

        return posts;
    }

//    @Override
//    public int countPost() {
//        try {
//            Statement statement = DBUtil.getConnection().createStatement();
//            String sql = "select count(post_id) from post";
//            ResultSet resultSet = statement.executeQuery(sql);
//            return resultSet
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
}

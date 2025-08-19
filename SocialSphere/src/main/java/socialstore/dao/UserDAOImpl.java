package socialstore.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import socialstore.dao.UserDAO;
import socialstore.model.User;
import socialstore.util.DBUtil;
public class UserDAOImpl implements UserDAO{
    @Override
    public int insert(User user){
        try{
            String sql = "insert into userdata(name, email, password) values(?, ?, ?)";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, user.getName());
            preparedStatement.setString(2, user.getEmail());
            preparedStatement.setString(3, user.getPassword());

            int resCount = preparedStatement.executeUpdate();
            return resCount;

        }catch(SQLException e){
            e.printStackTrace();

        }
        return 0;
    }

    @Override
    public User login(String name, String password){
        try{
            String sql = "select * from userdata where name=? and password=?";
            PreparedStatement preparedStatement = DBUtil.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, password);

            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                User user = new User(
                    rs.getInt("user_id"),
                    rs.getString("name"),
                    rs.getString("email"),
                    rs.getString("password")
                    );
                return user;
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return null;

    }

}

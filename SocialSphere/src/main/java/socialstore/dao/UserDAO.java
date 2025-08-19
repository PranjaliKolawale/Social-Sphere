package socialstore.dao;

import socialstore.model.User;
public interface UserDAO {
    int insert(User user);
    User login(String name, String password);
}

package socialstore.runner;

import socialstore.dao.*;
import socialstore.model.User;
import socialstore.model.Post;
import socialstore.model.Comment;

public class TestSocialStore {
    public static void main(String args[]){
        UserDAO userDAO = new UserDAOImpl();
        PostDAO postDAO = new PostDAOImpl();
        CommentDAO commentDAO = new CommentDAOImpl();
//        int res = userDAO.insert(new User(0, "alam", "alam@abc.com", "alamstore"));
//       System.out.println(res + " books inserted");

//        int res = postDAO.insert(new Post(0, 3, null, "night bliss"));
//       System.out.println(res + " books inserted");

//        int res = commentDAO.insert(new Comment(0, 2, 4, null, "nice world"));
//        System.out.println(res + "comment inserted");


    }
}

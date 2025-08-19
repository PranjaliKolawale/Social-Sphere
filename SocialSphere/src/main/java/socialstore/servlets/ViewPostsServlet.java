package socialstore.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import socialstore.dao.PostDAO;
import socialstore.dao.PostDAOImpl;
import socialstore.dto.PostDTO;
import socialstore.model.User;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
import java.sql.*;

@WebServlet("/ViewPostsServlet")
public class ViewPostsServlet extends HttpServlet{
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        HttpSession session = req.getSession(false);
        if(session != null && session.getAttribute("currentUser") != null) {
            User currentUser = (User) session.getAttribute("currentUser");

            PostDAO postDAO = new PostDAOImpl();
            List<PostDTO> posts = postDAO.viewAllPosts();
            out.println("<h3>All Users Posts</h3>");
            for (PostDTO post : posts) {
                out.println("<p><b>Username: </b>" + post.getName() + "</p>");
                out.println("<p><b>Content: </b>" + post.getContent() + "</p>");
                out.println("<p><b>Timestamp: </b>" + post.getTimestamp() + "</p>");
                out.println("<button><a href=createcomment.jsp?postId="+post.getPostId()+">Add a Comment</a></button>");
                out.println("<button><a href=ViewCommentsServlet?postId="+post.getPostId()+">View All Comments</a></button>");
            }

            out.println("<br><br>");
            out.println("<button><a href=home.html>Back to Home</a></button>");
        }else{
            out.println("<h3>Please login first</h3>");
        }

    }
}

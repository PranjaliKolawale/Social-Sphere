package socialstore.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import socialstore.dao.CommentDAO;
import socialstore.dao.CommentDAOImpl;
import socialstore.dto.CommentDTO;
import socialstore.dao.UserDAOImpl;
import socialstore.model.Comment;

import java.io.PrintWriter;
import java.util.*;

import java.io.IOException;

@WebServlet("/ViewCommentsServlet")
public class ViewCommentsServlet extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException {
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        HttpSession session = req.getSession(false);
        if(session != null && session.getAttribute("currentUser")!= null) {
            int postId = Integer.parseInt(req.getParameter("postId"));

            CommentDAO commentDAO = new CommentDAOImpl();
            List<CommentDTO> comments = commentDAO.getAllCommentsforPost(postId);
            int count = comments.size();
            req.setAttribute("comments", comments);
            req.setAttribute("postId", postId);
            for (CommentDTO comment : comments) {
                out.println("<p><b>Username:</b>" + comment.getUsername() + "</p>");
                out.println("<p><b>Comment:</b>" + comment.getContent() + "<p>");
                out.println("<p><b>Time:</b>" + comment.getTimestamp() + "<p>");
                out.println("<hr>");
            }
            out.println("<br><br>");
            out.println("<button><a href=ViewPostsServlet?count="+count+">Total Comments "+count+"</a></button>");
            out.println("<button><a href=home.html>Back to Home</a></button>");
        }else{
            out.println("<h3>Please login first</h3>");

        }



    }
}

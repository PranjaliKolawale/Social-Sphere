package socialstore.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import socialstore.dao.CommentDAO;
import socialstore.dao.CommentDAOImpl;
import socialstore.model.*;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CreateCommentServlet")
public class CreateCommentServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String content = req.getParameter("content");
        int postId = Integer.parseInt(req.getParameter("postId"));
        HttpSession session = req.getSession(false);
        if(session != null && session.getAttribute("currentUser") != null){
            User currenttUser = (User) session.getAttribute("currentUser");
            int userId = currenttUser.getUserId();

            Comment comment = new Comment(0, postId, userId, null, content);
            CommentDAO commentDAO = new CommentDAOImpl();
            commentDAO.addComment(comment);
            out.println("<script>alert('Comment Added Successfully'); window.location='home.html'</script>");
        }else{
            out.println("<h3>Please Login first</h3>");
        }

    }
}

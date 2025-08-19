package socialstore.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import socialstore.dao.PostDAO;
import socialstore.dao.PostDAOImpl;
import socialstore.model.Post;
import socialstore.model.User;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/CreatePostServlet")
public class CreatePostServlet extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html");
        PrintWriter out =res.getWriter();

        String content = req.getParameter("content");

        HttpSession session = req.getSession(false);
        if(session != null && session.getAttribute("currentUser")!=null){
            User currentUser = (User) session.getAttribute("currentUser");
            int userId = currentUser.getUserId();

            Post post = new Post(0, userId, null, content);
            PostDAO postDAO = new PostDAOImpl();
            postDAO.insert(post);
            out.println("<script>alert('Post Added Successfully'); window.location='home.html'</script>");
        }else{
            out.println("<h3>Please login first</h3>");
        }


    }
}

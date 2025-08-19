package socialstore.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import socialstore.dao.UserDAO;
import socialstore.dao.UserDAOImpl;
import socialstore.model.User;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException{
        res.setContentType("text/html");
        PrintWriter out = res.getWriter();

        String name = req.getParameter("name");
        String password = req.getParameter("password");

        UserDAO userDAO = new UserDAOImpl();
        User user = userDAO.login(name, password);

        if(user != null){
            HttpSession session = req.getSession();
            session.setAttribute("currentUser", user);

            res.sendRedirect("home.html");
        }else{
            out.println("Invalid username or password. Please try again");
        }

    }
}

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/login")
public class loginServlet extends HttpServlet {

    private final String uname = "admin";
    private final String pwd = "123456";
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/login.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        System.out.println("username:\t"+username);
        System.out.println("password:\t"+password);

        if (uname.equals(username)&&(pwd.equals(password))){
            resp.sendRedirect("/lession03_jsp_war/home.jsp");
        }
        else {
            req.setAttribute("msg","用户名或密码错误");
            req.getRequestDispatcher("/login.jsp").forward(req, resp);
        }


    }
}
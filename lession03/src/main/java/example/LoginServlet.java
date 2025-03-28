package example;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 获取表单参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 获取 ServletContext 中的用户数据
        ServletContext context = getServletContext();
        @SuppressWarnings("unchecked")
        Map<String, String> users = (Map<String, String>) context.getAttribute("users");

        if (users != null && users.containsKey(username) && users.get(username).equals(password)) {
            out.println("<h2>Login Successful! Welcome, " + username + "</h2>");
        } else {
            out.println("<h2>Login Failed! Invalid username or password.</h2>");
            out.println("<a href='login.jsp'>Try Again</a>");
        }
    }
}
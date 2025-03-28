package example;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "RegisterServlet", urlPatterns = "/resgister")
public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("resgister.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 获取表单参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // 获取 ServletContext 并存储用户数据
        ServletContext context = getServletContext();
        @SuppressWarnings("unchecked")
        Map<String, String> users = (Map<String, String>) context.getAttribute("users");
        if (users == null) {
            users = new HashMap<>();
            context.setAttribute("users", users);
        }

        // 保存用户名和密码
        users.put(username, password);

        out.println("<h2>Registration Successful! Username: " + username + "</h2>");
        out.println("<a href='login.jsp'>Go to Login</a>");
    }
}
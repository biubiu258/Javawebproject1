package example;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "MyServlet", urlPatterns = "/myServlet")
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // ServletContext
        ServletContext context = getServletContext();
        context.setAttribute("appName", "MyWebApp");
        out.println("App Name: " + context.getAttribute("appName") + "<br>");

        // 状态码
        response.setStatus(HttpServletResponse.SC_OK);

        // 响应头
        response.setHeader("Custom-Header", "MyValue");

        // 请求行信息
        out.println("Method: " + request.getMethod() + "<br>");
        out.println("URI: " + request.getRequestURI() + "<br>");

        // 请求头
        out.println("User-Agent: " + request.getHeader("User-Agent") + "<br>");

        // 重定向（注释掉以测试其他功能）
        // response.sendRedirect("/MyWebProject/anotherServlet");

        // 请求转发并传递数据
        request.setAttribute("message", "Data from MyServlet");
        // RequestDispatcher dispatcher = request.getRequestDispatcher("/anotherServlet");
        // dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // 获取请求参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        out.println("Username: " + username + "<br>");
        out.println("Password: " + password);
    }
}
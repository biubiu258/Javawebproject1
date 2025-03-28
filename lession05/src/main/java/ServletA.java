import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLEncoder;


@WebServlet("/a")
public class ServletA extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("username","admin");
        resp.addCookie(cookie);
        String username = "张    三";
        String encodeUsername = URLEncoder.encode(username, "UTF-8");  // 编码
        Cookie cookie2 = new Cookie("uname",encodeUsername);
        resp.addCookie(cookie2);
    }
}
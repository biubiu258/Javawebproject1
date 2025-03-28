import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.net.URLDecoder;


@WebServlet("/b")
public class ServletB extends HttpServlet {
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            String cname = cookie.getName();
            String cvalue = cookie.getValue();
            System.out.println("name:\t" + cname + "\tvalue :\t" + cvalue);
            if ("uname".equals(cname)) {
                String decodeUsername = URLDecoder.decode(cookie.getValue(), "UTF-8");  //解码
                System.out.println(decodeUsername);
            }
        }
    }
}
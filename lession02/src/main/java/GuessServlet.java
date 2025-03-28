import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/guess")
public class GuessServlet extends HttpServlet {
    @Override
    public void init() throws ServletException {
        int randomNumber = (int)(Math.random() * 100) + 1;
        ServletContext context =  getServletContext();
        context.setAttribute("randomNumber", randomNumber);
        System.out.println(randomNumber);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        int guess = Integer.parseInt(request.getParameter("guess"));
        int randomNumber = (int)getServletContext().getAttribute("randomNumber");

        String message;
        if (guess == randomNumber) {
            message = "恭喜你！你猜对了！正确答案是："+randomNumber;
        } else if (guess > randomNumber) {
            message = "太高了!";
        } else {
            message = "太低了!";
        }

        request.setAttribute("message", message);
        request.getRequestDispatcher("/result.jsp").forward(request, response);

    }
}
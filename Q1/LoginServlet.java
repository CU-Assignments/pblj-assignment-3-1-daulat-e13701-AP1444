import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoginServlet extends HttpServlet {
    // Hardcoded valid credentials for demo purposes
    private static final String VALID_USERNAME = "mayank";
    private static final String VALID_PASSWORD = "1234";

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        // Read form fields
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // Basic validation
        if (VALID_USERNAME.equals(username) && VALID_PASSWORD.equals(password)) {
            out.println("<h2>Welcome, " + username + "!</h2>");
            out.println("<p>Login successful.</p>");
        } else {
            out.println("<h3>Login Failed</h3>");
            out.println("<p>Invalid username or password.</p>");
        }
        out.close();
    }
}

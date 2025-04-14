import java.io.*;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class EmployeeServlet extends HttpServlet {
    private Connection conn;

    public void init() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/company", "root", "yourpassword");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

protected void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException {
response.setContentType("text/html");
PrintWriter out = response.getWriter();
String empId = request.getParameter("id");
try {
Statement stmt = conn.createStatement();
ResultSet rs;
if (empId != null && !empId.isEmpty()) {
PreparedStatement ps = conn.prepareStatement("SELECT * FROM
employees WHERE id = ?");
ps.setInt(1, Integer.parseInt(empId));
rs = ps.executeQuery();
if (rs.next()) {
out.println("<h3>Employee Details:</h3>");
out.println("<p>ID: " + rs.getInt("id") + "</p>");
out.println("<p>Name: " + rs.getString("name") + "</p>");
out.println("<p>Department: " + rs.getString("department") + "</p>");
out.println("<p>Salary: $" + rs.getDouble("salary") + "</p>");
} else {
out.println("<p>No employee found with ID: " + empId + "</p>");
}
} else {
rs = stmt.executeQuery("SELECT * FROM employees");
out.println("<h3>All Employees:</h3>");
out.println("<table border='1'>");
out.println("<tr><th>ID</th><th>Name</th><th>Department</th><th>Salary</th></tr>
");
while (rs.next()) {
out.println("<tr>");
out.println("<td>" + rs.getInt("id") + "</td>");
out.println("<td>" + rs.getString("name") + "</td>");
out.println("<td>" + rs.getString("department") + "</td>");
out.println("<td>$" + rs.getDouble("salary") + "</td>");
out.println("</tr>");
}
out.println("</table>");
}
} catch (Exception e) {
out.println("<p>Error: " + e.getMessage() + "</p>");
}
}

    public void destroy() {
        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
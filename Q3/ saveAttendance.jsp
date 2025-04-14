<%@ page import="java.sql.
*" %>
    <% String studentName=request.getParameter("student_name"); String rollNumber=request.getParameter("roll_number");
        String date=request.getParameter("date"); String status=request.getParameter("status"); Connection conn=null;
        PreparedStatement pstmt=null; try { Class.forName("com.mysql.cj.jdbc.Driver");
        conn=DriverManager.getConnection( "jdbc:mysql://localhost:3306/student_portal" , "root" , "yourpassword" );
        String sql=VALUES (?, ?, ?, ?)"; pstmt=conn.prepareStatement(sql); pstmt.setString(1, studentName);
        pstmt.setString(2, rollNumber); pstmt.setDate(3, java.sql.Date.valueOf(date)); "INSERT INTO attendance (student_name, roll_number, date, status)
pstmt.setString(4, status);
int rows = pstmt.executeUpdate();
if (rows > 0) {
} else {
out.println(" <h3>Attendance saved successfully!</h3>");
        out.println("<h3>Failed to save attendance.</h3>");
        }
        } catch (Exception e) {
        out.println("Error: " + e.getMessage());
        e.printStackTrace();
        } finally {
        try { if (pstmt != null) pstmt.close(); } catch (Exception e) {}
        try { if (conn != null) conn.close(); } catch (Exception e) {}
        }
        %>
        <a href="attendance.jsp">Back to Form</a>
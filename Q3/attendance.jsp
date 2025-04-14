<%@ page language="java" contentType="text/html; charset=UTF-8" %>
    <!DOCTYPE html>
    <html>

    <head>
        <title>Student Attendance Portal</title>
    </head>

    <body>
        <h2>Enter Student Attendance</h2>
        <form action="saveAttendance.jsp" method="post">
            <label>Student Name:</label><br>
            <input type="text" name="student_name" required><br><br>
            <label>Roll Number:</label><br>
            <input type="text" name="roll_number" required><br><br>
            <label>Date:</label><br>
            <input type="date" name="date" required><br><br>
            <label>Status:</label><br>
            <select name="status" required>
                <option value="Present">Present</option>
                <option value="Absent">Absent</option>
            </select><br><br>
            <input type="submit" value="Save Attendance">
        </form>
    </body>

    </html>
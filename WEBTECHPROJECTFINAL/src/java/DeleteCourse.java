import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/DeleteCourse")
public class DeleteCourse extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        handleRequest(request, response);
    }

    private void handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve the semId parameter from the request
        int semId = Integer.parseInt(request.getParameter("semId"));
        String n = semName(semId);
        // Display the data
        out.println("<html><head><title>Courses</title></head><body>");
        out.println("<h1>COURSE DELETION</h1>");
        out.println("<p><h2>Semester: " + n+ "</h2></p>");
        // Display the form for adding a course
        displayRemoveCourseForm(out, semId);

        // Check if the form was submitted
        if ("deleteCourse".equals(request.getParameter("action"))) {
            // If the form was submitted, add the course to the database
            removeCourseFromDatabase(request, out, semId);
        }

        // Display the table with all the course details
        displayCourseTable(out, semId);
    }
    private String semName(int semId) {
        switch (semId) {
            case 101:
                return "Semester 1";
            case 102:
                return "Semester 1";
            case 103:
                return "Semester 3";
            case 104:
                return "Semester 4";
            case 105:
                return "Semester 5";
            case 106:
                return "Semester 6";
            case 107:
                return "Semester 7";
            case 108:
                return  "Semester 8";
            default:
                return "Semester 1";
        }
    }

    private void displayRemoveCourseForm(PrintWriter out,int semId) {
        // Display the form for removing a course
        out.println("<form action='' method='post'>");
        out.println("<input type='hidden' name='action' value='deleteCourse'/>");
        out.println("<input type='hidden' name='semId' value='" + semId + "'/>");
        out.println("Course Code: <input type='text' name='courseCodeToRemove' required/><br>");
        out.println("<input type='submit' value='Remove Course'/>");
        out.println("</form>");
    }

    private void removeCourseFromDatabase(HttpServletRequest request, PrintWriter out, int semId) {

    String courseCodeToRemove = request.getParameter("courseCodeToRemove");

    try {
        // Establish database connection
        Class.forName("com.mysql.cj.jdbc.Driver");

        String tableName = getTableName(semId);

        // Prepare SQL statement to insert into the appropriate semester table
        String deleteQuery = "DELETE FROM " + tableName + " WHERE coursecode=?";
        
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhaarathi?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "leomessi10");
             PreparedStatement ps = con.prepareStatement(deleteQuery)) {

            // Set parameters
            ps.setString(1, courseCodeToRemove);

            // Execute the update
            int rowsAffected = ps.executeUpdate();

            if (rowsAffected > 0) {
                out.println("Course deleted successfully!");
            } else {
                out.println("Failed to delete the course.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("Error: " + e.getMessage());
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}


    private void displayCourseTable(PrintWriter out, int semId) {
    // Display the table with all the course details from the database
    out.println("<h2>Course Details</h2>");
    out.println("<table border='1'>");
    out.println("<tr><th>Course Code</th><th>Course Name</th><th>Credits</th></tr>");
    String tableName=getTableName(semId);
    // Modify the code below to fetch data from your database
    try {
        // Establish a database connection
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhaarathi?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "leomessi10");

        // Create and execute a SQL query to retrieve course details
        String sql = "SELECT coursecode, coursename, creds FROM "+tableName;
        try (PreparedStatement ps= connection.prepareStatement(sql)) {
            ResultSet resultSet = ps.executeQuery();

            // Iterate through the result set and display course details
            while (resultSet.next()) {
                out.println("<tr>");
                out.println("<td>" + resultSet.getString("coursecode") + "</td>");
                out.println("<td>" + resultSet.getString("coursename") + "</td>");
                out.println("<td>" + resultSet.getInt("creds") + "</td>");
                out.println("</tr>");
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
        out.println("Error: " + e.getMessage());
    }

    out.println("</table>");
}

    private String getTableName(int semId) {
        switch (semId) {
            case 101:
                return "semester1";
            case 102:
                return "semester2";
            case 103:
                return "semester3";
            case 104:
                return "semester4";
            case 105:
                return "semester5";
            case 106:
                return "semester6";
            case 107:
                return "semester7";
            case 108:
                return "semester8";
            default:
                return "unknownSemester";
        }
    }
}
   
    

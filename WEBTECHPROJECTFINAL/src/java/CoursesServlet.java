/*
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/CoursesServlet")
public class CoursesServlet extends HttpServlet {
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
        String semName = semName(semId);
        
        // Display the data
        out.println("<html><head><title>Courses</title></head><body>");
        out.println("<h2>Welcome to Courses Page!</h2>");
        out.println("<p> " + semName + "</p>");

        // Display buttons
        out.println("<form action='AddCourse' method='post'>");
        out.println("<input type='hidden' name='semId' value='" + semId + "'/>");
        out.println("<input type='submit' name='addCourseButton' id='addCourseButton' value='Add Course'/>");
        out.println("</form>");
        
        out.println("<form action='DeleteCourse' method='post'>");
        out.println("<input type='hidden' name='semId' value='" + semId + "'/>");
        out.println("<input type='submit' name='deleteCourseButton' id='deleteCourseButton' value='Delete Course'/>");
        out.println("</form>");
        
        out.println("<form action='EditCourse' method='post'>");
        out.println("<input type='hidden' name='semId' value='" + semId + "'/>");
        out.println("<input type='submit' name='editCourseButton' id='editCourseButton' value='Edit Course'/>");
        out.println("</form><br><br>");
        
        
        out.println("</body></html>");
        displayCourseTable(out, semId);
    }
    private String semName(int semId) {
        switch (semId) {
            case 101:
                return "Semester 1";
            case 102:
                return "Semester 2";
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
                return "Semester 8";
            default:
                return "Semester 1";
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
                return "semester1";
        }
    }

}*/
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/CoursesServlet")
public class CoursesServlet extends HttpServlet {
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
        String semName = semName(semId);

        // Display the data
        out.println("<html><head><title>Courses</title>");
        out.println("<style>");
        out.println("body {");
        out.println("    margin: 0;");
        out.println("    font-family: 'Arial', sans-serif;");
        out.println("    display: flex;");
        out.println("    align-items: center;");
        out.println("    justify-content: center;");
        out.println("    height: 100vh;");
        out.println("    background-color: #3498db;");
        out.println("    color: #000;");
        out.println("}");

        out.println(".container {");
        out.println("    text-align: center;");
        out.println("    padding: 30px;");
        out.println("    background-color: rgba(255, 255, 255, 0.9);");
        out.println("    box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);");
        out.println("    border-radius: 15px;");
        out.println("    width: 80%;");
        out.println("}");

        out.println(".header {");
        out.println("    font-size: 36px;");
        out.println("    margin-bottom: 20px;");
        out.println("    color: #1a237e;");
        out.println("}");

        out.println(".button-container {");
        out.println("    display: flex;");
        out.println("    justify-content: space-around;");  // Changed to horizontal placement
        out.println("    margin-bottom: 20px;");
        out.println("}");

        out.println(".button {");
        out.println("    background-color: #4CAF50;");
        out.println("    color: white;");
        out.println("    padding: 50px 80px;");  // Increased padding
        out.println("    margin: 10px;");  // Added margin
        out.println("    border: none;");
        out.println("    border-radius: 6px;");
        out.println("    cursor: pointer;");
        out.println("    font-weight: bold;");  // Added bold text
        out.println("    font-size: 24px;");  // Increased font size
        out.println("}");

        out.println(".button:hover {");
        out.println("    background-color: #45a049;");
        out.println("}");

        out.println(".course-table {");
        out.println("    width: 100%;");
        out.println("    margin-top: 20px;");
        out.println("}");

        out.println(".course-table th, .course-table td {");
        out.println("    border: 1px solid #ddd;");
        out.println("    padding: 15px;");
        out.println("    text-align: left;");
        out.println("}");

        out.println(".course-table th {");
        out.println("    background-color: #4CAF50;");
        out.println("    color: white;");
        out.println("}");


        // Existing styles

        out.println(".button {");
        out.println("    background-color: #4CAF50;");
        out.println("    color: white;");
        out.println("    padding: 50px 80px;");  // Increased padding
        out.println("    margin: 10px;");  // Added margin
        out.println("    border: none;");
        out.println("    border-radius: 6px;");
        out.println("    cursor: pointer;");
        out.println("    font-weight: bold;");  // Added bold text
        out.println("    font-size: 24px;");  // Increased font size
        out.println("    transition: transform 0.3s ease;"); // Added transition for smooth scaling
        out.println("}");

        out.println(".button:hover {");
        out.println("    background-color: #45a049;");
        out.println("    transform: scale(1.1);"); // Added scale transform
        out.println("}");



        out.println("</style>");
        out.println("</head><body>");

        out.println("<div class='container'>");
        out.println("<div class='header'>Welcome to Courses Page!</div><br>");

        // Display buttons
        out.println("<div class='button-container'>");
        out.println("<form action='AddCourse' method='post'><input type='hidden' name='semId' value='" + semId + "'/><input class='button' type='submit' name='addCourseButton' id='addCourseButton' value='Add Course'/></form>");
        out.println("<form action='DeleteCourse' method='post'><input type='hidden' name='semId' value='" + semId + "'/><input class='button' type='submit' name='deleteCourseButton' id='deleteCourseButton' value='Delete Course'/></form>");
        out.println("<form action='EditCourse' method='post'><input type='hidden' name='semId' value='" + semId + "'/><input class='button' type='submit' name='editCourseButton' id='editCourseButton' value='Edit Course'/></form>");
        out.println("</div>");

        displayCourseTable(out, semId);

        out.println("</div>");
        out.println("</body></html>");
    }

    private String semName(int semId) {
        switch (semId) {
            case 101:
                return "Semester 1";
            case 102:
                return "Semester 2";
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
                return "Semester 8";
            default:
                return "Semester 1";
        }
    }

    private void displayCourseTable(PrintWriter out, int semId) {
        // Display the table with all the course details from the database
        out.println("<h2>Course Details</h2>");
        out.println("<table class='course-table'>");
        out.println("<tr><th>Course Code</th><th>Course Name</th><th>Credits</th></tr>");
        String tableName = getTableName(semId);

        // Modify the code below to fetch data from your database
        try {
            // Establish a database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhaarathi?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "leomessi10");

            // Create and execute a SQL query to retrieve course details
            String sql = "SELECT coursecode, coursename, creds FROM " + tableName;
            try (PreparedStatement ps = connection.prepareStatement(sql)) {
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
                return "semester1";
        }
    }
}


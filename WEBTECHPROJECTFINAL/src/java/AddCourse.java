/*import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/AddCourse")
public class AddCourse extends HttpServlet {
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
        out.println("<h1>ADD COURSE</h1>");
        out.println("<p><h2>Semester: " + n+ "</h2></p>");
        // Display the form for adding a course
        displayAddCourseForm(out, semId);

        // Check if the form was submitted
        if ("addCourse".equals(request.getParameter("action"))) {
            // If the form was submitted, add the course to the database
            addCourseToDatabase(request, out, semId);
        }

        // Display the table with all the course details
        displayCourseTable(out, semId);
    }

    private void displayAddCourseForm(PrintWriter out, int semId) {
        // Display the form for adding a course
        out.println("<form action='' method='post'>");
        out.println("<input type='hidden' name='action' value='addCourse'/>");
        out.println("<input type='hidden' name='semId' value='" + semId + "'/>");
        out.println("Course Code: <input type='text' name='courseCode' required/><br>");
        out.println("Course Name: <input type='text' name='courseName' required/><br>");
        out.println("Credits: <input type='text' name='credits' required/><br>");
        out.println("<input type='submit' value='Add Course'/>");
        out.println("</form>");
    }

    private void addCourseToDatabase(HttpServletRequest request, PrintWriter out, int semId) {
        // Retrieve values from the form
        String courseCode = request.getParameter("courseCode");
        String courseName = request.getParameter("courseName");
        int credits = Integer.parseInt(request.getParameter("credits"));

        try {
            // Establish database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            String tableName=getTableName(semId);
            // Prepare SQL statement to insert into the appropriate semester table
            String insertQuery = "INSERT INTO " + tableName + "(coursecode,coursename,creds,semid) VALUES (?, ?, ?,?)";
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhaarathi?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "leomessi10");
                PreparedStatement ps = con.prepareStatement(insertQuery)) {
    // Set parameters
                ps.setString(1, courseCode);
                ps.setString(2, courseName);
                ps.setInt(3, credits);
                ps.setInt(4, semId);

    // Execute the update
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    out.println("Course added successfully!");
                } else {
                    out.println("Failed to add the course.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                out.println("Error: " + e.getMessage());
            }

           /*
            ps.close();
            con.close();
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
}

*/
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/AddCourse")
public class AddCourse extends HttpServlet {
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
        out.println("<html><head><title>Courses</title>");
        out.println("<style>");
        out.println("body {");
        out.println("    margin-top:30px;");
        out.println("    font-family: 'Arial', sans-serif;");
        out.println("    display: flex;");
        out.println("    align-items: center;");
        out.println("    justify-content: center;");
        out.println("    height: 100vh;");
        out.println("    background-color: #3498db;");
        out.println("    color: #000;");
        out.println("}");

        out.println(".container {");
        out.println("    display: flex;");
        out.println("    flex-direction: column;");
        out.println("    align-items: center;");
        out.println("    margin-top: 50px;");
        out.println("}");

        out.println(".header {");
        out.println("    font-size: 24px;");
        out.println("    margin-bottom: 20px;");
        out.println("}");

        out.println(".form-container {");
        out.println("    width: 600px;");  // Increased width
        out.println("    border: 1px solid #ccc;");
        out.println("    padding: 20px;");
        out.println("    border-radius: 8px;");
        out.println("    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);");
        out.println("    margin-bottom: 20px;");
        out.println("    margin-top: 20px;");
        out.println("    background-color: #fff;");
        out.println("}");
        
        out.println(".table-container {");
        out.println("    width: 800px;");  // Increased width
        out.println("    border: 1px solid #ccc;");
        out.println("    padding: 20px;");
        out.println("    border-radius: 8px;");
        out.println("    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);");
        out.println("    margin-bottom: 20px;");
        out.println("    margin-top: 20px;");
        out.println("    background-color: #fff;");
        out.println("}");

        out.println(".label {");
        out.println("    display: block;");
        out.println("    margin-bottom: 10px;");
        out.println("}");

        out.println(".input {");
        out.println("    width: 100%;");
        out.println("    padding: 8px;");
        out.println("    margin-bottom: 15px;");
        out.println("    border-radius: 4px;");
        out.println("    border: 1px solid #ccc;");
        out.println("}");

        out.println(".button {");
        out.println("    background-color: #4CAF50;");
        out.println("    color: white;");
        out.println("    padding: 10px;");
        out.println("    border: none;");
        out.println("    border-radius: 4px;");
        out.println("    cursor: pointer;");
        out.println("}");
        
        out.println("html {");
        out.println("    margin-top: 30px;");
        out.println("}");

        out.println(".button:hover {");
        out.println("    background-color: #45a049;");
        out.println("}");

        out.println(".course-table {");
        out.println("    width: 200%;");
        out.println("    background-color: #fff;");
        out.println("    margin-bottom: 20px;");
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

        out.println(".alert {");
        out.println("    padding: 20px;");
        out.println("    background-color: #f44336;");  // Red background color
        out.println("    color: white;");
        out.println("    border-radius: 8px;");
        out.println("    margin-bottom: 20px;");
        out.println("}");

        out.println("</style>");
        out.println("</head><body>");

        out.println("<div class='container'>");
        out.println("<div class='header'>Welcome to Courses Page!</div><br><br>");

        // Display form container
        out.println("<div class='form-container'>");
        out.println("<h2>Enter Course to Add</h2>");
       
        // Display the form for adding a course
        displayAddCourseForm(out, semId);
        out.println("</div>");

        // Check if the form was submitted
        if ("addCourse".equals(request.getParameter("action"))) {
            // If the form was submitted, add the course to the database
            addCourseToDatabase(request, out, semId);
        }

        // Display the table with all the course details
        displayCourseTable(out, semId);

        out.println("</div>");
        out.println("</body></html>");
    }

    private void displayAddCourseForm(PrintWriter out, int semId) {
        // Display the form for adding a course
        out.println("<form action='' method='post'>");
        out.println("<input type='hidden' name='action' value='addCourse'/>");
        out.println("<input type='hidden' name='semId' value='" + semId + "'/>");
        out.println("<label class='label'>Course Code: <input type='text' name='courseCode' class='input' required/></label>");
        out.println("<label class='label'>Course Name: <input type='text' name='courseName' class='input' required/></label>");
        out.println("<label class='label'>Credits: <input type='text' name='credits' class='input' required/></label>");
        out.println("<input type='submit' value='Add Course' class='button'/>");
        out.println("</form>");
    }

    private void addCourseToDatabase(HttpServletRequest request, PrintWriter out, int semId) {
        // Retrieve values from the form
        String courseCode = request.getParameter("courseCode");
        String courseName = request.getParameter("courseName");
        int credits = Integer.parseInt(request.getParameter("credits"));

        try {
            // Establish database connection
            Class.forName("com.mysql.cj.jdbc.Driver");

            String tableName = getTableName(semId);
            // Prepare SQL statement to insert into the appropriate semester table
            String insertQuery = "INSERT INTO " + tableName + "(coursecode,coursename,creds,semid) VALUES (?, ?, ?,?)";
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhaarathi?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "leomessi10");
                 PreparedStatement ps = con.prepareStatement(insertQuery)) {
                // Set parameters
                ps.setString(1, courseCode);
                ps.setString(2, courseName);
                ps.setInt(3, credits);
                ps.setInt(4, semId);

                // Execute the update
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    // Course added successfully
                    out.println("<div class='alert'>Course added successfully!</div>");
                } else {
                    // Failed to add the course
                    out.println("<div class='alert'>Failed to add the course.</div>");
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
        out.println("<div class='table-container'>");
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
        out.println("</div>");
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
                return "Semester 8";
            default:
                return "Semester 1";
        }
    }
}

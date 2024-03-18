import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/GpaCalculationServlet")
public class GpaCalculationServlet extends HttpServlet {
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

    // Retrieve semester ID from the request
    int semId = Integer.parseInt(request.getParameter("semId"));
    String tableName = getTableName(semId);

    // Retrieve data from the database
    try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhaarathi?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "leomessi10");
        String selectQuery = "SELECT coursecode, coursename, creds FROM " + tableName + " WHERE semid=?";
        try (PreparedStatement ps = con.prepareStatement(selectQuery)) {
            ps.setInt(1, semId);
            ResultSet rs = ps.executeQuery();

            // Display the table of courses with input fields for grades
            out.println("<html><head><title>GPACalculator</title></head><body>");
            out.println("<h2>GPACalculator Servlet</h2>");

            while (rs.next()) {
                String courseCode = rs.getString("coursecode");
                String courseName = rs.getString("coursename");
                int credits = rs.getInt("creds");

                out.println("<form action='' method='post'>");
                out.println("<input type='hidden' name='action' value='addGrade'/>");
                out.println("<input type='hidden' name='semId' value='" + semId + "'/>");
                out.println("<input type='hidden' name='courseCode' value='" + courseCode + "'/>");
                out.println("Course Code: " + courseCode + "<br>");
                out.println("Course Name: " + courseName + "<br>");
                out.println("Credits: " + credits + "<br>");
                out.println("<input type='text' name='grade' id='grade' value=''/>");
                out.println("<input type='submit' value='Add Grade'/>");
                out.println("</form>");
            }

            // Check if the form was submitted
            if ("addGrade".equals(request.getParameter("action"))) {
                // Retrieve the submitted grade and course code
                String grade = request.getParameter("grade");
                String courseCode = request.getParameter("courseCode");

                // Add the grade to the database
                addGrade(request, out, courseCode, semId, grade);
                
            }
            double gpa = calculateGPA(semId);
            addtocgpatable(semId,gpa);    // this table can be later used for cgpa calculation
            out.println("<p><strong>Calculated GPA:</strong> " + gpa + "</p>");
            
            out.println("</body></html>");
        }
    } catch (SQLException e) {
        e.printStackTrace();
        out.println("Error: " + e.getMessage());
    }
}
    private void addtocgpatable(int semId,double gpa) {
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            String updateQuery = "UPDATE cgpa SET gpa=? WHERE semid=?"; 

            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhaarathi?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "leomessi10");
                PreparedStatement ps = con.prepareStatement(updateQuery)) {
                ps.setInt(2, semId);
                ps.setDouble(1, gpa );
    // Execute the update
                int rowsAffected = ps.executeUpdate();
                
            } catch (SQLException e) {
                e.printStackTrace();
                
            }

           /*
            ps.close();
            con.close();*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    
    }

    
    private void addGrade(HttpServletRequest request, PrintWriter out, String courseCode, int semId,String grade) {
        
        try {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            String tableName=getTableName(semId);
            String updateQuery = "UPDATE " + tableName+ " SET grade=? WHERE coursecode=?"; 

            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhaarathi?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "leomessi10");
                PreparedStatement ps = con.prepareStatement(updateQuery)) {
                ps.setString(2, courseCode);
                ps.setString(1, grade );
    // Execute the update
                int rowsAffected = ps.executeUpdate();
                if (rowsAffected > 0) {
                    out.println("Grade added successfully!");
                } else {
                    out.println("Failed to add the grade.");
                }
            } catch (SQLException e) {
                e.printStackTrace();
                out.println("Error: " + e.getMessage());
            }

           /*
            ps.close();
            con.close();*/
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    private double calculateGPA(int semId) {
    double totalGradePoints = 0.0;
    int totalCredits = 0;

    try {
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhaarathi?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "leomessi10");
        String selectQuery = "SELECT grade, creds FROM " + getTableName(semId) + " WHERE semid=?";
        try (PreparedStatement ps = con.prepareStatement(selectQuery)) {
            ps.setInt(1, semId);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String grade = rs.getString("grade");
                int credits = rs.getInt("creds");

                if (grade != null && !grade.isEmpty()) {
                    // Map grade to grade points (adjust this mapping as needed)
                    double gradePoints = mapGradeToPoints(grade);

                    totalGradePoints += gradePoints * credits;
                    totalCredits += credits;
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // Calculate GPA
    if (totalCredits > 0) {
        return totalGradePoints / totalCredits;
    } else {
        return 0.0; // Avoid division by zero
    }
}

private double mapGradeToPoints(String grade) {
    // Add your mapping logic here
    switch (grade) {
        case "O":
            return 10.0;
        case "A+":
            return 9.0;
        case "A":
            return 8.0;
        case "B+":
            return 7.0;
        case "B":
            return 6.0;
        case "C":
            return 5.0;
        case "U":
            return 0.0;
        default:
            return 0.0; // Default to 0 for unknown grades
    }
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
   
    


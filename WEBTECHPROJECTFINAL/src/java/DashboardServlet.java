/*

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
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

        // Retrieve the forwarded data from the request
        int semId = (int) request.getAttribute("semId");
        String sn = semName(semId);

        // Display the data in another HTML page
        out.println("<html><head><title>Dashboard</title></head><body>");
        out.println("<h2>Welcome to the Dashboard</h2>");

        out.println("<p>Semester Name: " + sn + "</p>");

        // Display URLs for selecting different servlets
        out.println("<p>Choose an action:</p>");
        out.println("<ul>");
        out.println("<li><a href='CoursesServlet?semId=" + semId + "'>Courses</a></li>");
        out.println("<li><a href='TasksServlet?semId=" + semId + "'>Tasks</a></li>");
        out.println("<li><a href='GpaCalculationServlet?semId=" + semId + "'>GPA Calculation</a></li>");
        out.println("</ul>");

        out.println("</body></html>");
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

@WebServlet("/DashboardServlet")
public class DashboardServlet extends HttpServlet {
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

        // Retrieve the forwarded data from the request
        int semId = (int) request.getAttribute("semId");
        String semName = semName(semId);

        // Display the data in another HTML page
        out.println("<html><head><title>Dashboard</title>");
        out.println("<style>");
        out.println("body {");
        out.println("    margin: 0;");
        out.println("    font-family: 'Arial', sans-serif;");
        out.println("    display: flex;");
        out.println("    align-items: center;");
        out.println("    justify-content: center;");
        out.println("    height: 100vh;");
        out.println("    background: linear-gradient(to bottom, #1a237e, #000000);");
        out.println("    overflow: hidden;");
        out.println("    color: #000;");
        out.println("}");

        out.println(".container {");
        out.println("    text-align: center;");
        out.println("    padding: 30px;");
        out.println("    background-color: rgba(255, 255, 255, 0.9);");
        out.println("    box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);");
        out.println("    border-radius: 15px;");
        out.println("}");

        out.println(".header {");
        out.println("    font-size: 48px;"); // Increased font size
        out.println("    margin-bottom: 30px;");
        out.println("    color: #1a237e;");
        out.println("}");

        out.println(".box-container {");
        out.println("    display: flex;");
        out.println("    flex-wrap: wrap;");
        out.println("    justify-content: center;");
        out.println("    margin-top: 40px;"); // Increased margin
        out.println("}");

        out.println(".box {");
        out.println("    width: 300px;"); // Increased box width
        out.println("    height: 250px;"); // Increased box height
        out.println("    margin: 20px;");
        out.println("    display: flex;");
        out.println("    align-items: center;");
        out.println("    justify-content: center;");
        out.println("    background-color: #4CAF50;");
        out.println("    box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);");
        out.println("    border-radius: 25px;");
        out.println("    cursor: pointer;");
        out.println("    transition: transform 0.3s ease-in-out;");
        out.println("}");

        out.println(".box:hover {");
        out.println("    transform: scale(1.1);");
        out.println("}");

        out.println(".box a {");
        out.println("    text-decoration: none;");
        out.println("    color: #fff;");
        out.println("    font-size: 24px;"); // Increased font size
        out.println("}");

        out.println("</style>");
        out.println("</head><body>");

        out.println("<div class='container'>");
        out.println("<div class='header'>Welcome to the Dashboard</div>");
        out.println("<p style='color: #000; font-size: 36px;'>" + semName + "</p>"); // Increased font size

        // Display URLs as bigger, fancier boxes
        out.println("<div class='box-container'>");
        out.println("<div class='box' onclick=\"window.location.href='CoursesServlet?semId=" + semId + "'\"><a>Courses</a></div>");
        out.println("<div class='box' onclick=\"window.location.href='TasksServlet?semId=" + semId + "'\"><a>Tasks</a></div>");
        out.println("<div class='box' onclick=\"window.location.href='GpaCalculationServlet?semId=" + semId + "'\"><a>GPA Calculation</a></div>");
        out.println("</div>");

        out.println("</div></body></html>");
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
}

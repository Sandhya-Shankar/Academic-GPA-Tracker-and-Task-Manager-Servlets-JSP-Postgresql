import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;  // Import the @WebServlet annotation

@WebServlet("/SemesterServlet")
public class SemesterServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int id = Integer.parseInt(request.getParameter("semester"));

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhaarathi?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "leomessi10");
            String selectquery = "SELECT * FROM semesters WHERE semid=?";
            PreparedStatement ps = con.prepareStatement(selectquery);
            ps.setInt(1, id);
            ResultSet resultSet = ps.executeQuery();

            // Display the record details
            if (resultSet.next()) {
                // Forwarding the data to the "dashboard" servlet
                request.setAttribute("semId", resultSet.getInt("semid"));
                request.setAttribute("semName", resultSet.getString("sem_name"));

                // Forwarding the request and response to the "dashboard" servlet
                RequestDispatcher dispatcher = request.getRequestDispatcher("/DashboardServlet");
                dispatcher.forward(request, response);
                
                // Return after forwarding to prevent further processing
                return;
            } else {
                out.println("<p>No record found for ID: " + id + "</p>");
            }
        } catch (Exception e) {
            out.println(e);
        }
    }
}

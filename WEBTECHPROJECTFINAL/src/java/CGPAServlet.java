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

@WebServlet("/CGPAServlet")
public class CGPAServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        calculateAndDisplayCGPA(response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        calculateAndDisplayCGPA(response);
    }

    private void calculateAndDisplayCGPA(HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/bhaarathi?zeroDateTimeBehavior=CONVERT_TO_NULL", "root", "leomessi10")) {
            String sql = "SELECT AVG(gpa) AS cgpa FROM cgpa WHERE gpa IS NOT NULL";

            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                ResultSet resultSet = preparedStatement.executeQuery();

                if (resultSet.next()) {
                    double cgpa = resultSet.getDouble("cgpa");
                    out.println("<html><head><title>CGPA Display</title></head><body>");
                    out.println("<h2>Cumulative Grade Point Average (CGPA)</h2>");
                    out.println("<p>CGPA: " + cgpa + "</p>");
                    out.println("</body></html>");
                } else {
                    out.println("<html><head><title>CGPA Display</title></head><body>");
                    out.println("<h2>No data found in the cgpa table.</h2>");
                    out.println("</body></html>");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("<html><head><title>CGPA Display</title></head><body>");
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
            out.println("</body></html>");
        }
    }
}

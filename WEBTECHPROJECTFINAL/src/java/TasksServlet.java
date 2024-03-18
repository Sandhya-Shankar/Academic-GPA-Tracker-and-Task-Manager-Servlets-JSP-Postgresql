// TasksServlet
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TasksServlet")
public class TasksServlet extends HttpServlet {
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
        String tableName = getTableName(semId);
        // Display the data
        out.println("<html><head><title>Tasks</title></head><body>");
        out.println("<h2>Tasks Servlet</h2>");
        out.println("<p>Semester ID: " + semId + "</p>");
        
        out.println("<p><a href='addtask.jsp'>Add Task</a></p>");
        out.println("<p><a href='ViewTask.jsp'>View Task</a></p>");
        out.println("<p><a href='DeleteTaskServlet'>Delete Task</a></p>");


        out.println("</body></html>");
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

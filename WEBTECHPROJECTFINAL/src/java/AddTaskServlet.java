/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.annotation.WebServlet;

@WebServlet("/AddTaskServlet")
public class AddTaskServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AddTaskServlet() {
        // TODO Auto-generated constructor stub
    }


    
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	String title = request.getParameter("title");
    	String desc = request.getParameter("desc");
        String nod = request.getParameter("TargetDate");

    	HttpSession session = request.getSession();
    	Boolean status = false;
    	
    	Task task = new Task(title,desc,nod,status);
    	
    	TaskFunctions tf = new TaskFunctions();
    	
    	if (tf.task_add(task)) {
     	   response.sendRedirect("welcome.jsp");
     	} else {
     		PrintWriter out = response.getWriter();
     		out.println("Cannot create the task");
     	    }

    	
    }
    

}

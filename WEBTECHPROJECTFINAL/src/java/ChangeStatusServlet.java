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
import javax.servlet.annotation.WebServlet;


@WebServlet("/ChangeStatusServlet")
public class ChangeStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public ChangeStatusServlet() {
        // TODO Auto-generated constructor stub
    }

    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
    	int id = Integer.parseInt(request.getParameter("id"));
    	TaskFunctions tf = new TaskFunctions();
    	if(tf.ChangeStatusTask(id))
    	{
    		response.sendRedirect("ViewTask.jsp");
    	}
    	else
    	{
     		PrintWriter out = response.getWriter();
     		out.println("Cannot delete the task");
    	}

    	
    }

}

package reclaim_waste.com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ComplaintServlet
 */
@WebServlet("/complaint")
public class ComplaintServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		//PrintWriter out = response.getWriter();
		
		String coname = request.getParameter("name");
        String coemail = request.getParameter("email");
		String cophno = request.getParameter("phno");
        String compt = request.getParameter("complaint");
				
        RequestDispatcher rd=null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Wastedb", "root", "Akankshat25#");
			
			PreparedStatement ps = con.prepareStatement("insert into complainttb(coname,coemail,cophno,compt) values(?,?,?,?)");
			
			ps.setString(1, coname);
			ps.setString(2, coemail);
			ps.setString(3, cophno);
			ps.setString(4, compt);
			
			
			int count = ps.executeUpdate();
			if(count > 0)
			{
				//resp.setContentType("text/html");
				//out.print("<h3 style='color:green'>User registered successfully</h3>");
				
				request.setAttribute("status", "success");
				
				rd = request.getRequestDispatcher("/complaint.jsp");
				//rd.include(request, response);
			}
			else
			{
				//resp.setContentType("text/html");
				//out.print("<h3 style='color:green'>User not registered successfully because some error</h3>");
				request.setAttribute("status","failed");
				 rd = request.getRequestDispatcher("/complaint.jsp");
				//rd.include(request, response);
			}
			rd.forward(request,response);
		}
		catch(Exception e)
		{
			//e.fillInStackTrace();
			//response.setContentType("text/html");
			//out.print("<h3 style='color:red'>Exception occured : "+e.getMessage()+"</h3>");
			request.setAttribute("status","failed");
	         rd = request.getRequestDispatcher("/complaint.jsp");
			rd.include(request, response);
		}
		
	}
	
}
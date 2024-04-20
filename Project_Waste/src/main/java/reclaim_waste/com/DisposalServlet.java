package reclaim_waste.com;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;

@WebServlet("/Disposal")
public class DisposalServlet extends HttpServlet
{
	 
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,HttpServletResponse response)throws ServletException,IOException
	{
		//PrintWriter out = response.getWriter();
		
		String cname = request.getParameter("name");
        String cemail = request.getParameter("email");
		String cphno = request.getParameter("phno");
        String cadd = request.getParameter("add");
		String cpin= request.getParameter("pin");
		String wid = request.getParameter("mtype");
        String cquant = request.getParameter("quantity");
        String cpro = request.getParameter("process");
		
        RequestDispatcher rd=null;
		
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Wastedb", "root", "Akankshat25#");
			
			PreparedStatement ps = con.prepareStatement("insert into redisptb(cname,cemail,cphno,cadd,cpin,wid,cquant,cpro) values(?,?,?,?,?,?,?,?)");
			
			ps.setString(1, cname);
			ps.setString(2, cemail);
			ps.setString(3, cphno);
			ps.setString(4, cadd);
			ps.setString(5, cpin);
			ps.setString(6, wid);
			ps.setString(7, cquant);
			ps.setString(8, cpro);
			
			
			int count = ps.executeUpdate();
			if(count > 0)
			{
				//resp.setContentType("text/html");
				//out.print("<h3 style='color:green'>User registered successfully</h3>");
				
				request.setAttribute("status", "success");
				
				rd = request.getRequestDispatcher("/Disposal.jsp");
				//rd.include(request, response);
			}
			else
			{
				//resp.setContentType("text/html");
				//out.print("<h3 style='color:green'>User not registered successfully because some error</h3>");
				request.setAttribute("status","failed");
				 rd = request.getRequestDispatcher("/Disposal.jsp");
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
	         rd = request.getRequestDispatcher("/Disposal.jsp");
			rd.include(request, response);
		}
		
	}
	
}
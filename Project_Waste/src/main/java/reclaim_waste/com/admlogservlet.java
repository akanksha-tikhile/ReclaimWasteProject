package reclaim_waste.com;


import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class admlogservlet
 */
@WebServlet("/admlogservlet")
public class admlogservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wastedb","root","Akankshat25#");
			String adname=request.getParameter("username");
			String pass=request.getParameter("password");
			PreparedStatement ps =con.prepareStatement("select * from adminlog where adname=? and pass=? ");
			ps.setString(1, adname);
			ps.setString(2, pass);
			ResultSet rs=ps.executeQuery();
			RequestDispatcher rd=null;
			HttpSession session=request.getSession();
			if(rs.next())
			{
				session.setAttribute("name",rs.getString("adname"));
			  rd=request.getRequestDispatcher("adminDashboard.jsp");
				//rd.forward(request,response);
			}
			else
			{
				request.setAttribute("status","failed");
				rd =request.getRequestDispatcher("adminlogin.jsp");
				
			}
			rd.forward(request,response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
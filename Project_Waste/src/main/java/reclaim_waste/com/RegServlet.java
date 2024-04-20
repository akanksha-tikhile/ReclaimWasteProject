package reclaim_waste.com;

import java.io.IOException;
//import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegServlet
 */
@WebServlet("/register")
public class RegServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		
		//PrintWriter out = response.getWriter();
		RequestDispatcher dispatcher=null;
		
		String uname=request.getParameter("name");
		String uemail=request.getParameter("email");
		String upwd=request.getParameter("pass");
		String umobile=request.getParameter("contact");
		
		
		Connection con=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		     con=DriverManager.getConnection("jdbc:mysql://localhost:3306/wastedb","root","Akankshat25#");
			PreparedStatement pst=con.prepareStatement("INSERT into userlogintb(uname,uemail,upwd,umobile) values(?,?,?,?)");
			pst.setString(1, uname);
			pst.setString(2, uemail);
			pst.setString(3, upwd);
			pst.setString(4, umobile);
			
			
			int rowCount =pst.executeUpdate();
			//dispatcher=request.getRequestDispatcher("reg.jsp");
			if(rowCount>0) {
				
				request.setAttribute("status","success");
				dispatcher=request.getRequestDispatcher("/reg.jsp");
			}else {
				request.setAttribute("status","failed");
				dispatcher=request.getRequestDispatcher("/reg.jsp");
			}
			
			
			dispatcher.forward(request,response);
			
		}catch(Exception e) {
			//e.printStackTrace();
			e.fillInStackTrace();
			//response.setContentType("text/html");
			//out.print("<h3 style='color:red'>Exception occured : "+e.getMessage()+"</h3>");
			request.setAttribute("status","failed");
	         dispatcher = request.getRequestDispatcher("/reg.jsp");
			dispatcher.include(request, response);
		}finally {
			try {
			con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
			
	}	

}

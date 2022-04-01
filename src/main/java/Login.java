 
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sample.DatabaseConnection;


@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
HttpServletResponse response)
		throws ServletException, IOException
	{
		try {
			boolean status=false;
			
			HttpSession session=request.getSession();

			Connection con = DatabaseConnection.initializeDatabase();
			PreparedStatement st = con
				.prepareStatement("select * from details where username= ?  and pass = ? ");
			st.setString(1, request.getParameter("username"));
			st.setString(2, request.getParameter("pass"));
			
			 System.out.println(st);
	         ResultSet rs = st.executeQuery();
	         status = rs.next();
	            
			
			
			if(status) {
				
				session.setAttribute("username",request.getParameter("username"));
				response.sendRedirect("HomeServlet");
				
				PrintWriter out = response.getWriter();
				out.println("<html><body><b>Successfully Loggind"
						+ "</b></body></html>");
			}
			else {
				PrintWriter out = response.getWriter();
				out.println("<html><body><b>fuck off"
						+ "</b></body></html>");
			}
			
			st.close();
			con.close();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

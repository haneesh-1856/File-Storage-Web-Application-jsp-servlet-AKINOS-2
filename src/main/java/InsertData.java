 
 
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sample.DatabaseConnection;


@WebServlet("/InsertData")
public class InsertData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request,
HttpServletResponse response)
		throws ServletException, IOException
	{
		try {
			
			HttpSession session=request.getSession();

			Connection con = DatabaseConnection.initializeDatabase();
			PreparedStatement st = con
				.prepareStatement("insert into details values(?, ?, ?, ?)");
			st.setString(1, request.getParameter("username"));
			st.setString(2, request.getParameter("pass"));
			st.setString(3, request.getParameter("email"));
			st.setString(4, request.getParameter("fname"));
			st.executeUpdate();
			st.close();
			con.close();
			
			session.setAttribute("username",request.getParameter("username"));
			response.sendRedirect("HomeServlet");
			
			PrintWriter out = response.getWriter();
			out.println("<html><body><b>Successfully Inserted"
						+ "</b></body></html>");
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}
}

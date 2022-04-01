import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Iterator;
import java.util.List;

import org.apache.tomcat.util.http.fileupload.FileItem;
import org.apache.tomcat.util.http.fileupload.FileItemFactory;
import org.apache.tomcat.util.http.fileupload.disk.DiskFileItemFactory;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import org.apache.tomcat.util.http.fileupload.servlet.ServletRequestContext;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import sample.DatabaseConnection;

public class UploadServlet extends HttpServlet {
 private static final long serialVersionUID = 1 ;
 public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
 doPost(request, response);
 }
 public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
	 
	
	 
	 String file_name = null;
	 response.setContentType("text/html");
	 PrintWriter out = response.getWriter();
	 boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
	 if (!isMultipartContent) {
		 return;
	 }
	 FileItemFactory factory = new DiskFileItemFactory();
	 ServletFileUpload upload = new ServletFileUpload(factory);
	 try {
	 
		 List<FileItem> fields= new ServletFileUpload(new DiskFileItemFactory()).parseRequest(new ServletRequestContext(request));
		 
	 
	// List < FileItem > fields = upload.parseRequest(request);
		 Iterator < FileItem > it = fields.iterator();
		 if (!it.hasNext()) {
			 return;
		 }
		 while (it.hasNext()) {
			 FileItem fileItem = it.next();
			 String n= (new File(fileItem.getName())).getName();
			 
			 
			 
			 
			 boolean isFormField = fileItem.isFormField();
			 if (isFormField) {
				 if (file_name == null) {
					 if (fileItem.getFieldName().equals("file_name")) {
						 file_name = fileItem.getString();
					 }
				 }
			 } else {
				 if (fileItem.getSize() > 0) {
					 fileItem.write(new File("D:\\uploaded_files\\" + fileItem.getName()));
					 
					 String name=(new File(fileItem.getName())).getName();
					 
					 HttpSession session=request.getSession();	
					 String username=session.getAttribute("username").toString();
					 
					 Connection con = DatabaseConnection.initializeDatabase();
						PreparedStatement st = con
							.prepareStatement("insert into datas values(?, ?)");
						st.setString(1, username);
						st.setString(2, name);
						st.executeUpdate();
						st.close();
						con.close();
					 
					 
					
					System.out.println(username + "      "+name); 
				 }
			 }
		 }
	 } catch (Exception e) {
		 e.printStackTrace();
	 } finally {
		 out.println("<script type='text/javascript'>");
		 out.println("window.location.href='HomeServlet?filename="+file_name+"'");
		 out.println("</script>");
		 out.close();
	 }
 }
}
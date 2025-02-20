package servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Loginform
 */
@WebServlet("/Loginform")
public class Loginform extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		response.setContentType("text/html");
		PrintWriter pwriter = response.getWriter();
		pwriter.println("<html><body>");
		pwriter.println("<form action='Validation' method='post'> ");
		pwriter.println(" User Name:<input type='text' name='uname'/><br/> ");
		pwriter.println(" Password:<input type='password' name='upass'/><br/> ");
		pwriter.println(" <input type='submit' value='SUBMIT'/> ");
		pwriter.println("</form>");
		pwriter.println("</body></html>");

	}

}

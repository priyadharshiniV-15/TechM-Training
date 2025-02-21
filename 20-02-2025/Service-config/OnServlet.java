package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OnServletContext
 */
@WebServlet("/OnServlet")
public class OnServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
        protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	        doPost(req,res);
	}
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		PrintWriter pw = res.getWriter();
		res.setContentType("text/html");

		// Getting context parameters
		ServletContext context = getServletContext();

		String s1 = context.getInitParameter("n1"); // Should be defined in web.xml
		String s2 = context.getInitParameter("n2"); // Should be defined in web.xml

		pw.println("n1 value is " + s1 + " and n2 is " + s2);
		pw.close(); // ✅ Removed invisible characters
	}
}

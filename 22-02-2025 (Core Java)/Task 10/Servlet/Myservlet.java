import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyServlet")
public class MyServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("text/html");
        
        String filePath = getServletContext().getRealPath("/index.html");
        
        File file = new File(filePath);
        if (!file.exists()) {
            response.getWriter().println("<h3>File not found!</h3>");
            return;
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            PrintWriter out = response.getWriter();
            while ((line = reader.readLine()) != null) {
                out.println(line);
            }
        }
    }
}

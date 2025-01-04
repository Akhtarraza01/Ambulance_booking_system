import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class AmbulanceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Ambulance Booking System</h1>");
        out.println("<form action='booking' method='post'>");
        out.println("Ambulance Type: <input type='text' name='ambulanceType'><br>");
        out.println("Location: <input type='text' name='location'><br>");
        out.println("<input type='submit' value='Book Ambulance'>");
        out.println("</form>");
        out.println("</body></html>");
    }
}

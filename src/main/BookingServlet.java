import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class BookingServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String ambulanceType = request.getParameter("ambulanceType");
        String location = request.getParameter("location");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Booking Details</h1>");
        out.println("<p>Ambulance Type: " + ambulanceType + "</p>");
        out.println("<p>Location: " + location + "</p>");
        out.println("<form action='payment' method='post'>");
        out.println("Payment Amount: <input type='text' name='amount'><br>");
        out.println("<input type='submit' value='Proceed to Payment'>");
        out.println("</form>");
        out.println("</body></html>");
    }
}

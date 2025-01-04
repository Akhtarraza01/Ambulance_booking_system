import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class PaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String amount = request.getParameter("amount");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Payment Confirmation</h1>");
        out.println("<p>Payment of $" + amount + " has been processed successfully.</p>");
        out.println("<p>Thank you for using our Ambulance Booking System.</p>");
        out.println("</body></html>");
    }
}

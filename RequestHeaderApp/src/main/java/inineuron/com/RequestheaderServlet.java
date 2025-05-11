package inineuron.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestHeaderServlet
 */
@WebServlet("/test") // Mapping the servlet to /test
public class RequestheaderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Set the response content type to HTML
        response.setContentType("text/html");

        // Get the PrintWriter to write the response
        PrintWriter out = response.getWriter();

        // Start writing HTML content
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Request Header Information</title>");
        out.println("<style>");
        out.println("table { width: 50%; border-collapse: collapse; margin: 20px auto; }");
        out.println("th, td { border: 1px solid black; padding: 8px; text-align: left; }");
        out.println("th { background-color: #f2f2f2; }");
        out.println("h1 { color: red; text-align: center; }");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<center>");
        out.println("<h1>Request Header Information</h1>");
        out.println("<table>");
        out.println("<tr><th>Header Name</th><th>Header Value</th></tr>");

        // Retrieve all header names
        Enumeration<String> headerNames = request.getHeaderNames();

        // Loop through the headers and display them
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
            String headerValue = request.getHeader(headerName);

            out.println("<tr>");
            out.println("<td>" + headerName + "</td>");
            out.println("<td>" + headerValue + "</td>");
            out.println("</tr>");
        }

        // End the HTML table and close the body
        out.println("</table>");
        out.println("</center>");
        out.println("</body>");
        out.println("</html>");

        // Close the PrintWriter
        out.close();
    }
}

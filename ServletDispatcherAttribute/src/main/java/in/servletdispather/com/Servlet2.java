package in.servletdispather.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Let's print attributes</h1>");
        Enumeration<String> enuRequest = request.getAttributeNames();
        while (enuRequest.hasMoreElements()) {
            String name = enuRequest.nextElement();
            Object value = request.getAttribute(name);
            out.println("<p>" + name + ": " + value + "</p>");
        }
    }
}

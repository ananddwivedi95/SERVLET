package in.dispatcher.com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet1
 */
@WebServlet("/valid")
public class Servlet1 extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
   
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        
        // Debugging output
        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
        
        // Validate credentials
        if (username.equals("anand") && password.equals("password")) {
            // Forward to home.jsp if valid
            RequestDispatcher reqDis = request.getRequestDispatcher("/home.jsp");
            reqDis.forward(request, response);
        } else {
            // Forward to error.jsp if invalid
            ServletContext servletCont = request.getServletContext();
            RequestDispatcher reqDis = servletCont.getRequestDispatcher("/error.jsp");
            reqDis.forward(request, response);
        }
    }
    
   
}

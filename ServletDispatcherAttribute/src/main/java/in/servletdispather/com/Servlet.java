package in.servletdispather.com;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/test")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		request.setAttribute("anand", "password");
		request.setAttribute("raj","java");
		request.setAttribute("anshu", "anand");
		RequestDispatcher reqDis=request.getRequestDispatcher("/Servlet2");
		reqDis.forward(request, response);
		
		
		
	}	
}

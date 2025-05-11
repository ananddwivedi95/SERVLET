package in.servletdispatcher.com;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletDispatcher
 */
@WebServlet("/test")
public class ServletDispatcher extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		System.out.println("running Servlet1....");
		pw.println("<h1> welcome in servlet 1</h1>");
		RequestDispatcher reqDis=request.getRequestDispatcher("/SecondServlet");
		reqDis.forward(request, response);
		
	}

}

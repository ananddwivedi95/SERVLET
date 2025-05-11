package in.ineuron.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RequestResponce
 */
@WebServlet("/test")
public class RequestResponce extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		  PrintWriter out=response.getWriter();
		  LocalDateTime ldt= LocalDateTime.now();
		  int hour=ldt.getHour();
		  System.out.println(hour);
		  String msg="";
		  if(hour<12)
		  {
			  msg+="Good Morning";
		  }
		  else if(hour<16)
		  {
			  msg+="Good Afternoon";
		  }
		  else if(hour<20)
		  {
			  msg+="Good Evning";
		  }
		  else 
		  {
			  msg+="Good Night";
		  }
		  // Concatenate the message and time on the same line
	        out.println("<span style='color:red;'>WELCOME TO SERVLET CODING.... </span>");
	        out.println("<span style='color:red;'>GREETING FROM THE SERVLET.... </span>");
	        out.println("<span style='color:green;'>" + msg + "</span>");
	        
	        // Add the current time after the greeting message
	        out.println("<span style='color:blue;'> CURRENT TIME: " + ldt + "</span>");
	        
	        out.println("</body></html>");

		  out.close();		  
	}

}

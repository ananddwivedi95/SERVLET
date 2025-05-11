package in.ineuron.com;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ResponceInfoApp
 */
@WebServlet("/test")
public class ResponceInfoApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 response.setContentType("image/png");
	 File file= new File("C:\\Users\\anand\\eclipse-workspace\\ResponseInfoApp\\Anand.png.png");
	 FileInputStream fis =	new FileInputStream(file);
	 byte b[]=new byte[(int)file.length()];
	 fis.read(b);
	 ServletOutputStream stream=response.getOutputStream();
	 stream.write(b);
	 
	 stream.flush();
	 stream.close();
	 
	}

}

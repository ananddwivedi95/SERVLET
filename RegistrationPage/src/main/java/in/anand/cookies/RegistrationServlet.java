package in.anand.cookies;



import java.io.IOException;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegisterServlet")
public class RegistrationServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        try {
            Connection conn = DatabaseConnection.initializeDatabase();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO users(name, password, email) VALUES (?, ?, ?)");
            stmt.setString(1, name);
            stmt.setString(2, password);
            stmt.setString(3, email);
            
            int rowsInserted = stmt.executeUpdate();
            conn.close();

            if (rowsInserted > 0) {
                Cookie nameCookie = new Cookie("userName", name);
                response.addCookie(nameCookie);
                response.sendRedirect("success.html");
            } else {
                response.sendRedirect("warning.html");
            }
        } 
        catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("warning.html");
        }
    }
}

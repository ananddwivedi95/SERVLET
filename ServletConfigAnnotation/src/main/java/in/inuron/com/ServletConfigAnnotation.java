package in.inuron.com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
	    urlPatterns = "/test",
	    initParams = {
	        @WebInitParam(name = "url", value = "jdbc:mysql://decbatch"),
	        @WebInitParam(name = "user", value = "root"),
	        @WebInitParam(name = "password", value = "root")
	    }
	)
	public class ServletConfigAnnotation extends HttpServlet {
	    private static final long serialVersionUID = 1L;

	    @Override
	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String jdbcUrl = getServletConfig().getInitParameter("url");
	        String jdbcUser = getServletConfig().getInitParameter("user");
	        String jdbcPassword = getServletConfig().getInitParameter("password");

	        String username = request.getParameter("username");
	        String age = request.getParameter("age");

	        try (Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword)) {
	            String sql = "UPDATE users SET age = ? WHERE username = ?";
	            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
	                preparedStatement.setInt(1, Integer.parseInt(age));
	                preparedStatement.setString(2, username);

	                int rowsUpdated = preparedStatement.executeUpdate();
	                response.setContentType("text/html");
	                PrintWriter out = response.getWriter();
	                if (rowsUpdated > 0) {
	                    out.println("<h1 style='color: green;'>User updated successfully!</h1>");
	                } else {
	                    out.println("<h1 style='color: red;'>User not found!</h1>");
	                }
	            }
	        } catch (SQLException e) {
	            throw new ServletException("Database error!", e);
	        }
	    }

	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        out.println("<html><body>");
	        out.println("<h1 style='color: red;'>GET method is not supported for updating users. Please use POST.</h1>");
	        out.println("<p><a href='/yourFormPage.html'>Go back to the form</a></p>");
	        out.println("</body></html>");
	    }

	}

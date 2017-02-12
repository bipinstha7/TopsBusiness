package np.com.sthabipin.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LogoutAdmin
 */
@WebServlet("/LogoutAdmin")
public class LogoutAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Logout Admin</title>");
		out.println("<link rel='stylesheet' href='bootstrap/bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("navigation.html").include(request, response);
		
		out.println("<div class='container-fluid'");
		out.println("<h1>You are successfully logged out</h1>");
		request.getSession().invalidate();
		out.println("</div");
		
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}

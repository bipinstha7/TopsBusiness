package np.com.sthabipin.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/AdminHome")
public class AdminHome extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Product</title>");
		out.println("<link rel='stylesheet' href='bootstrap/bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("navigation.html").include(request, response);
		
		
		
//		request.getRequestDispatcher("header.html").include(request, response);
		out.println("<div class='container-fluid'>");
		out.println("<h1>Admin Home</h1>");
		out.print(" <a href='AddProduct' class='btn btn-primary' role='button'>Add Product</a>");
		out.print(" <a href='ViewProduct' class='btn btn-primary' role='button'>View Product</a>");
		out.print(" <a href='LogoutAdmin' class='btn btn-primary' role='button'>Logout</a>");
				
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
	}
	
}
package np.com.sthabipin.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import np.com.sthabipin.dao.ProductsDao;
import np.com.sthabipin.dto.ProductsDto;

/**
 * Servlet implementation class ViewProduct
 */
@WebServlet("/ViewProduct")
public class ViewProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View Product</title>");
		out.println("<link rel='stylesheet' href='bootstrap/bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		
		request.getRequestDispatcher("navigation.html").include(request, response);
		out.println("<div class='container-fluid'>");
		out.println("<a href='ViewProductByType?category=beans' class='btn btn-primary' role='button'>Beans</a>");
		out.println("<a href='ViewProductByType?category=vegetables' class='btn btn-primary' role='button'>Vegetables</a>");
		out.println("<a href='ViewProductByType?category=fruits' class='btn btn-primary' role='button'>Fruits</a>");
		out.println("<a href='ViewProductByType?category=junkfoods' class='btn btn-primary' role='button'>Junk Foods</a>");
		out.println("<a href='ViewProductByType?category=otherstuffs' class='btn btn-primary' role='button'>Other Stuffs</a>");
		out.println("<a href='ViewProductByType?category=clothes' class='btn btn-primary' role='button'>Clothes</a>");
		out.println("<a href='ViewProductByType?category=electronics' class='btn btn-primary' role='button'>Electronics</a>");
//		out.println("<br>");
//		-getSession(true) will check whether a session already exists for the user. If yes, 
//		it will return that session object else it will create a new session object and return it.
//		-getSession(false) will check existence of session. If session exists, 
//		then it returns the reference of that session object, if not, this methods will return null.
		
		HttpSession session = request.getSession(false);
		if(session==null || session.getAttribute("adminlogin")==null) {
//			request.getAttribute function will be availabe to the servlet till it get response from the server .
//			thus its  life cycle will exist till the one who call the this function get response.
//			on the other hand session.getAttribute function will be available to the servlet till the user get logout.
//			When the user get login from that moment the session of the user get started and througout his
//			login period session, getAttribute will work.
		}else {
			out.println("<a href='AddProductForm' class='btn btn-primary' role='button'>Add Product</a>");
			out.println("<a href='LogoutAdmin' class='btn btn-primary' role='button'>Logout</a>");
		}
		
		request.getRequestDispatcher("a2z.html").include(request, response);
		 out.println("<h1>View Products</h1>");
		 List<ProductsDto> list = ProductsDao.getAllRecords();
		 out.print("<table class='table table-bordered table-hover'>");
//		 The .table-bordered class adds borders on all sides of the table and cells:
//		 The .table-hover class adds a hover effect (grey background color) on table rows:
		 out.println("<tr><th>Id</th><th>Name</th><th>Brand</th><th>Weight(Kg)</th><th>Price(Rs)</th><th>Category</th><th>Delete</th></tr>");
		 for(ProductsDto productsdto:list) {
			 out.println("<tr><td>"+productsdto.getId()+"</td><td>"+productsdto.getName()+"</td><td>"
					 			   +productsdto.getBrand()+"</td><td>"+productsdto.getWeight()+"</td><td>"
					 			   +productsdto.getPrice()+"</td><td>"+productsdto.getCategory()+"</td>");
			 
			 if(session==null || session.getAttribute("adminlogin")==null) {
				 out.println("<td>Delete</td>");
			 }else {
				 out.println("<td><a href='DeleteProduct?id="+productsdto.getId()+"'>Delete</a></td>");
			 }
			 out.println("</tr>");
		 }
		 out.println("</table>");
		 out.println("</div>");
		 request.getRequestDispatcher("footer.html").include(request, response);
		 out.close();
	}

}

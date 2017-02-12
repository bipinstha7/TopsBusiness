package np.com.sthabipin.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import np.com.sthabipin.dao.ProductsDao;
import np.com.sthabipin.dto.ProductsDto;

/**
 * Servlet implementation class ViewProductByType
 */
@WebServlet("/ViewProductByType")
public class ViewProductByType extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String category = request.getParameter("category");
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>View by "+category.toUpperCase()+"</title>");
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
		
		out.println("<h1>View Product by "+category.toUpperCase()+"</h1>");
		List<ProductsDto> list = ProductsDao.getRecordsByType(category);
		
		out.println("<table class='table table-bordered table-hover'>");
		out.println("<tr><th>Id</th><th>Name</th><th>Brand</th><th>Weight(Kg)</th><th>Price(Rs)</th><th>Category</th></tr>");
		for(ProductsDto productsdto: list) {
			out.println("<tr><td>"+productsdto.getId()+"</td><td>"+productsdto.getName()+"</td><td>"+productsdto.getBrand()+"</td><td>"+productsdto.getWeight()+"</td><td>"+productsdto.getPrice()+"</td><td>"+productsdto.getCategory()+"</td></tr>");
		}
		out.println("</table>");
		out.println("</div");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
		
	}

}

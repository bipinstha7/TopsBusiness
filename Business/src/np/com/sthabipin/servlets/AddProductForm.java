package np.com.sthabipin.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import np.com.sthabipin.dao.ProductsDao;
import np.com.sthabipin.dto.ProductsDto;

/**
 * Servlet implementation class AddProductForm
 */
@WebServlet("/AddProductForm")
public class AddProductForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<title>Add Product</title>");
		out.println("<link rel='stylesheet' href='bootstrap/bootstrap.min.css'/>");
		out.println("</head>");
		out.println("<body>");
		request.getRequestDispatcher("navigation.html").include(request, response);
		out.println("<div class='container-fluid'>");
		out.print(" <a href='ViewProduct' class='btn btn-primary' role='button'>View Product</a> ");
		out.print(" <a href='LogoutAdmin' class='btn btn-primary' role='button'>Logout</a> ");
		
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String brand=request.getParameter("brand");
		String category=request.getParameter("category");
		Double weight=Double.parseDouble(request.getParameter("weight"));
		Double price=Double.parseDouble(request.getParameter("price"));
		
		ProductsDto productsdto = new ProductsDto();
		productsdto.setId(id);
		productsdto.setName(name);
		productsdto.setBrand(brand);
		productsdto.setCategory(category);
		productsdto.setWeight(weight);
		productsdto.setPrice(price);
		
		int status = ProductsDao.save(productsdto);
		if(status > 0) {
			out.println("<h3>Product Added Successfully</h3>");
			request.getRequestDispatcher("AddProductForm.html").include(request, response);
			
		}else {
			out.println("Unable to add product");
		}
		out.println("</div>");
		request.getRequestDispatcher("footer.html").include(request, response);
		out.close();
	}

}

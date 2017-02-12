package np.com.sthabipin.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class User
 */
@WebServlet("/User")
public class User extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
HttpSession session = request.getSession(false);
		
		if(session==null || session.getAttribute("userlogin")==null) {
			request.getRequestDispatcher("userloginform.html").include(request,response);
		}else {
			request.getRequestDispatcher("Images.html").forward(request,response);
		}
	}

}

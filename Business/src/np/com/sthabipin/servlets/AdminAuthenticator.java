package np.com.sthabipin.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminAuthenticator
 */
@WebServlet("/AdminAuthenticator")
public class AdminAuthenticator extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
//		System.out.println("zxcxzvczxvx" +name);
		if(name.equals("admin") && password.equals("ncit")) {
			HttpSession session = request.getSession();
			session.setAttribute("adminlogin", "true");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/AdminHome");
			dispatcher.forward(request, response);
			
		}else {
			request.getRequestDispatcher("/adminloginform.html").forward(request, response);
		}
		
	
	}

	

}

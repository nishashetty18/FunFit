package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
@WebServlet({ "/loginServlet", "/login" })
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		
		if ("admin".equals(username) && "admin@123".equals(password)) {
            // Redirect to a success page if login is successful
			request.getSession().setAttribute("username", username);            
			response.sendRedirect("welcome.jsp");
        } else {
            // Set error message and forward back to the login page
        	if(username.isEmpty() || password.isEmpty())
            request.setAttribute("errorMsg", "Please enter username or password");
        	
        	else
        		 request.setAttribute("errorMsg", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
	}

			
		
//		if(username.equals("admin")&& password.equals("admin@123")) {
//			HttpSession session=request.getSession();
//			session.setAttribute("username", username);
//			response.sendRedirect("welcome.jsp");
//		}
//		else 
//		{
//			
//			PrintWriter out=response.getWriter();
//			response.setContentType("txt/html");
//			String htmlResponse="Please enter correct username/password";
//			out.println(htmlResponse);
//			response.sendRedirect("login.jsp");
//		}
//	
//	}



	}



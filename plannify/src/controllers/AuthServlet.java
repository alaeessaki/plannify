package controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.User;
import models.UserDAO;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/login")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AuthServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String errorLogin = "Authentication error, check your email or password";
		
		HttpSession session = request.getSession();
		session.invalidate(); 
		request.setAttribute("error", errorLogin);
		request.getRequestDispatcher("login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			UserDAO udao = new UserDAO();		
			User login = udao.getUser(email, password);
			
			if(login != null) {
				HttpSession session = request.getSession();
				session.setAttribute("SessionUser", login);
				
				response.sendRedirect("projects");
			
			}else {
				doGet(request, response);
				
			}			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

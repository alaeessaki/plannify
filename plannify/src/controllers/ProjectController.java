package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Project;
import beans.User;
import models.ProjectDAO;
import models.UserDAO;

/**
 * Servlet implementation class ProjectController
 */
@WebServlet("/projects")
public class ProjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProjectDAO projectDAO = new ProjectDAO();
		ArrayList<Project> projects = new ArrayList<Project>();
		projects = projectDAO.getAllProjects();
		
		HttpSession session = request.getSession();
		if(session != null) {
			User loggeduser = (User)session.getAttribute("SessionUser");
			request.setAttribute("projects", projects);
			request.setAttribute("user", loggeduser);
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
			
		}else {
			response.sendRedirect("login.jsp");
		}
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

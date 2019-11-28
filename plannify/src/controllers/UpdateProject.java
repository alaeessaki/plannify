package controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.fabric.xmlrpc.base.Array;

import beans.Categorie;
import beans.Project;
import beans.Team;
import models.CategorieDAO;
import models.ProjectDAO;
import models.TeamDAO;

/**
 * Servlet implementation class UpdateProject
 */
@WebServlet("/UpdateProject")
public class UpdateProject extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateProject() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		
		ProjectDAO projectDAO = new ProjectDAO();
		TeamDAO teamDAO = new TeamDAO();
		CategorieDAO categorieDAO = new CategorieDAO();
		
		ArrayList<Team> teams = new ArrayList<Team>();
		ArrayList<Categorie> categories = new ArrayList<Categorie>();
		
		Project project = projectDAO.getProject(id);
		teams = teamDAO.getAll();
		categories = categorieDAO.getAll();
		
		request.setAttribute("project", project);
		request.setAttribute("teams", teams);
		request.setAttribute("categories", categories);


		this.getServletContext().getRequestDispatcher("/update-project.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String nom = request.getParameter("nom");
		String description = request.getParameter("description");		
		int team_id = Integer.parseInt(request.getParameter("team"));
		int categorie_id = Integer.parseInt(request.getParameter("categorie"));
		
		System.out.println("team id :" + team_id + " categorie id :" + categorie_id);

		CategorieDAO categorieDAO = new CategorieDAO();
		TeamDAO teamDAO = new TeamDAO();
		
		Categorie categorie = categorieDAO.getCategorie(categorie_id);
		Team team = teamDAO.getTeam(team_id);
		
		Project project = new Project(id, nom, description, team, categorie);
		ProjectDAO projectDAO = new ProjectDAO();
		projectDAO.updateProject(project);
		response.sendRedirect("projects");
	}	

}

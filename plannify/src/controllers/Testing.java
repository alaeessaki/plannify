package controllers;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.*;


import models.*;


/**
 * Servlet implementation class Testing
 */
@WebServlet("/Testing")
public class Testing extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Testing() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ArrayList<Team> teams = new ArrayList<Team>();
		ArrayList<Project> projects = new ArrayList<Project>();
		ArrayList<User> users = new ArrayList<User>();
		
		TeamDAO tdao = new TeamDAO();
		RoleDAO rdao = new RoleDAO();
		EntrepriseDAO edao = new EntrepriseDAO();
		ProjectDAO pdao = new ProjectDAO();
		UserDAO udao = new UserDAO();
		CategorieDAO cdao = new CategorieDAO();
	
		Date testd1 = null;
		
		teams = tdao.getAll();
		projects = pdao.getAllProjects();
		users = udao.getAll();
		Project pr1 = new Project("devops", "testing the prDAO", testd1 , tdao.getTeam(1), cdao.getCategorie(1));
		
		pdao.addProject(pr1);
		
		System.out.println(pdao.getProject("projet1"));
		
		System.out.println("**********************");
		
		for(int i = 0; i < users.size(); i++) {
			System.out.println(users.get(i));
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

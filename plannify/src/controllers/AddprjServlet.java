package controllers;

import java.io.IOException;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.fabric.xmlrpc.base.Data;

import beans.Categorie;
import beans.Project;
import beans.Team;
import models.CategorieDAO;
import models.ProjectDAO;
import models.TeamDAO;

/**
 * Servlet implementation class AddprjServlet
 */
@WebServlet("/AddprjServlet")
public class AddprjServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddprjServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session=request.getSession();
		Instant instant = Instant.now();
		int id = Integer.parseInt(request.getParameter("id"));
		ProjectDAO pjDao=new ProjectDAO();
		TeamDAO teamDAO = new TeamDAO();
		CategorieDAO categorieDAO = new CategorieDAO();
		String nom=request.getParameter("name_project");
		String desc=request.getParameter("description");
		Team teams = teamDAO.getTeam(id);
		Categorie category=categorieDAO.getCategorie(id);
		Project pj=new Project(nom, desc, Date.from(instant),teams ,category );
		pjDao.addProject(pj);	
        session.setAttribute("Nom", nom);
		session.setAttribute("Desc", desc);
		this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

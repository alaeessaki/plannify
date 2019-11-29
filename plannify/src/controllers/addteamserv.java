package controllers;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.Project;
import models.EntrepriseDAO;
import models.ProjectDAO;
import models.TeamDAO;



/**
 * Servlet implementation class Test
 */
@WebServlet("/addteam")
public class addteamserv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addteamserv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String team = request.getParameter("name");
		TeamDAO tdao = new TeamDAO();
		EntrepriseDAO edao = new EntrepriseDAO();
		
		try {
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}

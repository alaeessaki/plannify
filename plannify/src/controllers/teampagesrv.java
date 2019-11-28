package controllers;

import beans.*;
import models.*;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class teampagesrv
 */
@WebServlet("/teampagesrv")
public class teampagesrv extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public teampagesrv() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		TeamDAO tdao = new TeamDAO();
		ArrayList<Team> teamList = tdao.getAll();
		ArrayList<Integer> memberNum = new ArrayList<Integer>();
		
		for(int i=0;i<teamList.size();i++) {
			ArrayList<User> memberList = tdao.getTeamMembers(teamList.get(i));
			memberNum.add(memberList.size());
		}
		
		
		HttpSession s = request.getSession();
		s.setAttribute("teams", teamList);
		s.setAttribute("memberNum", memberNum);

		response.sendRedirect("team.jsp");
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}

package models;

import beans.*;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class ProjectDAO {
	
	//get all projects
	public ArrayList<Project> getAllProjects(){
		
		ArrayList<Project> projects = new ArrayList<Project>();
		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;
		TeamDAO teamdao = new TeamDAO();			
		CategorieDAO categoriedao = new CategorieDAO();
		
		try {
			con = Database.getConx();
			stm = con.createStatement();
			rs = stm.executeQuery("SELECT * FROM projets");
			
			while(rs.next()) {
				int id = rs.getInt("projet_id");
				String nom = rs.getString("nom");
				String description = rs.getString("description");
				Date created_at = rs.getDate("created_at");			
				int team_id = rs.getInt("team_id");
				int categorie_id = rs.getInt("categorie_id");
				
				Team team = teamdao.getTeam(team_id);
				Categorie categorie = categoriedao.getCategorie(categorie_id);	
				
				Project project = new Project(id, nom, description, created_at, team, categorie);
				projects.add(project);
			}
			
			return projects;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return null;
		
	}
	
	// get a project by id/name ...
	
	public Project getProject(int id){
        Connection con = Database.getConx();
        Project project = null;
        try{
            String query = "SELECT * FROM projets WHERE projet_id = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()){		
				TeamDAO teamdao = new TeamDAO();
				CategorieDAO categoriedao = new CategorieDAO();
				
				Team team = teamdao.getTeam(rs.getInt("team_id"));
				Categorie categorie = categoriedao.getCategorie(rs.getInt("categorie_id"));	
            	
				project = new Project(id, rs.getString("nom"), rs.getString("description"), rs.getDate("created_at"), team, categorie);
				return project;              
            }
            
            
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(con!=null){
                Database.disconnect();
            }
        }
        return null;
    }
	public Project getProject(String nom){
        Connection con = Database.getConx();
        Project project = null;
        TeamDAO teamdao = new TeamDAO();
		CategorieDAO categoriedao = new CategorieDAO();
		
        try{
            String query = "SELECT * FROM projets WHERE nom = ?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1, nom);
            ResultSet rs = preparedStatement.executeQuery();
            
            if (rs.next()){		
				
				Team team = teamdao.getTeam(rs.getInt("team_id"));
				Categorie categorie = categoriedao.getCategorie(rs.getInt("categorie_id"));	
            	
				project = new Project(rs.getInt("projet_id"), nom, rs.getString("description"), rs.getDate("created_at"), team, categorie);
				return project;              
            }
            
            
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(con!=null){
                Database.disconnect();
            }
        }
        return null;
    }
	
	// add a project ...
    public void addProject(Project project){
        Connection con = Database.getConx();
        try {
        	String query = "INSERT INTO projets VALUES (NULL, ?, ?, ?, ?, ?)";
        	      
        	PreparedStatement preparedStatement = con.prepareStatement(query);
        	preparedStatement.setString(1,project.getNom());
        	preparedStatement.setString(2,project.getDescription());
        	preparedStatement.setDate(3,(Date) project.getCreated_at());
        	preparedStatement.setInt(4, project.getTeam().getId());
        	preparedStatement.setInt(5, project.getCategorie().getId());
        	preparedStatement.execute();
 
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            if(con!=null){
                Database.disconnect();
            }
        }
    }

    //update project...
    
    public void updateProject(Project project) {
    	Connection con = Database.getConx();
        try{
        	String query = "UPDATE `projets` SET `projet_id`=,`nom`='"+project.getNom()+"',`description`='"+ project.getDescription() +"',`created_at`='"+project.getCreated_at()+"',`team_id`="+project.getTeam().getId()+",`categorie_id`=" + project.getCategorie().getId() + " WHERE projet_id = "+ project.getId();
        	Statement statement = con.createStatement();
            statement.executeUpdate(query);
            
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(con!=null){
                Database.disconnect();
            }
        }
    	
    }
    
    
    //delete project...
    
    public void deleteProject(int id) {
        Connection con = Database.getConx();
        try {
        	Statement stm = con.createStatement();
        	String sql = "DELETE FROM projets WHERE projet_id=" + id; 
        	stm.executeUpdate(sql);
        	
        }catch(SQLException e) {
        	e.printStackTrace();
        }finally {
            if(con!=null){
                Database.disconnect();
            }
        }
    }
	

}

package models;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Project;

public class ProjectDAO {
	
	//get all projects
	public ArrayList<Project> getAllProjects(){
		
		ArrayList<Project> projects = new ArrayList<Project>();
		
		Connection con = Database.getConx();
		try {
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM projets");
			
			while(rs.next()) {
				int id = rs.getInt("projet_id");
				String nom = rs.getString("nom");
				String description = rs.getString("description");
				Date created_at = rs.getDate("created_at");
				int team_id = rs.getInt("team_id");
				int categorie_id = rs.getInt("categorie_id");
				
				//instance
				//TODO projects 
				
				
				
				//Project project = new Project(id, nom, description, created_at, team, categorie);
				//projects.add(project);
			}
			
			stm.close();
			rs.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return projects;
		
	}
	
	// get a project by name ...
	
	public Project getProject(int id){
        Connection con = Database.getConx();
        Project project = null;
        try{
            String query = "SELECT * FROM projets WHERE nom=?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,id);

            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
            	String nom = rs.getString("nom");
				String description = rs.getString("description");
				Date created_at = rs.getDate("created_at");
				int team_id = rs.getInt("team_id");
				int categorie_id = rs.getInt("categorie_id");
            	
					
				//TODO instance project
				//Project project = new Project(id, nom, description, created_at, team, categorie);
                
            }
            
            rs.close();
            
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            if(con!=null){
                Database.disconnect();
            }
        }
        return project;
    }
	
	// add a project ...
    public void addProject(Project project){
        Connection con = Database.getConx();
        try {
        	String query = "INSERT INTO projets (nom, description, created_at, team_id, categorie_id) VALUES (?, ?, ?, ?, ?);";
        	Statement stm = con.createStatement();       
        	PreparedStatement preparedStatement = con.prepareStatement(query);
        	preparedStatement.setString(1,project.getNom());
        	preparedStatement.setString(2,project.getDescription());
        	preparedStatement.setDate(3,(Date) project.getCreated_at());
        	preparedStatement.setInt(4, project.getTeam().getId());
        	preparedStatement.setInt(5, project.getCategorie().getId());
 
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //update project...
    
    public void updateProject(Project project) {
    	Connection con = Database.getConx();
        try{
        	String query = "UPDATE `projets` SET `projet_id`=,`nom`='"+project.getNom()+"',`description`='"+ project.getDescription() +"',`created_at`='"+project.getCreated_at()+"',`team_id`="+project.getTeam().getId()+",`categorie_id`=" + project.getCategorie().getId() + " WHERE "+ project.getId()+" ";
        	Statement statement = con.createStatement();
            statement.executeUpdate(query);
            
        }catch (Exception e){
            e.printStackTrace();
        }
    	
    }
    
    
    //delete project...
    
    public void deleteProject(int id) {
        Connection con = Database.getConx();
        try {
        	Statement stm = con.createStatement();
        	String sql = "DELETE FROM projets WHERE id=" + id; 
        	stm.executeUpdate(sql);
        	
        }catch(SQLException e) {
        	e.printStackTrace();
        }
    }
	

}

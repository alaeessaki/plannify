package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Model.Database;
import Model.Person;
import beans.Project;

public class ProjectDAO {
	
	//get all projects
	public ArrayList<Project> getAllProjects(){
		
		ArrayList<Project> projects = new ArrayList<Project>();
		
		Connection conn = Database.getConx();
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery("SELECT * FROM projets");
			
			while(rs.next()) {
				Project project = new Project(rs.getInt("projet_id"), rs.getString("nom"), rs.getString("description"), rs.getDate("created_at"), );
				projects.add(project);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			return null;
			
		}
		
	}
	
	// get a project by name ...
	
	public Project getProject(String nom){
        Connection con = Database.getConx();
        try{
            String query = "SELECT * FROM projets WHERE nom=?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,nom);

            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                Project person = new Project(rs.getInt("projet_id"), rs.getString("nom"),rs.getString("description"),rs.getDate("created_at"),);
                return person;
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
    public void addPerson(Project project){
        Connection con = Database.getConx();
        try {
           Statement stm = con.createStatement();
          

 
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    //update project...
    
    
    //delete project...
    
    public void deleteProject(int id) {
        Connection con = Database.getConx();
        try {
        	Statement stm = con.createStatement();
        	String sql = "DELETE FROM projets WHERE id="+id; 
        	stm.executeUpdate(sql);
        	
        }catch(SQLException e) {
        	e.printStackTrace();
        }
    }
	

}

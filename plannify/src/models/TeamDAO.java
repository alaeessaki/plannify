package models;

import beans.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.PreparedStatement;


public class TeamDAO {

    public ArrayList<Team> getAll(){

    	ArrayList<Team> teams = new ArrayList<Team>();

        Connection con = Database.getConx();
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM teams");

            while (rs.next()){
            	
            	EntrepriseDAO entreprisedao = new EntrepriseDAO();
            	Entreprise ent = entreprisedao.getEntreprise(rs.getInt("entreprise_id")); 
            	
                Team T = new Team(rs.getInt("team_id"), rs.getString("nom"), ent);
                teams.add(T);
            }
            stmt.close();
            rs.close();
            return teams;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public Team getTeam(int id){
    	
    	Connection con = Database.getConx();
    	
        try{
            String query = "SELECT * FROM teams WHERE team_id=?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
            	
            	EntrepriseDAO entreprisedao = new EntrepriseDAO();     	            	
            	Entreprise ent = entreprisedao.getEntreprise(rs.getInt("entreprise_id")); 
            	
                Team T = new Team(id, rs.getString("nom"), ent);
                return T;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public Team getTeam(String nom){
    	
    	Connection con = Database.getConx();
    	
        try{
            String query = "SELECT * FROM teams WHERE nom=?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,nom);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
            	            	
            	EntrepriseDAO entreprisedao = new EntrepriseDAO();     	            	
            	Entreprise ent = entreprisedao.getEntreprise(rs.getInt("entreprise_id")); 
            	
                Team T = new Team(rs.getInt("team_id"),nom,ent);
                return T;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
    
    public void addTeam(Team T){
    	Connection con = Database.getConx();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO teams(team_id,nom,entreprise_id) VALUES('"+T.getId()+"','"+T.getNom()+"',"+T.getEntreprise().getId()+")");

         }catch (SQLException e){
             e.printStackTrace();
         }
    }
    
    
    
    public void delTeam(int id){
    	Connection con = Database.getConx();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM teams WHERE team_id="+id);
         }catch (SQLException e){
             e.printStackTrace();
         }
    }
    
    
    public void updateTeam(Team T){
    	Connection con = Database.getConx();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("UPDATE `teams` SET `nom`='"+T.getNom()+"',`entreprise_id`="+T.getEntreprise().getId()+" WHERE team_id="+T.getId());

         }catch (SQLException e){
             e.printStackTrace();
         }
    }
    
}

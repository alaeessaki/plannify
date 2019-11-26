package models;

import beans.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class RoleDAO {

    public ArrayList<Role> getAll(){

    	ArrayList<Role> rolesList = new ArrayList<Role>();

        Connection con = Database.getConx();
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM role");

            while (rs.next()){
            	Role rol = new Role(rs.getInt("role_id"),rs.getString("nom"));
            	rolesList.add(rol);
            }
            stmt.close();
            rs.close();
            return rolesList;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public Role getRole(int id){
    	
    	Connection con = Database.getConx();
    	
        try{
            String query = "SELECT * FROM role WHERE role_id=?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
            	            	
            	Role rol = new Role(rs.getInt("role_id"),rs.getString("nom"));
                return rol;
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
    
    public Role getRole(String nom){
    	
    	Connection con = Database.getConx();
    	
        try{
            String query = "SELECT * FROM role WHERE role_name=?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,nom);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
            	           
            	Role rol = new Role(rs.getInt("role_id"),nom); 
                return rol;
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
    
    public void addRole(Role rol){
    	Connection con = Database.getConx();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO role(role_id,nom) VALUES('"+rol.getId()+"','"+rol.getNom()+"')");

         }catch (SQLException e){
             e.printStackTrace();
         }
    }
    
    
    
    public void delRole(int id){
    	Connection con = Database.getConx();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM role WHERE role_id="+id);
         }catch (SQLException e){
             e.printStackTrace();
         }
    }
    
    
    public void updateRole(Role rol){
    	Connection con = Database.getConx();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("UPDATE `role` SET `nom`='"+rol.getNom()+"' WHERE role_id="+rol.getId());

         }catch (SQLException e){
             e.printStackTrace();
         }
    }
}

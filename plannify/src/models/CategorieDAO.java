package models;

import beans.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.SQLException;
import java.sql.PreparedStatement;

public class CategorieDAO {


    public ArrayList<Categorie> getAll(){

    	ArrayList<Categorie> cats = new ArrayList<Categorie>();

        Connection con = Database.getConx();
        try{
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM categories");

            while (rs.next()){
            	Categorie cat = new Categorie(rs.getInt("categorie_id"),rs.getString("nom"));
            	cats.add(cat);
            }
            stmt.close();
            rs.close();
            return cats;
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
    
    public Categorie getCategorie(int id){
    	
    	Connection con = Database.getConx();
    	
        try{
            String query = "SELECT * FROM categories WHERE categorie_id=?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
            	            	
            	Categorie cat = new Categorie(rs.getInt("categorie_id"),rs.getString("nom"));
                return cat;
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
    
    public Categorie getCategorie(String nom){
    	
    	Connection con = Database.getConx();
    	
        try{
            String query = "SELECT * FROM categories WHERE nom=?";
            PreparedStatement preparedStatement = con.prepareStatement(query);
            preparedStatement.setString(1,nom);
            ResultSet rs = preparedStatement.executeQuery();
            if (rs.next()){
            	           
            	Categorie cat = new Categorie(rs.getInt("categorie_id"),nom);
                return cat;
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
    
    public void addCategorie(Categorie cat){
    	Connection con = Database.getConx();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("INSERT INTO categories(categorie_id,nom) VALUES('"+cat.getId()+"','"+cat.getNom()+"')");

         }catch (SQLException e){
             e.printStackTrace();
         }
    }
    
    
    
    public void delCategorie(int id){
    	Connection con = Database.getConx();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("DELETE FROM categories WHERE categorie_id="+id);
         }catch (SQLException e){
             e.printStackTrace();
         }
    }
    
    
    public void updateCategorie(Categorie cat){
    	Connection con = Database.getConx();
        try {
            Statement st = con.createStatement();
            st.executeUpdate("UPDATE `categories` SET `nom`='"+cat.getNom()+"' WHERE categorie_id="+cat.getId());

         }catch (SQLException e){
             e.printStackTrace();
         }
    }

}

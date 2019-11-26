package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Entreprise;


public class EntrepriseDAO {
	
	public void addEnterprise(Entreprise E) {
		PreparedStatement ps;
		String query="insert into entreprises (nom,description) values(?,?)";
		try {
			Connection connection = Database.getConx();
			ps = connection.prepareStatement(query);
			ps.setString(1, E.getNom());
			ps.setInt(2, E.getId());
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public boolean deleteEntreprise(Entreprise E) {
		PreparedStatement ps;
		String query="Delete from entreprises where id=?";
		try {
			Connection connection = Database.getConx();
			ps = connection.prepareStatement(query);
			ps.setInt(1, E.getId());
			ps.execute();
	
			return true;
	
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public Entreprise getEntreprise(int id){
		Entreprise entreprise = null;
		String query="select * from entreprises where id = "+id;
	
		try {
			Connection connection = Database.getConx();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
		
			if(rs.next()) {
				String Nom = rs.getString("nom");
				String Desc = rs.getString("description");
				entreprise = new Entreprise(Nom, Desc);
			}
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return entreprise;
		
	}
	
	public ArrayList<Entreprise> getAllEntreprise(){
		
		ArrayList<Entreprise> entreprises = new ArrayList<Entreprise>();
		String query = "select * from entreprises";
		
		try {
			Connection connection = Database.getConx();
			Statement st = connection.createStatement();
			ResultSet rs = st.executeQuery(query);
			while(rs.next()) {
				String nom = rs.getString("nom");
				String desc = rs.getString("description");
				int id = rs.getInt("entreprise_id");
				Entreprise E = new Entreprise(id, nom, desc);
				entreprises.add(E);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return entreprises ;	
	} 
	
	
	public void updateEntreprise(Entreprise E) {
		String query="UPDATE entreprises SET nom='"+E.getNom()+"',description='"+E.getDescription()+"' WHERE entreprise_id ="+E.getId();
		try {
			Connection connection = Database.getConx();
			Statement st = connection.createStatement();
			st.executeUpdate(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	

}

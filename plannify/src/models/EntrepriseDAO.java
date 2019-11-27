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
			ps.setString(2, E.getDescription());
			ps.execute();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public boolean deleteEntreprise(Entreprise E) {
	
		
		try {
			Connection connection = Database.getConx();
			String query="Delete from entreprises where entreprise_id="+ E.getId();
			Statement stm = connection.createStatement();
			stm.executeUpdate(query);	
			return true;
	
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	public Entreprise getEntreprise(int id){
		Entreprise entreprise = null;
		
		try {
			Connection connection = Database.getConx();
		
			String query="select * from entreprises where entreprise_id = ?";
			PreparedStatement ps = connection.prepareStatement(query);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
		
			if(rs.next()) {
		
				entreprise = new Entreprise(rs.getInt("entreprise_id"), rs.getString("nom"),rs.getString("description"));
				return entreprise;
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

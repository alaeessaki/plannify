package models;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import beans.Entreprise;


public class EntrepriseDAO {
	
	public void AddEnterprise(Entreprise E) {
		PreparedStatement ps;
		String query="insert into entreprises (nom,description) values  (?,?)";
		try {
			Connection connection= (Connection) Database.getConx();
			ps=(PreparedStatement) connection.prepareStatement(query);
			ps.setString(1, E.getNom());
			ps.setInt(2, E.getId());
			ps.execute();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	public  boolean DeleteEntrepriseId(Entreprise E) {
		PreparedStatement ps;
		String query="Delete from entreprises where id=?";
		try {
			Connection connection= (Connection) Database.getConx();
			ps=(PreparedStatement) connection.prepareStatement(query);
			ps.setInt(1, E.getId());
			ps.execute();
			
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<Entreprise> GetEntrepriseId(int id){
		ArrayList<Entreprise> entreprise = new ArrayList<Entreprise>();
		String query="select * from entreprises where id = "+id;
		try {
			Connection connection= (Connection) Database.getConx();
			Statement st=connection.createStatement();
			ResultSet rs= st.executeQuery(query);
			while (rs.next()) {
				String Nom=rs.getString("nom");
				String Desc=rs.getString("description");
				Entreprise E=new Entreprise(Nom, Desc);
				entreprise.add(E);	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return entreprise;
		
	}
	
	public ArrayList<Entreprise> GetAllEntreprise(){
		ArrayList<Entreprise> entreprise = new ArrayList<Entreprise>();
		String query = "select * from entreprises";
				try {
					Connection connection= (Connection) Database.getConx();
					Statement st=connection.createStatement();
					ResultSet rs=st.executeQuery(query);
					while(rs.next()) {
						String nom=rs.getString("nom");
						String desc=rs.getString("description");
						int id= rs.getInt("entreprise_id");
						Entreprise E =new Entreprise(id, nom, desc);
						entreprise.add(E);
						return entreprise;
						
					}
				} catch (Exception e2) {
					// TODO: handle exception
				}

				return null ;

		
	} 
	
	
	public void UpdateName(Entreprise E) {
		String query="UPDATE entreprises SET nom='"+E.getNom()+"',description='"+E.getDescription()+"' WHERE entreprise_id ="+E.getId();
		try {
			Connection connection= (Connection) Database.getConx();
			Statement st=connection.createStatement();
			st.executeUpdate(query);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	

}

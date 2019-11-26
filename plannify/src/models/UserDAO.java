package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import beans.Entreprise;
import beans.Role;
import beans.User;

public class UserDAO {
	
	public void createRegularUser(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "";
		
		try {
			connection = Database.getConx();
			query = "INSERT INTO users VALUES(NULL, ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getNom());
			preparedStatement.setString(4, user.getPrenom());
			preparedStatement.setInt(5, user.getRole().getId());
			preparedStatement.setInt(6, user.getEntreprise().getId());
			
			preparedStatement.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			if(connection!=null) {
				connection = null;
				Database.disconnect();
			}
		}
	}
	
	//TODO add createAdminUser using createEntreprise method
	
	public ArrayList<User> getAll(){
		ArrayList<User> users = new ArrayList<User>();
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = Database.getConx();
			statement = connection.createStatement();
			resultSet = statement.executeQuery("SELECT * FROM users");
			
			while(resultSet.next()) {
				int id = resultSet.getInt("user_id");
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				String nom = resultSet.getString("nom");
				String prenom = resultSet.getString("prenom");
				int role_id = resultSet.getInt("role_id");
				int entreprise_id = resultSet.getInt("entreprise_id");
				
				/*
				 * TODO get role object using RoleDAO
				 * get entreprise object using entrepriseDAO
				 * */
				
				//User user = new User(id, email, password, nom, prenom, role, entreprise);
				//users.add(user);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return users;
		
	}
	
	public User getUser(int id) {
		User user = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "";
		
		try {
			connection = Database.getConx();
			query = "SELECT * FROM users WHERE user_id=?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, id);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				String email = resultSet.getString("email");
				String password = resultSet.getString("password");
				String nom = resultSet.getString("nom");
				String prenom = resultSet.getString("prenom");
				int role_id = resultSet.getInt("role_id");
				int entreprise_id = resultSet.getInt("entreprise_id");
				
				/*TODO 
				 * get role Object using RoleDAO
				 * get entreprise object using EntrepriseDAO
				 * then create User Object
				 */
				
				//User user = new User(id, email, password, nom, prenom, role, entreprise);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public User getUser(String email) {
		User user = null;
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String query = "";
		
		try {
			connection = Database.getConx();
			query = "SELECT * FROM users WHERE email=?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, email);
			
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				int id = resultSet.getInt("user_id");
				String password = resultSet.getString("password");
				String nom = resultSet.getString("nom");
				String prenom = resultSet.getString("prenom");
				int role_id = resultSet.getInt("role_id");
				int entreprise_id = resultSet.getInt("entreprise_id");
				
				/*TODO 
				 * get role Object using RoleDAO
				 * get entreprise object using EntrepriseDAO
				 * then create User Object
				 */
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public void updateUser(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "";
		
		try {	
			connection = Database.getConx();
			query = "UPDATE users SET email = ?, password = ?, nom = ?, prenom = ?, role_id = ?, entreprise_id = ?  WHERE user_id = ? ";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, user.getEmail());
			preparedStatement.setString(2, user.getPassword());
			preparedStatement.setString(3, user.getNom());
			preparedStatement.setString(4, user.getPrenom());
			preparedStatement.setInt(5, user.getRole().getId());
			preparedStatement.setInt(6, user.getEntreprise().getId());
			preparedStatement.setInt(7, user.getId());
			
			preparedStatement.execute();

		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(User user) {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		String query = "";
		
		try {	
			connection = Database.getConx();
			query = "DELETE FROM users WHERE user_id = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, user.getId());
			
			preparedStatement.execute();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
}

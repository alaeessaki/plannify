package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
	
	private static Connection connection;
	private static String dbname = "suivie_des_bugs";
	
	public static Connection getConx() {
		if(connection!=null) {
			return connection;
		}else {
			try {
			Class.forName("com.mysql.jdbc.Driver");			
			String url ="jdbc:mysql://localhost:3306/"+dbname+"??useSSL=false";
			String user="root";
			String passwd="";
			
			connection = DriverManager.getConnection(url,user,passwd);
			
			}catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				//connection
			return connection;
			
		}
	}
	
	//Disconnect
	public static void disconnect() {
		if(connection==null) {
			return;
		}
		try {
			connection.close();
			connection=null;
		}catch(Exception e) {	
			e.printStackTrace();
		}
	}
	
}
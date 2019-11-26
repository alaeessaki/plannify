package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Connexion {
private static Connection maconex  ;
	
	public static Connection getConx() {

		try {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("Driver O.K.");
		String url ="jdbc:mysql://localhost:3306/suivie_des_bugs";
		String user="root";
		String passwd="";
		maconex = DriverManager.getConnection(url,user,passwd);
		System.out.println("Connexion effective !");
		}
	 catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
		//connection
		return maconex;
	}


}

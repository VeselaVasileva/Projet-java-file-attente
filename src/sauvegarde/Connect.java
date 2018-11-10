package sauvegarde;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class Connect{
	
	private String url="jdbc:mysql://localhost:3306/file_attente";
	private String user="root";
	private String mdp="vessi_zaio_baio_56";
	private static Connection con;
	
	private Connect(){	   
			try {
			    		/*static Class<?>forName (String className)=Returns the Class object associated with the class or interface with the given string name.**/
			    		Class.forName("com.mysql.jdbc.Driver");
			    		con=DriverManager.getConnection(url,user,mdp);
			    		System.out.println ("Connexion réussie");
			    	}
			    	catch(ClassNotFoundException ex){
			                System.out.println("Probleme de pilote de base de donnes");
			    		} 
		
			    	catch (SQLException ex) {
			    		System.out.println("Probleme de connexion ou de requete");
		    
			    		}
	}
	
	public static Connection getInstance(){
		if(con==null){
			new Connect();
			System.out.println("nouvelle connexion");
		}
		return con;
	}
}
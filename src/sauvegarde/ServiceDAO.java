package sauvegarde;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.Service;

public class ServiceDAO extends DAO<Service>{

public ServiceDAO(Connection conn){
	super(conn);
}

public int create(Service obj) throws SQLException{
	String reqInsertion="INSERT INTO services (nom_service) VALUES (\""+obj.getNomService()+"\")";
	System.out.println("OK1");
	return conn.createStatement().executeUpdate(reqInsertion);
	//System.out.println("OK2");
	 //new Service (rs.getString("nom_service"), rs.getLong("id_service"));
}
public boolean delete(Service obj) throws SQLException{
	return false;
}

public Service update(Service obj)throws SQLException{
	String reqUpdate="UPSATE services SET nom_service \""+obj.getNomService()+"WHERE id_service="+obj.getIdService();
	ResultSet rs = conn.createStatement().executeQuery(reqUpdate);
	 return new Service (rs.getString("nom_service"), rs.getLong("id_service"));
}


public List<Service> export() throws SQLException{
	List<Service> s = new ArrayList<Service>();
	String reqSelection="SELECT* FROM services";
	ResultSet rs = conn.createStatement().executeQuery(reqSelection);
	
	 while (rs.next()) {
		 Service service = new Service(rs.getString("nom_service"),rs.getInt("id_service"));
		 s.add(service);
	 }
	 return s;
}
public Service find(long id) throws SQLException{
	String reqSearch="SELECT* FROM services WHERE id_service="+id;
	ResultSet rs=conn.createStatement().executeQuery(reqSearch);
	return new Service (rs.getString("nom_service"), rs.getLong("id_service"));
}

}

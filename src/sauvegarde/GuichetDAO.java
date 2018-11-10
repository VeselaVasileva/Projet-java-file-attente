package sauvegarde;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modele.Guichet;

public class GuichetDAO extends DAO<Guichet>{

public GuichetDAO(Connection conn){
	super(conn);
}

public int create(Guichet obj) throws SQLException{
	String reqInsertion="INSERT INTO guichets (num_guichet,id_service) VALUES (\""+obj.getNumGuichet()+"\","+obj.getIdService()+ ")";
	return conn.createStatement().executeUpdate(reqInsertion);
	//return new Guichet (rs.getInt("num_guichet"), rs.getLong("id_guichet"));
}

public boolean delete(Guichet obj) throws SQLException{
	return false;
}

public Guichet update(Guichet obj) throws SQLException{
	String reqUpdate="UPSATE guichets SET num_guichet= \""+obj.getNumGuichet()+"WHERE id_guichet="+obj.getIdGuichet();
	ResultSet rs=conn.createStatement().executeQuery(reqUpdate);
	return new Guichet (rs.getInt("num_guichet"), rs.getLong("id_guichet"),rs.getLong("id_service"));
}
public List<Guichet> export() throws SQLException{
	ArrayList<Guichet> g = new ArrayList<Guichet>();
	String reqSelection="SELECT* FROM guichets";
	ResultSet rs = conn.createStatement().executeQuery(reqSelection);
	
	 while (rs.next()) {
		 Guichet guichet = new Guichet(rs.getInt("num_guichet"),rs.getLong("id_guichet"),rs.getLong("id_service"));
		 g.add(guichet);
	 }
	 return g;
}
public Guichet find(long id) throws SQLException{
	String reqSearch="SELECT* From guichets WHERE id_guichet="+id;
	ResultSet rs=conn.createStatement().executeQuery(reqSearch);
	return new Guichet (rs.getInt("num_guichet"), rs.getLong("id_guichet"),rs.getLong("id_service"));
}

}

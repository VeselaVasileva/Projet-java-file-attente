package sauvegarde;

import modele.Ticket;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TicketDAO extends DAO<Ticket>{

	public TicketDAO(Connection conn){
		super(conn);
	}
	
	public int create(Ticket obj) throws SQLException{
		String reqInsertion="INSERT INTO tickets (date_ticket, heure_debut, heure_fin,id_service) VALUES (\""+obj.dateToString()+"\", \""+obj.heureDebutToString()+"\", \""+obj.heureFinToString()+"\", "+obj.getidService()+")";
		return conn.createStatement().executeUpdate(reqInsertion);
		//new Ticket (rs.getLong("id_ticket"),rs.getInt("num_guichet"),rs.getString("date"),rs.getString("heure_debut"),rs.getString("heure_fin"),rs.getInt("id_service"));
	}
	public boolean delete(Ticket obj) throws SQLException{
		return false;
	}
	
	public Ticket update(Ticket obj) throws SQLException{
		String reqUpdate="UPDATE tickets SET date_ticket =\""+obj.getDate().toString()+"\", heure_debut=\""+obj.getDebut().toString()+"\", heure_fin=\""+obj.getFin().toString()+"\""+"WHERE id_ticket="+obj.getIdTicket();
		ResultSet rs=conn.createStatement().executeQuery(reqUpdate);
		return new Ticket (rs.getLong("id_ticket"),rs.getInt("num_guichet"),rs.getString("date"),rs.getString("heure_debut"),rs.getString("heure_fin"),rs.getInt("id_service"));
	}
	
	public List<Ticket> export() throws SQLException{
		List<Ticket>t=new ArrayList<Ticket>();
		String reqSelection="SELECT* FROM tickets INNER JOIN guichets ON tickets.id_guichet=guichets.id_guichet";
		ResultSet rs = conn.createStatement().executeQuery(reqSelection);
		while (rs.next()) {
			 Ticket ticket = new Ticket(rs.getLong("id_ticket"),rs.getInt("num_guichet"),rs.getString("date_ticket"),rs.getString("heure_debut"),rs.getString("heure_fin"),rs.getInt("id_service"));
			 t.add(ticket);
		 }
		 return t;
		
	}
	public Ticket find(long id) throws SQLException{
		String reqSearch="SELECT* FROM services SET date_ticket WHERE id_ticket="+id;
		ResultSet rs=conn.createStatement().executeQuery(reqSearch);
		return new Ticket (rs.getLong("id_ticket"),rs.getInt("num_guichet"),rs.getString("date"),rs.getString("heure_debut"),rs.getString("heure_fin"),rs.getInt("id_service"));
	}
}

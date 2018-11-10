package sauvegarde;


import java.sql.Connection;
import java.sql.SQLException;

import modele.Guichet;
import modele.Service;
import modele.Ticket;

public class CreateDAO {
	protected static final Connection conn=Connect.getInstance();
	
	public static DAO<Service> getServiceDAO(){
		return new ServiceDAO(conn);
	}
	
	public static int createService(Service s) throws SQLException{
		return new ServiceDAO(conn).create(s);
	}
	
	public static DAO<Guichet> getGuichetDAO(){
		return new GuichetDAO(conn);
	}
	
	public static int createGuichet(Guichet g) throws SQLException{
		return new GuichetDAO(conn).create(g);
	}
	
	public static DAO<Ticket> getTicketDAO(){
		return new TicketDAO(conn);
	}
	
	public static int createTicket(Ticket t) throws SQLException{
		return new TicketDAO(conn).create(t);
	}
	
}


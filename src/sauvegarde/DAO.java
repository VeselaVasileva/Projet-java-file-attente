package sauvegarde;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;


public abstract class DAO<T> {
	protected Connection conn=null;
	
	public DAO(Connection conn){
		this.conn=conn;
	}
	
	public abstract int create(T obj)throws SQLException;
	public abstract boolean delete(T obj)throws SQLException;
	public abstract T update(T obj)throws SQLException;
	public abstract List<T> export() throws SQLException;
	public abstract T find(long id) throws SQLException;
}

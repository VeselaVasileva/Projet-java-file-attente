package modele;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Observer.Observable;
import Observer.Observer;
import sauvegarde.CreateDAO;


public class Administration implements Observable{
	public List<Service> listeServices = new ArrayList<Service>();

	private ArrayList<Observer>listObserver = new ArrayList<Observer>();
	
	public Administration(){
		listeServices=charger();
		for(int i=0;i<listeServices.size();i++){
			listeServices.get(i).chargerGuichets();
			listeServices.get(i).chargerTickets();
		}
	}

	public void setListeServices (ArrayList<Service> a){
		this.listeServices = a;
	}
	public List<Service> getListeServices(){
		return this.listeServices;
	}
	
	public List<Service> charger(){
		try {
			return CreateDAO.getServiceDAO().export();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void ajouterService(Service s){
				try {
					CreateDAO.createService(s);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				listeServices=charger();	
	}
	
	public void ajouterGuichet(Guichet g){
		try {
			CreateDAO.createGuichet(g);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//listeServices.add(s);	
}
		
		public List<Guichet> getGuichets(Service s){
			return s.getGuichets();
			
		}

	public void addObserver(Observer obs) {
		this.listObserver.add(obs);
		this.notifyObserver();
		
	}

	
	public void removeObserver() {
		listObserver=new ArrayList<Observer>();
		
	}

	public void notifyObserver() {
		for(Observer obs : this.listObserver)
			obs.update();
}
}

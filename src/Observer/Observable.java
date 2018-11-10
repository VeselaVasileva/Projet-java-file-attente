package Observer;

import java.util.List;

import modele.Guichet;
import modele.Service;

public interface Observable {
	void addObserver(Observer obs);
	void removeObserver();
	void notifyObserver();
	public List<Service> getListeServices();
	public List<Guichet> getGuichets(Service s);
	public void ajouterService(Service s);
	public void ajouterGuichet(Guichet g);
}

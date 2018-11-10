package Controleur;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import Observer.Observable;
import modele.Administration;
import modele.Guichet;
import modele.Service;
import modele.Ticket;
import sauvegarde.CreateDAO;
import vue.fenetreSaisie;
import vue.vueAjoutService;

public class Controler {
	protected Observable admin;
	public Controler(Observable a){
		this.admin=a;
	}
	public void controlAjoutService(String s ){
		boolean existant = false;
		for(int i=0;i<admin.getListeServices().size();i++){
			if(s.equals(admin.getListeServices().get(i).getNomService())){
				existant=true;
				JOptionPane.showConfirmDialog(null,"Ce service existe déjà","Nouveau service",JOptionPane.PLAIN_MESSAGE);
				break;
			}
		}
		if(!existant){
			admin.ajouterService(new Service(s));
			JOptionPane.showConfirmDialog(null,"Création réussie","Nouveau service",JOptionPane.PLAIN_MESSAGE);
		}
			
	}
	
	public void controlAjoutGuichet(String num, String s){
		boolean existant=false;
		int n=0;
		Service service=null;
		for(int i=0;i<admin.getListeServices().size();i++){
			if(s.equals(admin.getListeServices().get(i).getNomService())){
				service =admin.getListeServices().get(i);
			}
		}
		if(!num.matches("[0-9]")){
			JOptionPane.showConfirmDialog(null,"Entrez un numéro","Nouveau guichet",JOptionPane.PLAIN_MESSAGE);
			existant=true;
		}
		else{
			n=Integer.parseInt(num);
			for(int j=0; j<admin.getListeServices().size();j++){
				for(int i=0; i<service.getGuichets().size(); i++){
					if(n==service.getGuichets().get(i).getNumGuichet()){
					existant=true;
					JOptionPane.showConfirmDialog(null,"Ce guichet existe déjà","Nouveau guichet",JOptionPane.PLAIN_MESSAGE);
					}
				}
			}
		}
		if(!existant){
			admin.ajouterGuichet(new Guichet(n,service));
			JOptionPane.showConfirmDialog(null,"Création réussie","Nouveau service",JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	public void controlAjoutTicket(long id){
		for(int i=0;i<admin.getListeServices().size();i++){
			if(admin.getListeServices().get(i).getIdService()==id){
				try {
					CreateDAO.createTicket(new Ticket(i));
					System.out.println("Apres create");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	public void control(){}

}

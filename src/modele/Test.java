package modele;

import java.sql.SQLException;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;

import Observer.Observable;
import sauvegarde.CreateDAO;
import sauvegarde.ServiceDAO;
import vue.ModeleFenetre;
import vue.vueClient;


public class Test {

	public static void main(String[] args) throws SQLException {
		
	/*	Service s1 = new Service("Impots");
		Service s2 = new Service("Secu");
		Service s3 = new Service ("Autres");
		
		System.out.println(CreateDAO.createService(s1));
		System.out.println("id_service="+s1.getIdService()+", nom du service ="+s1.getNomService());
		System.out.println(CreateDAO.createService(s2));
		System.out.println("id_service="+s2.getIdService()+", nom du service ="+s2.getNomService());
		System.out.println(CreateDAO.createService(s3));
		System.out.println("id_service="+s3.getIdService()+", nom du service ="+s3.getNomService());
}**/
		String [] recu = new String[8];
		System.out.println(new Date().toString());
		recu = FonctionsUtiles.decouper(new Date().toString(),"   ::  ");
		for (int i=0;i<recu.length;i++){
			System.out.println(recu[i]);
		}
		System.out.println(Ticket.toString(recu));
	Observable administration = new Administration();
		//System.out.println(administration.getListeServices().size());
		ModeleFenetre fenetre =new ModeleFenetre(administration);
		fenetre.setVisible(true);
		vueClient client=new vueClient(administration);
		client.setVisible(true);
	}
	
}
package modele;

import java.util.ArrayList;
import java.util.List;

import sauvegarde.CreateDAO;

public class Stats {
	
	private List<Ticket> t;
	private List<Service>s;
	private List<Guichet>g;
	private String [] debut = new String[3];
	private String [] fin = new String[3];
	private String[]resultats;
	private String[]headerLine;
	private String []headerColumns= {"Début Service","Fin Service","Nombre tickets traités","Temps moyen traitement"};
	
	
	public Stats(List<Ticket>tickets,List<Service>services,List<Guichet>guichets,String d, String f){
		t=tickets;
		s=services;
		g=guichets;
		
		setDebut(FonctionsUtiles.decouper(d,"//"));
		setFin(FonctionsUtiles.decouper(d,"//"));
		
		headerLine = new String[(g.size()+s.size())];
		for(int i=0;i<g.size();i++){
			headerLine[i]="Guichet "+g.get(i).getNumGuichet();}
		for(int j=g.size();j<headerLine.length;j++ ){
			headerLine[j]="Service "+s.get(j-g.size()).getNomService();
		}	
		}
	
	public List<Ticket> ticketsDemandes(){
		List<Ticket> demandes = new ArrayList<Ticket>();
		for(int i=0;i<t.size();i++){
			if((t.get(i).getAnnee()>=Integer.parseInt(debut[2]))&&(t.get(i).getAnnee()<=Integer.parseInt(fin[2]))){
				if((t.get(i).getMois()>=Integer.parseInt(debut[1]))&&(t.get(i).getMois()<=Integer.parseInt(fin[1]))){
					if((t.get(i).getJour()>=Integer.parseInt(debut[0]))&&(t.get(i).getJour()<=Integer.parseInt(fin[0]))){
						demandes.add(t.get(i));
					}
				}
			}
		}
		return demandes;
	
	}
	
	public int nbreTicketsGuichet(Guichet  g){
		int nombre=0;
		List<Ticket> tickets=this.ticketsDemandes();
		for(int i=0;i<tickets.size();i++){
			if(g.getNumGuichet()==tickets.get(i).getnumGuichet()){
				nombre++;
			}
		}
		return nombre;
	}

	public int nbreTicketsService(Service  s){
		int nombre=0;
		for(int i=0; i<s.g.size(); i++){
			nombre=nombre+nbreTicketsGuichet(s.g.get(i));
		}
		return nombre;
	}
	
	public int tempsGuichet(Guichet  g){
		int nombre=0;
		List<Ticket> tickets=this.ticketsDemandes();
		for(int i=0;i<tickets.size();i++){
			if(g.getNumGuichet()==tickets.get(i).getnumGuichet()){
				nombre=nombre+tickets.get(i).calculDuree();
			}
		}
		return nombre;
	}

	public int tempsService(Service s){
		int nombre=0;
		for(int i=0; i<s.g.size(); i++){
			nombre=nombre+tempsGuichet(s.g.get(i));
		}
		return nombre;
	}

	public String[] getResultats() {
		return resultats;
	}


	public void setResultats(String[] resultats) {
		this.resultats = resultats;
	}


	public String [] getHeaderColumns() {
		return headerColumns;
	}


	public void setHeaderColumns(String [] headerColumns) {
		this.headerColumns = headerColumns;
	}


	public String [] getFin() {
		return fin;
	}


	public void setFin(String [] fin) {
		this.fin = fin;
	}


	public String [] getDebut() {
		return debut;
	}


	public void setDebut(String [] debut) {
		this.debut = debut;
	}
	
}
	

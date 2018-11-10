package modele;

import java.util.Date;

public class Guichet {
	private long idGuichet;
	private long idService;
	private int numGuichet ;
	private boolean disponible ;
	private boolean ouvert;
	private Ticket enCours;
	
	
	public Guichet(){}
	public Guichet (int numero){
		idGuichet=0;
		numGuichet=numero;
		disponible=false;
		enCours=null;
	}
	
	public Guichet (int numero, long idG, long idS){
		idGuichet=idG;
		setIdService(idS);
		numGuichet=numero;
		disponible=false;
		enCours=null;
	}
	
	public Guichet (int numero, Service s){
		setIdService(s.getIdService());
		idGuichet=0;
		numGuichet=numero;
		disponible=false;
		enCours=null;
		s.g.add(this);
	}
	
	public long getIdGuichet(){
		return this.idGuichet;
	}
	
	public void setIdGuichet(long id){
		this.idGuichet=id;
	}
	
	public int getNumGuichet (){
		return this.numGuichet;
	}
	
	public void setNumGuichet (int numero){
		numGuichet=numero;
	}
	
	public boolean getDispo (){
		return this.disponible;
	}
	
	public void setDispo (boolean dispo){
		disponible=dispo;
	}
	
	public boolean getOuvert(){
		return this.ouvert;
	}
	
	public void setOuvert(boolean o){
		this.ouvert=o;
	}
	
	public Ticket getEnCours() {
		return enCours;
	}

	public void setEnCours(Ticket enCours) {
		this.enCours = enCours;
	}

	public boolean appelerSuivant (Ticket ticket){
		String[] date = FonctionsUtiles.decouper(new Date().toString(),"   ::  ");
		this.enCours.setheureFin(date[3]);
		this.enCours.setminFin(date[4]);
		enCours=ticket;
		return disponible=true;
		
	}
	
	public Ticket appelerMeme(){
		return enCours;
		
	}
	
	public void ouvrir(){
		setOuvert(true);
	}
	
	public void fermer (){
		setOuvert(false);
	}

	public String afficherDispo(){
		String s;
		if(this.getOuvert()){
			s="Ouvert";
		}
		else{
			s="Fermé";
		}
		return s;
	}
	public long getIdService() {
		return idService;
	}
	public void setIdService(long idService) {
		this.idService = idService;
	}
}

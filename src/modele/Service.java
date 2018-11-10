package modele;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import sauvegarde.CreateDAO;

public class Service {
	private long idService;
	private String nomService;
	public List<Ticket> t = new ArrayList <Ticket>();
	public List<Guichet> g = new ArrayList <Guichet>();
	
	
	public Service(){}
	public Service(String nom){
		this.nomService=nom;
	}
	
	public Service(String nom, long id){
		this.nomService=nom;
		this.idService=id;
	}
	
	public Service(String nom, long id, List<Guichet> guichets){
		this.nomService=nom;
		this.idService=id;
		g = guichets;
	}
	
	public Service(String nom, long id, List<Guichet> guichets, List<Ticket>tickets){
		this.nomService=nom;
		this.idService=id;
		g = guichets;
		t = tickets;
	}
	
	public String getNomService() {
		return nomService;
	}

	public void setNomService(String nomService) {
		this.nomService = nomService;
	}
	
	public long getIdService(){
			return this.idService;
		}

	public List<Guichet> getGuichets(){
		return this.g;
	}
	
	public void setGuichets(List<Guichet> guichets){
		this.g=guichets;
	}
	
	public List<Ticket> getTickets(){
		return this.t;
	}
	
	public void setTicket(List<Ticket> tickets){
		this.t=tickets;
	}
	
	public void ajoutGuichet(Guichet guichet){
		this.g.add(guichet);
	}
	
	public void supprGuichet(Guichet guichet){
		this.g.remove(guichet);
	}
	
	public void ajoutTicket(Ticket ticket){
		this.t.add(new Ticket(idService));
	}
	
	
	/*public int numNvxTicket(Ticket ticket){
		for(int i=t.size(); i>=0;i--){
			if (t.get(i-1)==ticket){
				return i;
			}
		};
		return 0;
	}**/
	
	public String getNumTicket(Ticket ticket){
		if(ticket==null){
			return "";
		}
		return ""+(t.indexOf(ticket)+1);
	}
	
	public Ticket getTicketSuivant(){
		for(int i=0;i<t.size();i++){
			if(t.get(i).getheureDebut()==-1){
				return t.get(i);
			}
		}
		return null;
	}
	
	public Ticket getTicketPrecedent(Guichet g, Ticket ticket){
		for(int i=t.indexOf(ticket)-1; i>=0;i--){
			if(g.getNumGuichet()==t.get(i-1).getnumGuichet()){
				return t.get(i-1);
			}
		}
		return null;
	}

	public void attribuerTicket (Ticket ticket, Guichet guichet){
		String[] date = FonctionsUtiles.decouper(new Date().toString(),"   ::  ");
		ticket.setheureDebut(date[3]);
		ticket.setminDebut(date[4]);
		ticket.setnumGuichet(guichet.getNumGuichet());
		guichet.setEnCours(ticket);
		guichet.setDispo(false);
	}

	public Ticket getDernierTraite(){
		for (int i=t.size()-1;i>=0;i--){
			if(t.get(i).getheureDebut()!=-1){
				return t.get(i);
			}
		}
		return null;
		}
	
	public int getNombreTicketsAttente(){
		int nombre=0;
		for(int i=0;i<t.size();i++){
			if(t.get(i).getheureDebut()==-1){
				nombre++;
			}
		}
		return nombre;
	}
	
	public int getTempsMoyenAttente(){
		int temps=0;
		int nombreT=0;
		for (int i=0; i<t.size();i++){
				if(t.get(i).getheureDebut()!=-1){
					temps=temps+t.get(i).calculDuree();
					nombreT++;
			}
		}
		if(nombreT!=0){
		return (int)temps/nombreT;}
		else{
			return 0;
		}
		}
	public void chargerGuichets(){
		List<Guichet>total=new ArrayList<Guichet>();
		try {
			total=CreateDAO.getGuichetDAO().export();
			System.out.println("Test2");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Test3");
		}
		
		for(int i=0; i<total.size();i++){
			if(total.get(i).getIdService()==idService){
				System.out.println("Test");
				System.out.println(total.get(i).getIdService());
				g.add(total.get(i));
			}
		}
	}
	
	public void chargerTickets(){
		List<Ticket>total=new ArrayList<Ticket>();
		String date = FonctionsUtiles.dateToString(new Date());
		try {
			total=CreateDAO.getTicketDAO().export();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0; i<total.size();i++){
			if((total.get(i).getidService()==idService)&&(date.equals(total.get(i).toString(total.get(i).getDate())))){
				t.add(total.get(i));
			}
		}
	}
	
}

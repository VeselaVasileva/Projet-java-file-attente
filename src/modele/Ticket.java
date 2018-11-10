package modele;

import java.util.Date;

public class Ticket {
		private long idTicket;
		private long idService;
		private String [] date = new String[8];
		private int numGuichet;
		private String [] debut = {"",""};
		private String [] fin = {"",""};
	
		
		public Ticket(){}
		
		public Ticket(long idService) {
			this.idService=idService;
			date = FonctionsUtiles.decouper(new Date().toString(),"   ::  ");
			numGuichet = 0;
		}
		
		public Ticket(Service s) {
			this.idService=s.getIdService();
			date = FonctionsUtiles.decouper(new Date().toString(),"   ::  ");
			numGuichet = 0;
			s.t.add(this);
		}
		
		public Ticket(long idTicket, int numGuichet, String date, String debut, String fin, int idService) {
			this.idTicket=idTicket;
			this.idService=idService;
			this.date = FonctionsUtiles.decouper(date, "      ");
			this.debut = FonctionsUtiles.decouper(debut, " ");
			this.fin = FonctionsUtiles.decouper(fin, " ");
			this.numGuichet = numGuichet;
		}
		
		public long getIdTicket(){
			return this.idTicket;
		}
		public long getidService() {
			return this.idService;
		}
		
		public void setidService(int idService){
			this.idService=idService;
		}
		
		public String[] getDate(){
			return this.date;
		}
		
		public void setDate(String[]date){
			this.date=date;
		}
		
		public int getnumGuichet(){
			return this.numGuichet;
		}

		public void setnumGuichet(int nGuichet){
			this.numGuichet=nGuichet;
		}
		
		public String[] getDebut(){
			return this.debut;
		}
		
		public void setDebut(String[]debut){
			this.debut=debut;
		}

		public String[] getFin(){
			return this.fin;
		}
		
		public void setFin(String[]fin){
			this.fin=fin;
		}
		
		public int getJour(){
			return Integer.parseInt(date[3]);
		}
		 public int getMois(){
			 return FonctionsUtiles.Mois(date[1]);
		 }
		
		public int getAnnee(){
			return Integer.parseInt(date[7]);
		}
		public int getheureDebut(){
			if(debut[0]!=""){
				return Integer.parseInt(debut[0]);
			}
			else {return -1;}
		}
		
		public void setheureDebut (String hDebut){
			this.debut[0]=hDebut;
		}
		public int getminDebut(){
			if(debut[1]!=""){
				return Integer.parseInt(debut[1]);}
			else {return -1;}
		}
		
		public void setminDebut (String minDebut){
			this.debut[1]=minDebut;
		}
		public int getheureFin(){
			if(debut[0]!=null){
				return Integer.parseInt(fin[0]);}
			else{return -1;}
		}

		public void setheureFin (String hFin){
			this.fin[0]=hFin;
		}
		public int getminFin(){
			if(fin[1]!=null){
				return Integer.parseInt(fin[1]);}
			else{return -1;}
		}
		
		public void setminFin(String minFin){
			this.debut[1]=minFin;
		}
		
		public static String toString(String[]tab){
			String s="";
			for(int i=0;i<tab.length-1;i++){
				s=s+tab[i]+" ";
			}
			return s+tab[tab.length-1];
		}
	
		/*public void setnomService(String nomService) {
			this.nomService = nomService;
		}**/
		
		/*public int getNumDansFile(){
			return service.numNvxTicket(this);
		}**/

		public int calculDuree(){
			return this.getheureFin()*60+this.getminFin()-this.getheureDebut()*60-this.getminFin();
		}
	
		public int getNumFile(Service s){
			return s.t.indexOf(this);
		}
		
		public String dateToString(){
			String str="";
			for(int i=0;i<date.length;i++){
				str=date[i]+" ";
			}
			return str;
		}
		
		public String heureDebutToString(){
			return debut[0]+" "+debut[1];
		}
		
		public String heureFinToString(){
			return fin[0]+" "+fin[1];
		}
}
	

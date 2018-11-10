package modele;

import java.util.Date;

public class FonctionsUtiles {
	public static String[] decouper(String source, String separateurs) {
		if((source==null)||(separateurs==null)){
			throw new NullPointerException();
		}
		else{
			String [] tab;
			if(separateurs.equals("")){
				tab=new String [1];
				tab[0]=source;
			}
			else{
				tab=new String[separateurs.length()+1];
				int indice;
				String sep;
				
				for(int i=0; i<tab.length-1;i++){
					if(i+1<separateurs.length()){
						sep=separateurs.substring(i,i+1);
					}
					else{
						sep=separateurs.substring(i);
					}
					indice = source.indexOf(sep);
					if(indice==-1){
						throw new IllegalArgumentException();
					}
					else{
						tab[i]=source.substring(0,indice);
						source=source.substring(indice+1);
					
					}
				}
				tab[tab.length-1]=source;
		
				
			}
			return tab;	
		}
			
	}
	
	

	public int getJourSemaine(String jour){
		switch (jour){
		case "Mon":return 1;
		case "Tue":return 2;
		case "Wed":return 3;
		case "Thu":return 4;
		case "Fri":return 5;
		case "Sat":return 6;
		case "Sun":return 7;
		}
		return 0;
				
	}
	
	public static int Mois(String mois){
		switch (mois){
		case "Jan":return 1;
		case "Feb":return 2;
		case "Mar":return 3;
		case "Apr":return 4;
		case "May":return 5;
		case "Jun":return 6;
		case "Jul":return 7;
		case "Aug":return 8;
		case "Sept":return 9;
		case "Oct":return 10;
		case "Nov":return 11;
		case "Dec":return 12;
		}
		return 0;
	}
	
	public static String dateToString (Date date){
		String [] dateTab = new String[8];
		dateTab = FonctionsUtiles.decouper(date.toString(),"   ::  ");
		String s="";
		for(int i=0;i<dateTab.length-1;i++){
			s=s+" "+dateTab[i];
		}
		return s+dateTab[dateTab.length-1];
		
	}
}

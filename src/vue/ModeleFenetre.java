package vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Observer.Observable;
import Observer.Observer;
import modele.Administration;
import modele.Service;


public class ModeleFenetre extends JFrame implements Observer{

			private JMenuBar menu = null;
			private JMenuItem accueil=null;
			private JMenu services =null;
			private ArrayList<JMenuItem> itemsServices = new ArrayList<JMenuItem>();
			private JMenuItem stats=null;
			private JMenuItem quitter=null;
			private JPanel conteneur = new JPanel();
			private Dimension size;
			private Observable administration;
			
			public ModeleFenetre (Observable adm){
				this.administration=adm;
				this.administration.addObserver(this);
				this.setTitle("Gestion des files d'attente");
			    this.setSize(900, 600);
			    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    this.setLocationRelativeTo(null);
			    this.setResizable(true);
			    
			    this.size = new Dimension(this.getWidth(), this.getHeight());
			    this.conteneur.setPreferredSize(this.size);
			    this.conteneur.setBackground(Color.white);
			    this.conteneur.add(new FenetreAccueil(this.size,this.administration).getPanel()); 
			    
			    menu = new JMenuBar();
			    accueil=new JMenuItem("Accueil");
			    stats=new JMenuItem("Statistiques");
			    quitter=new JMenuItem("Quitter");
			    services = new JMenu("Sevrices");
			   
			    
			    menu.add(accueil);
			    menu.add(services);
			    menu.add(stats);
			    menu.add(quitter);
			    
			   
			    
			    
			   for (int i=0;i<administration.getListeServices().size();i++){
			    	itemsServices.add(new JMenuItem (administration.getListeServices().get(i).getNomService()));
			    	
			    for(int j=0;j<itemsServices.size();j++){
			    		services.add(itemsServices.get(j));
			    		itemsServices.get(j).addActionListener(new chngtPageService(administration.getListeServices().get(i)));
			    };}
			   
			    accueil.addActionListener(new retourAccueil());
			    quitter.addActionListener(new ActionListener(){
			    	public void actionPerformed(ActionEvent e){
			    		System.exit(0);
			    	}});
			    stats.addActionListener(new StatsListener());
			    
			     this.setJMenuBar(menu);
			     this.setContentPane(this.conteneur);
			     this.pack();
			    }
			
			
			class chngtPageService implements ActionListener{
				private final Service s;
				chngtPageService(Service service){
					s=service;
				}
				@Override
				public void actionPerformed(ActionEvent arg0) {
					conteneur.removeAll();
	    			ServicePanel sp=new ServicePanel(size,administration,s);
	    			administration.addObserver(sp);
	    			conteneur.add(sp.getPanel());
	    			conteneur.revalidate();
					
				}
			}
			class retourAccueil implements ActionListener{
				
				public void actionPerformed(ActionEvent arg0) {
					conteneur.removeAll();
	    			FenetreAccueil ap= new FenetreAccueil(size,administration);
	    			administration.addObserver(ap);
	    			conteneur.add(ap.getPanel());
	    			conteneur.revalidate();
					
				}
			
			}
			class StatsListener implements ActionListener{
				
				public void actionPerformed(ActionEvent arg0) {
					conteneur.removeAll();
	    			StatsPanel sp= new StatsPanel(size,administration);
	    			administration.addObserver(sp);
	    			conteneur.add(sp.getPanel());
	    			conteneur.revalidate();
					
				}
		  }
		//	@Override
		//	public void update(String nomService, int numGuihet, String dispoGuichet, int numTicket, int nbrePersonnes,
		//			int tempsAttente) {
				// TODO Auto-generated method stub
			@Override
			public void update() {
				// TODO Auto-generated method stub
				
			}
				
			}


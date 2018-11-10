package vue;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import Controleur.Controler;
import Observer.Observable;
import Observer.Observer;
import modele.Service;

public class StatsPanel extends ZoneCentrale implements Observer{
	private DateFormat df = new SimpleDateFormat("yyyy/mm/dd");

	private Observable administration;
	private Service service;
	private JButton boutonValider;
	private JLabel dateDebutLabel;
	private JLabel dateFinLabel;
	private JLabel resultatsLabel;
	private JFormattedTextField dateDebut;
	private JFormattedTextField dateFin;
	private JTable resultats;
	Controler control;
	
	public StatsPanel(Dimension dim, Observable obs) {
		super(dim);
		this.administration=obs;
		control=new Controler(administration);
		initPanel();
	}
	
	
	public void initPanel(){
		this.panel.setLayout(new GridBagLayout());
		GridBagConstraints cg = new GridBagConstraints();
		cg.insets=new Insets(10,10,10,10);
		
		boutonValider=new JButton("Valider");
		dateDebutLabel=new JLabel("Date de début");
		dateFinLabel=new JLabel("Date de fin");
		resultatsLabel=new JLabel("Resultats");
		dateDebut=new JFormattedTextField(df);
		dateFin=new JFormattedTextField(df);
		resultats=new JTable();
		JLabel nom = new JLabel(service.getNomService());
		this.panel.add(nom,cg);}
		/*for(int j=0;j< service.getGuichets().size();j++){
			cg.gridy=j+1;
			cg.gridx=0;
			this.panel.add(new JLabel("Guichet N°"+service.getGuichets().get(j).getNumGuichet()));
			cg.gridx=1;
			this.panel.add(new JLabel(service.getGuichets().get(j).afficherDispo()));
			cg.gridx=2;
			this.panel.add(new JLabel("Ticket N°"+service.getNumTicket(service.getGuichets().get(j).getEnCours())));
			
		}**/
	/*	boutonAjout=new JButton("Ajouter un guichet");
		cg.gridx=0;
		cg.gridy=service.getGuichets().size()+1;
		this.panel.add(boutonAjout,cg);
		boutonAjout.addActionListener(new ActionListener(){**/

	/*	@Override
			public void actionPerformed(ActionEvent e) {
    			vueAjoutGuichet ajoutGuichet = new vueAjoutGuichet(administration);
    			administration.addObserver(ajoutGuichet);
    			ajoutGuichet.setVisible(true);	
			}
		});
	}
	}**/


	/*		public void update(String nomService, int numGuihet, String dispoGuichet, int numTicket, int nbrePersonnes,
					int tempsAttente) {
				// TODO Auto-generated method stub
				
			}**/


			@Override
			public void update() {
				// TODO Auto-generated method stub
				
			}
}
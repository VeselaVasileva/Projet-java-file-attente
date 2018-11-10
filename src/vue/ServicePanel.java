package vue;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import Observer.Observable;
import Observer.Observer;
import modele.Service;


public class ServicePanel extends ZoneCentrale implements Observer {

	Observable administration;
	Service service;
	JButton boutonAjout;
	public ServicePanel(Dimension dim, Observable obs, Service s) {
		super(dim);
		this.administration=obs;
		this.service=s;
		initPanel();
		// TODO Auto-generated constructor stub
	}
	@Override
	protected void initPanel() {
		
		this.panel.setLayout(new GridBagLayout());
		GridBagConstraints cg = new GridBagConstraints();
		cg.insets=new Insets(10,10,10,10);
		JLabel nom = new JLabel(service.getNomService());
		this.panel.add(nom,cg);
		for(int j=0;j< service.getGuichets().size();j++){
			cg.gridy=j+1;
			cg.gridx=0;
			this.panel.add(new JLabel("Guichet N°"+service.getGuichets().get(j).getNumGuichet()));
			cg.gridx=1;
			this.panel.add(new JLabel(service.getGuichets().get(j).afficherDispo()));
			cg.gridx=2;
			this.panel.add(new JLabel("Ticket N°"+service.getNumTicket(service.getGuichets().get(j).getEnCours())));
			JButton ouvrirGuichet=new JButton("Ouvrir");
			this.panel.add(ouvrirGuichet);
			//ouvrirGuichet.addActionListener(new Ouverture(j,service));
			
			
			}
		
		class Ouverture implements ActionListener{
			int num;
			Service service;
			Ouverture(int num, Service s){
				this.num=num;
				service=s;
			}
			public void actionPerformed(ActionEvent e) {
				for (int i=0; i<service.g.size();i++){
					if(service.g.get(i).getNumGuichet()==num){
						service.g.get(i).ouvrir();
					}
				}
				fenetreGuichet guichet = new fenetreGuichet(administration);
				administration.addObserver(guichet);
				guichet.setVisible(true);
		}
		
	
	}
		boutonAjout=new JButton("Ajouter un guichet");
		cg.gridx=0;
		cg.gridy=service.getGuichets().size()+1;
		this.panel.add(boutonAjout,cg);
		boutonAjout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
    			vueAjoutGuichet ajoutGuichet = new vueAjoutGuichet(administration);
    			administration.addObserver(ajoutGuichet);
    			ajoutGuichet.setVisible(true);	
			}
		});
	}

	/**@Override
	public void update(String nomService, int numGuihet, String dispoGuichet, int numTicket, int nbrePersonnes,
			int tempsAttente) {
		// TODO Auto-generated method stub
		
	}**/
	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}

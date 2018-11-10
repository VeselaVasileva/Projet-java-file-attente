package vue;


import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Observer.Observable;
import Observer.Observer;

public class vueAjoutService extends fenetreSaisie implements Observer {
	
	private Observable administration;
	private JButton boutonAjout;
	private JTextField nomService;
	private JLabel etiquette;
	private JPanel conteneur = new JPanel();
	
	public vueAjoutService(Observable obs) {
		
		super(obs);
		administration=obs;
		this.administration.addObserver(this);
		initPanel();
		
	    
	}
	
	
	
	public JTextField getFieldNomService(){
		return this.nomService;
	}
	
	public void setFieldNomService(JTextField nomS){
		this.nomService=nomS;
	}
	
	public JPanel getConteneur(){
		return this.conteneur;
	}
	
	public void setFieldNomService(JPanel cont){
		this.conteneur=cont;
	}
	
	protected void initPanel() {
		this.setTitle("Nouveau Service");
	    this.setSize(400, 100);
	    
	    boutonAjout=new JButton("Enregistrer");
	    nomService=new JTextField(20);
	    etiquette=new JLabel("Nom Service");
	    
		GridBagConstraints cc = new GridBagConstraints();
		cc.insets = new Insets(10, 10, 10, 10);
	    cc.gridx=1; 
	    conteneur.add(etiquette,cc);
	    cc.gridx=2;
	    conteneur.add(nomService,cc);
	    cc.gridx=0;
	    cc.gridy=2;
	    conteneur.add(boutonAjout);
	    this.setContentPane(this.conteneur);
	    
	    boutonAjout.addActionListener(new AjouterService(this, new FenetreAccueil(new Dimension(600,600),this.administration)));
	    
	}

	public void fermer(){
		this.dispose();
	}
	
	class AjouterService implements ActionListener{
		boolean existant=false;
		FenetreAccueil accueil;
		AjouterService(vueAjoutService vue, FenetreAccueil fen){
			accueil=fen;
		}
		public void actionPerformed(ActionEvent e) {
			controler.controlAjoutService(nomService.getText());
			fermer();
			accueil.panel.revalidate();
			
			
		
		}
		
	}

/*	@Override
	public void update(String nomService, int numGuihet, String dispoGuichet, int numTicket, int nbrePersonnes,
			int tempsAttente) {
		// TODO Auto-generated method stub
		
	}**/



	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}

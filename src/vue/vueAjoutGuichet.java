package vue;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Observer.Observable;
import Observer.Observer;

public class vueAjoutGuichet extends fenetreSaisie implements Observer {
	private Observable administration;
	private JButton boutonAjout;
	private JTextField numGuichet;
	private JLabel etiquette1,etiquette2;
	
	private JComboBox<String> comboBoxService;
	private JPanel conteneur = new JPanel();
	
	public vueAjoutGuichet(Observable obs) {
		
		super(obs);
		administration=obs;
		this.administration.addObserver(this);
		initPanel();
		
	    
	}
	
	
	
	public JTextField getFieldNomService(){
		return this.numGuichet;
	}
	
	public void setFieldNomService(JTextField nomG){
		this.numGuichet=nomG;
	}
	
	public JPanel getConteneur(){
		return this.conteneur;
	}
	
	public void setFieldNomService(JPanel cont){
		this.conteneur=cont;
	}
	
	protected void initPanel() {
		this.setTitle("Nouveau Guichet");
	    this.setSize(400, 100);
	    
	    boutonAjout=new JButton("Enregistrer");
	    numGuichet=new JTextField(20);
	    etiquette1=new JLabel("Guichet N°");
	    etiquette2=new JLabel("Choisir le service");
	    comboBoxService=new JComboBox<String>();
	    for(int i=0;i<administration.getListeServices().size();i++){
	    	comboBoxService.addItem(administration.getListeServices().get(i).getNomService());
	    }
	  
		GridBagConstraints cc = new GridBagConstraints();
		cc.insets = new Insets(10, 10, 10, 10);
	    cc.gridx=1; 
	    conteneur.add(etiquette1,cc);
	    cc.gridx=2;
	    conteneur.add(numGuichet,cc);
	    cc.gridy=1;
	    cc.gridx=0;
	    conteneur.add(etiquette2,cc);
	    cc.gridy=1;
	    cc.gridx=0;
	    conteneur.add(comboBoxService);
	    cc.gridx=0;
	    cc.gridy=2;
	    conteneur.add(boutonAjout);
	    this.setContentPane(this.conteneur);
	    
	    boutonAjout.addActionListener(new AjouterGuichet(this));
	    
	}


	public void fermer(){
		this.dispose();
	}
	
	class AjouterGuichet implements ActionListener{
		boolean existant=false;
		AjouterGuichet(vueAjoutGuichet vue){
		}
		public void actionPerformed(ActionEvent e) {
			controler.controlAjoutGuichet(numGuichet.getText(),comboBoxService.getSelectedItem().toString());
			fermer();
			
			
		
		}
		
	}

	/*@Override
	public void update(String nomService, int numGuihet, String dispoGuichet, int numTicket, int nbrePersonnes,
			int tempsAttente) {
		// TODO Auto-generated method stub
		
	}**/



	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}

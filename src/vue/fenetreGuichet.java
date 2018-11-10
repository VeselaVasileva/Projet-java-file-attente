package vue;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Observer.Observable;
import Observer.Observer;


public class fenetreGuichet extends JFrame implements Observer{
	protected JPanel conteneur;
	private Observable administration;
	protected JButton boutonSuivant;
	protected JButton boutonMeme;
	protected JButton boutonPrecedent;
	protected JLabel nbreAttente;
	
	
	
	public fenetreGuichet(Observable obs){
		this.conteneur=new JPanel();
		this.conteneur.setBackground(Color.white);
	    this.setLocationRelativeTo(null);
	    this.setResizable(true);
	    setLayout(new GridBagLayout());
		administration=obs;
		this.administration.addObserver(this);
		initPanel();
	}
	
	
	 public void initPanel(){
		 this.setTitle("Guichet");
		    this.setSize(400, 100);
		    
		    boutonSuivant=new JButton("Suivant");
			boutonMeme=new JButton("Meme");
			boutonPrecedent=new JButton("Precedent");
			nbreAttente = new JLabel();

			
			GridBagConstraints cc = new GridBagConstraints();
			cc.insets = new Insets(30, 30, 30, 30);
			this.conteneur.add(nbreAttente,cc);
		    cc.gridy=1; 
		    this.conteneur.add(boutonPrecedent,cc);
		    cc.gridx=1;
		    conteneur.add(boutonMeme,cc);
		    cc.gridy=2;
		    conteneur.add(boutonSuivant,cc);
		    
		    this.setContentPane(this.conteneur);
		    
		    boutonSuivant.addActionListener(new Suivant(administration));
		    boutonMeme.addActionListener(new Meme(administration));
		    boutonPrecedent.addActionListener(new Precedent(administration));
		 
	 }
	class Suivant implements ActionListener{
		Observable administration;
		Suivant(Observable obs){
			administration=obs;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
	}
	
	class Meme implements ActionListener{
		Observable administration;
		Meme(Observable obs){
			administration=obs;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
		}
	}
	
	class Precedent implements ActionListener{
		Observable administration;
		Precedent(Observable obs){
			administration=obs;
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			
			
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

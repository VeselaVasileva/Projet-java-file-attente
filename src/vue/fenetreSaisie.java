package vue;

import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Controleur.Controler;
import Observer.Observable;

public abstract class fenetreSaisie extends JFrame{		
		//private Observable administration;
		
		protected JPanel conteneur;
		protected Controler controler;
		
		public fenetreSaisie(Observable obs) {
			controler = new Controler(obs);
			this.conteneur = new JPanel();
			this.conteneur.setBackground(Color.white);
		    this.setLocationRelativeTo(null);
		    this.setResizable(true);
		    setLayout(new GridBagLayout());}
		  

		    
		
protected abstract void initPanel();
public abstract JPanel getConteneur();


}

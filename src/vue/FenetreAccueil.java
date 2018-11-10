package vue;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

import Observer.Observable;
import Observer.Observer;

public class FenetreAccueil extends ZoneCentrale implements Observer{
	
	private Observable administration;
	public FenetreAccueil(Dimension dim, Observable obs){
		super(dim);
		this.administration=obs;
		initPanel();
		
	}

	public void initPanel(){
		this.panel.setLayout(new GridBagLayout());
		GridBagConstraints cc = new GridBagConstraints();
		cc.insets = new Insets(10, 10, 10, 10);
		JButton boutonAjout= new JButton("Ajouter");
	

		for(int i=0;i<administration.getListeServices().size();i++){
				cc.gridy=i;
				cc.gridx=0;
				JPanel pannelEnsemble = new JPanel();
				this.panel.add(pannelEnsemble,cc);
				panel.setBackground(Color.blue);
				pannelEnsemble.setLayout(new GridBagLayout());
				GridBagConstraints ce = new GridBagConstraints();
				
				ce.gridx=0;
				ce.gridy=0;
				JPanel pannelService = new JPanel();
				pannelEnsemble.add(pannelService,ce);
				pannelEnsemble.setBackground(Color.green);
				pannelService.setLayout(new GridBagLayout());
				GridBagConstraints cs = new GridBagConstraints();
				cs.insets = new Insets(5,5,5,5);
				
				cs.gridx=0;
				cs.gridy=0;
				pannelService.add(new JLabel(administration.getListeServices().get(i).getNomService()),cs);
				cs.gridy=1;
				cs.gridx=0;
				pannelService.add(new JLabel("Personnes en attente : "+administration.getListeServices().get(i).getNombreTicketsAttente()),cs);
				cs.gridx=1;
				pannelService.add(new JLabel("Temps attente : "+administration.getListeServices().get(i).getTempsMoyenAttente()+" min"),cs);
				
				ce.gridx=0;
				ce.gridy=1;
				JPanel pannelGuichets = new JPanel();
				pannelEnsemble.add(pannelGuichets, ce);
				pannelGuichets.setLayout(new GridBagLayout());
				GridBagConstraints cg = new GridBagConstraints();
				cg.insets=new Insets(10,10,10,10);
				for(int j=0;j< administration.getListeServices().get(i).getGuichets().size();j++){
					cg.gridy=j;
					cg.gridx=0;
					pannelGuichets.add(new JLabel("Guichet N°"+administration.getListeServices().get(i).getGuichets().get(j).getNumGuichet()),cg);
					cg.gridx=1;
					pannelGuichets.add(new JLabel(administration.getListeServices().get(i).getGuichets().get(j).afficherDispo()),cg);
					cg.gridx=2;
					pannelGuichets.add(new JLabel("Ticket N°"+administration.getListeServices().get(i).getNumTicket(administration.getListeServices().get(i).getGuichets().get(j).getEnCours())),cg);
					
				}
				
			}
		System.out.println("Test2");
		cc.gridx=0;
		cc.gridy=administration.getListeServices().size()+1;
		this.panel.add(boutonAjout,cc);
		boutonAjout.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
    			vueAjoutService ajoutService = new vueAjoutService(administration);
    			administration.addObserver(ajoutService);
    			ajoutService.setVisible(true);
				panel.revalidate();
			}
				
				
		});
	}


	@Override
	public void update() {
		
		System.out.println("Test1");
		initPanel();
		System.out.println("Test3");
	}
	
}

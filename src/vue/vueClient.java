package vue;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import Observer.Observable;
import Observer.Observer;
import modele.Ticket;
import sauvegarde.CreateDAO;

public class vueClient extends JFrame implements Observer{
		
		protected JPanel conteneur;
		private Observable administration;
		protected JButton boutonSuivant;
		protected JButton boutonMeme;
		protected JButton boutonPrecedent;
		protected JLabel nbreAttente;
		
		
		
		public vueClient(Observable obs){
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
			 this.setTitle("Bienvenue");
			 this.setSize(400, 400);
			    
			    
				
				
				this.conteneur.setLayout(new GridBagLayout());
				GridBagConstraints cc = new GridBagConstraints();
				cc.insets = new Insets(30, 30, 30, 30);
				
				for(int i=0;i<administration.getListeServices().size();i++){
					JButton service=new JButton(administration.getListeServices().get(i).getNomService());
					cc.gridy=i;
					cc.gridx=0;
					
					this.conteneur.add(service,cc);
					service.addActionListener(new NouveauTicket(administration,administration.getListeServices().get(i).getIdService()));

					 this.setContentPane(this.conteneur);
				}
				
		 }
		 
		 class NouveauTicket implements ActionListener{
			 Observable admin;
			 long id;
			 NouveauTicket (Observable obs,long id){
				 this.admin=obs;
				 this.id=id;
			 }

				@Override
				public void actionPerformed(ActionEvent e) {
					for(int i=0;i<admin.getListeServices().size();i++){
						if(admin.getListeServices().get(i).getIdService()==id){
							Ticket ticket = new Ticket(admin.getListeServices().get(i));
							JOptionPane.showConfirmDialog(null,""+admin.getListeServices().get(i).getNomService()+" - Ticket N°:"+admin.getListeServices().get(i).getNumTicket(ticket)+" - Temps moyen attente"+admin.getListeServices().get(i).getTempsMoyenAttente(),"Votre ticket",JOptionPane.PLAIN_MESSAGE);
								try {
									CreateDAO.createTicket(ticket);
								} catch (SQLException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
						}
					}
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
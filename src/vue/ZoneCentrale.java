package vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

public abstract class ZoneCentrale {
protected JPanel panel;
	
	protected Font calibri = new Font("Calibri",Font.PLAIN,14);
	protected Font arial = new Font("Arial", Font.BOLD, 15);
	protected Font dialog = new Font("Dialog", Font.BOLD + Font.ITALIC, 15);
	
	public ZoneCentrale(Dimension dim){
		this.panel = new JPanel();
		this.panel.setPreferredSize(dim);
		this.panel.setBackground(Color.white);
		
		
	}
	
	protected JPanel getPanel(){
		return this.panel;
	}
	
	protected abstract void initPanel();

}

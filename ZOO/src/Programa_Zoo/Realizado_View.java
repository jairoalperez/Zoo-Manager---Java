package Programa_Zoo;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Realizado_View {

	private JPanel panel;
	private JLabel label;
	private JButton atras;
	
	public Realizado_View(){
	
		this.panel = new JPanel();
		
		this.atras = new JButton ("Inicio");
		this.atras.setBounds(1, 1, 75, 50);
		this.atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent d) {
				Base_View base = new Base_View();
	            IG.vista.setContentPane(base.getbase());
	            IG.vista.invalidate();
	        	IG.vista.validate();
	        }
	    });
		this.panel.add(atras);
		
		this.label = new JLabel("Realizado.");
		this.label.setFont(new Font("Tahoma", Font.BOLD, 25));
		this.label.setBounds(225, 225, 200, 100);
		this.panel.add(label);
	
	this.panel.setSize(500, 500);
	this.panel.setLayout(null);
	this.panel.setVisible(true);

}

public JPanel getlisto() {
	return this.panel;
}



	

}

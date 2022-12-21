package Programa_Zoo;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Temp_View extends JFrame {

	//Attributes
		private JPanel panel;
		private JLabel label;
		
		private JButton bpac;
		private JButton bagr;
		private JButton atras;
		
		//Constructor
		public Temp_View(){
			this.panel = new JPanel();
			
			this.label = new JLabel("Temperamento");
			this.label.setBounds(200, 25, 100, 50);
			this.panel.add(label);
			
			this.atras = new JButton ("Atras");
			this.atras.setBounds(1, 1, 75, 50);
			this.atras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent d) {
					Buscar_View base = new Buscar_View();
		            IG.vista.setContentPane(base.getPanelbuscar());
		            IG.vista.invalidate();
		        	IG.vista.validate();
		        }
		    });
			this.panel.add(atras);
			
			this.bagr = new JButton ("Agresivos");
			this.bagr.setBounds(25, 200, 200, 100);
			this.bagr.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent d) {
		        	Agresivo_View agv = new Agresivo_View();
		        	IG.vista.setContentPane(agv.getagr());
		        	IG.vista.invalidate();
		        	IG.vista.validate();
		        }
		    });
			this.panel.add(bagr);
			
			this.bpac = new JButton ("Pacificos");
			this.bpac.setBounds(250, 200, 200, 100);
			this.bpac.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent d) {
		        	Pacifico_View pv = new Pacifico_View();
		        	IG.vista.setContentPane(pv.getpac());
		        	IG.vista.invalidate();
		        	IG.vista.validate();
				 }
		    });
			this.panel.add(bpac);
		
		this.panel.setSize(500, 500);
		this.panel.setLayout(null);
		this.panel.setVisible(true);
}
		
		public JPanel gettem() {
			return this.panel;
		}
}
		
		
		
		
	
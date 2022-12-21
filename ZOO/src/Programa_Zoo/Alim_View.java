package Programa_Zoo;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Alim_View extends JFrame {

	//Attributes
		private JPanel panel;
		private JLabel label;
		private JButton bher;
		private JButton bcar;
		private JButton bom;
		private JButton atras;
		
		//Constructor
		public Alim_View(){
			this.panel = new JPanel();
			
			this.label = new JLabel("Alimentacion");
			this.label.setBounds(200, 50, 100, 50);
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
			
			this.bher = new JButton ("Herbivoros");
			this.bher.setBounds(25, 150, 200, 100);
			this.bher.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent d) {
		        	Herbivoro_View hv = new Herbivoro_View();
		        	IG.vista.setContentPane(hv.gether());
		        	IG.vista.invalidate();
		        	IG.vista.validate();
		        }
		    });
			this.panel.add(bher);
			
			this.bcar = new JButton ("Carnivoros");
			this.bcar.setBounds(250, 150, 200, 100);
			this.bcar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent d) {
		        	Carnivoro_View vv = new Carnivoro_View();
		        	IG.vista.setContentPane(vv.getcar());
		        	IG.vista.invalidate();
		        	IG.vista.validate();
				 }
		    });
			this.panel.add(bcar);
			
			this.bom = new JButton ("Omnivoros");
			this.bom.setBounds(137, 260, 200, 100);
			this.bom.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent d) {
		        	Omnivoro_View ov = new Omnivoro_View();
		        	IG.vista.setContentPane(ov.getom());
		        	IG.vista.invalidate();
		        	IG.vista.validate();
				 }
		    });
			this.panel.add(bom);
			
			this.panel.setSize(500, 500);
			this.panel.setLayout(null);
			this.panel.setVisible(true);
			
		}
		
		public JPanel getalim() {
			return this.panel;
		}
	}

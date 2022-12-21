package Programa_Zoo;

import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Hab_View extends JFrame {

	//Attributes
		private JPanel panel;
		private JLabel label;
		
		private JButton baer;
		private JButton bsem;
		private JButton bterr;
		private JButton atras;
		
		//Constructor
		public Hab_View(){
			this.panel = new JPanel();
	
			this.label = new JLabel("Habitat");
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
			
			this.baer = new JButton ("Aereo");
			this.baer.setBounds(25, 150, 200, 100);
			this.baer.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent d) {
		        	Aereo_View aev = new Aereo_View();
		        	IG.vista.setContentPane(aev.getaer());
		        	IG.vista.invalidate();
		        	IG.vista.validate();
		        }
		    });
			this.panel.add(baer);
			
			this.bsem = new JButton ("Semiacuatico");
			this.bsem.setBounds(250, 150, 200, 100);
			this.bsem.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent d) {
		        	Semiacuatico_View smv = new Semiacuatico_View();
		        	IG.vista.setContentPane(smv.getsem());
		        	IG.vista.invalidate();
		        	IG.vista.validate();
				 }
		    });
			this.panel.add(bsem);
			
			this.bterr = new JButton ("Terrestre");
			this.bterr.setBounds(137, 260, 200, 100);
			this.bterr.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent d) {
		        	Terrestre_View trv = new Terrestre_View();
		        	IG.vista.setContentPane(trv.getterr());
		        	IG.vista.invalidate();
		        	IG.vista.validate();
				 }
		    });
			this.panel.add(bterr);
			
			this.panel.setSize(500, 500);
			this.panel.setLayout(null);
			this.panel.setVisible(true);
		}
		
		public JPanel gethab() {
			return this.panel;
		}
	}

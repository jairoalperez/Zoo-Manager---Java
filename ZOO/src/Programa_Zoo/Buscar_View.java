package Programa_Zoo;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JViewport;
import javax.swing.RootPaneContainer;

public class Buscar_View extends JFrame{

	//Attributes
	private JPanel panelbus;
	private JLabel label;
	private JButton botonrep;
	private JButton botonalim;
	private JButton botontem;
	private JButton botonhab;
	private JButton atras;
	
	//Constructor
	public Buscar_View(){
		this.panelbus = new JPanel();
		
		this.label = new JLabel("Caracteristica");
		this.label.setBounds(200, 25, 100, 50);
		this.panelbus.add(label);
		
		this.atras = new JButton ("Atras");
		this.atras.setBounds(1, 1, 75, 50);
		this.atras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent d) {
				Base_View base = new Base_View();
	            IG.vista.setContentPane(base.getbase());
	            IG.vista.invalidate();
	        	IG.vista.validate();
	        }
	    });
		this.panelbus.add(atras);
		
		this.botonrep = new JButton ("Tipo de Reproduccion");
		this.botonrep.setBounds(25, 100, 200, 100);
		this.botonrep.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent d) {
	        	Rep_View rv = new Rep_View();
	        	IG.vista.setContentPane(rv.getrep());
	        	IG.vista.invalidate();
	        	IG.vista.validate();
	        }
	    });
		this.panelbus.add(botonrep);
		
		this.botonalim = new JButton ("Tipo de Alimentacion");
		this.botonalim.setBounds(250, 100, 200, 100);
		this.botonalim.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent d) {
	        	Alim_View alv = new Alim_View();
	        	IG.vista.setContentPane(alv.getalim());
	        	IG.vista.invalidate();
	        	IG.vista.validate();
	        }
	    });
		this.panelbus.add(botonalim);
		
		this.botontem = new JButton ("Tipo de Temperamento");
		this.botontem.setBounds(250, 250, 200, 100);
		this.botontem.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent d) {
	        	Temp_View rv = new Temp_View();
	        	IG.vista.setContentPane(rv.gettem());
	        	IG.vista.invalidate();
	        	IG.vista.validate();
	        }
	    });
		this.panelbus.add(botontem);
		
		this.botonhab = new JButton ("Tipo de Habitat");
		this.botonhab.setBounds(25, 250, 200, 100);
		this.botonhab.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent d) {
	        	Hab_View rv = new Hab_View();
	        	IG.vista.setContentPane(rv.gethab());
	        	IG.vista.invalidate();
	        	IG.vista.validate();
	        }
	    });
		this.panelbus.add(botonhab);
		
		this.panelbus.setSize(500, 500);
		this.panelbus.setLayout(null);
		this.panelbus.setVisible(true);
		
	}
	
	public JPanel getPanelbuscar() {
		return this.panelbus;
	}
}

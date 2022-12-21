package Programa_Zoo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Base_View extends JFrame{

	String tip = null, rep = null, alim = null, tem = null, hab = null;
	int cant = 0; 
	
Scanner scanner = new Scanner  (System.in);

protected JButton botonbuscar;
protected JButton botoningresar;
protected JButton botonchat;
protected JLabel label; 
protected JPanel panelbase;

public Base_View() {
	
	this.panelbase = new JPanel();
	
	this.label = new JLabel("Seleccione una opcion");
	this.label.setBounds(175, 75, 300, 50);
	this.panelbase.add(label);
	
	this.botonbuscar = new JButton("Buscar un animal");
	this.botonbuscar.setBounds(25, 200, 200, 50);
	this.botonbuscar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
        	Buscar_View bv = new Buscar_View();
        	IG.vista.setContentPane(bv.getPanelbuscar());
        	IG.vista.invalidate();
        	IG.vista.validate();
        }
    });
	this.panelbase.add(botonbuscar);
	
	this.botonchat = new JButton("Chat");
	this.botonchat.setBounds(137, 265, 200, 50);
	this.botonchat.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
        	Server_View chat = new Server_View();
        	IG.vista.setContentPane(chat.getchat());
        	IG.vista.invalidate();
        	IG.vista.validate();
        }
    });
	this.panelbase.add(botonchat);
	
	this.botoningresar = new JButton("Ingresar un animal");
	this.botoningresar.setBounds(250, 200, 200, 50);
	this.botoningresar.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e) {
        	Ingresar_View iv = new Ingresar_View();
        	IG.vista.setContentPane(iv.getJPanelingresar());
        	IG.vista.invalidate();
        	IG.vista.validate();
        }
    });
	this.panelbase.add(botoningresar);
	
	this.panelbase.setSize(500, 500);
	this.panelbase.setLayout(null);
	this.panelbase.setVisible(true);
}

public JPanel getbase() {
	return this.panelbase;
	
}
}
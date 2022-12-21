package Programa_Zoo;

import java.util.Scanner;

import Programa_Zoo.Buscar_View;
import Programa_Zoo.Ingresar_View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class IG extends JFrame{

public static JFrame vista;

protected JButton botoncomenzar;
protected JLabel label; 

public IG() {

	vista = new JFrame("ZOO");
	
	this.label = new JLabel("Bienvenido");
	this.label.setBounds(215, 50, 100, 50);
	this.vista.add(label);
	
	this.botoncomenzar = new JButton("Comenzar");
	this.botoncomenzar.setBounds(50, 150, 400, 200);
	this.botoncomenzar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
        	Base_View base = new Base_View();
        	IG.vista.setContentPane(base.getbase());
        	IG.vista.invalidate();
        	IG.vista.validate();
        }
    });
	this.vista.add(botoncomenzar);
	
	this.vista.setSize(500, 500);
	this.vista.setLayout(null);
	this.vista.setVisible(true);
	
}
}
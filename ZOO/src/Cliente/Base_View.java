package Cliente;

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

protected JButton botonchat;
protected JLabel label; 
protected JPanel panelbase;

public Base_View() {
	
	this.panelbase = new JPanel();
	
	this.label = new JLabel("Bienvenido");
	this.label.setBounds(215, 50, 100, 50);
	this.panelbase.add(label);
	
	this.botonchat = new JButton("Chat");
	this.botonchat.setBounds(100, 200, 300, 75);
	this.botonchat.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
        	Cliente_View chat = new Cliente_View();
        	IG.vista.setContentPane(chat.getchat());
        	IG.vista.invalidate();
        	IG.vista.validate();
        }
    });
	this.panelbase.add(botonchat);
	
	this.panelbase.setSize(500, 500);
	this.panelbase.setLayout(null);
	this.panelbase.setVisible(true);
}

public JPanel getbase() {
	return this.panelbase;
	
}
}

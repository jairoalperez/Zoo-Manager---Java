package Programa_Zoo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComboBox;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.JButton;

public class Ingresar_View extends JFrame {

	//Attributes
		private JPanel panel;
		private JLabel label;
		
		private JTextField tfnombre;
		private JTextField tfconsejo;
		private JTextField tfcan;
		
		private JButton blisto;
		private JButton atras;
		
		private JLabel lblnombre;
		private JLabel lblrep;
		private JLabel lblalim;
		private JLabel lbltem;
		private JLabel lblhab;
		private JLabel lblcan;
		private JLabel lblconsejo;
		
		private JCheckBox cboviparo;
		private JCheckBox cbviviparo;
		private JCheckBox cbcarnivoro;
		private JCheckBox cbomnivoro;
		private JCheckBox cbherbivoro;
		private JCheckBox cbpacifico;
		private JCheckBox cbagresivo;
		private JCheckBox cbsemiacuatico;
		private JCheckBox cbaereo;
		private JCheckBox cbterrestre;
		
		//Constructor
		public Ingresar_View(){
			this.panel = new JPanel();
			
			this.atras = new JButton ("Atras");
			this.atras.setBounds(1, 1, 50, 30);
			this.atras.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent d) {
					Base_View base = new Base_View();
		            IG.vista.setContentPane(base.getbase());
		            IG.vista.invalidate();
		        	IG.vista.validate();
		        }
		    });
			this.panel.add(atras);
			
			this.lblnombre = new JLabel("Nombre del Animal");
			this.lblnombre.setFont(new Font("Tahoma", Font.BOLD, 15));
			this.lblnombre.setBounds(73, 13, 141, 16);
			this.panel.add(lblnombre);
			
			this.tfnombre = new JTextField();
			this.tfnombre.setBounds(73, 42, 141, 22);
			this.panel.add(tfnombre);
			tfnombre.setColumns(10);
			
			this.lblrep = new JLabel("Reproduccion");
			this.lblrep.setFont(new Font("Tahoma", Font.BOLD, 15));
			this.lblrep.setBounds(194, 85, 107, 16);
			this.panel.add(lblrep);
			
			this.cboviparo = new JCheckBox("Oviparo");
			this.cboviparo.setFont(new Font("Tahoma", Font.PLAIN, 15));
			this.cboviparo.setBounds(127, 110, 86, 25);
			this.panel.add(cboviparo);
			
			this.cbviviparo = new JCheckBox("Viviparo");
			this.cbviviparo.setFont(new Font("Tahoma", Font.PLAIN, 15));
			this.cbviviparo.setBounds(270, 110, 113, 25);
			this.panel.add(cbviviparo);			
			
			this.lblalim = new JLabel("Alimentacion");
			this.lblalim.setFont(new Font("Tahoma", Font.BOLD, 15));
			this.lblalim.setBounds(194, 155, 100, 16);
			this.panel.add(lblalim);
			
			this.cbcarnivoro = new JCheckBox("Carnivoro");
			this.cbcarnivoro.setFont(new Font("Tahoma", Font.PLAIN, 15));
			this.cbcarnivoro.setBounds(73, 182, 113, 25);
			this.panel.add(cbcarnivoro);
			
			this.cbomnivoro = new JCheckBox("Omnivoro");
			this.cbomnivoro.setFont(new Font("Tahoma", Font.PLAIN, 15));
			this.cbomnivoro.setBounds(188, 183, 113, 25);
			this.panel.add(cbomnivoro);
			
			this.cbherbivoro = new JCheckBox("Herbivoro");
			this.cbherbivoro.setFont(new Font("Tahoma", Font.PLAIN, 15));
			this.cbherbivoro.setBounds(303, 183, 113, 25);
			this.panel.add(cbherbivoro);
			
			this.lbltem = new JLabel("Temperamento");
			this.lbltem.setFont(new Font("Tahoma", Font.BOLD, 15));
			this.lbltem.setBounds(188, 229, 113, 16);
			this.panel.add(lbltem);
			
			this.cbpacifico = new JCheckBox("Pacifico");
			this.cbpacifico.setFont(new Font("Tahoma", Font.PLAIN, 15));
			this.cbpacifico.setBounds(165, 254, 75, 25);
			this.panel.add(cbpacifico);
			
			this.cbagresivo = new JCheckBox("Agresivo");
			this.cbagresivo.setFont(new Font("Tahoma", Font.PLAIN, 15));
			this.cbagresivo.setBounds(244, 254, 86, 25);
			this.panel.add(cbagresivo);
			
			this.lblhab = new JLabel("Habitat");
			this.lblhab.setFont(new Font("Tahoma", Font.BOLD, 15));
			this.lblhab.setBounds(219, 299, 60, 16);
			this.panel.add(lblhab);
			
			this.cbsemiacuatico = new JCheckBox("Semiacuatico");
			this.cbsemiacuatico.setFont(new Font("Tahoma", Font.PLAIN, 15));
			this.cbsemiacuatico.setBounds(188, 324, 113, 25);
			this.panel.add(cbsemiacuatico);
			
			this.cbaereo = new JCheckBox("Aereo");
			this.cbaereo.setFont(new Font("Tahoma", Font.PLAIN, 15));
			this.cbaereo.setBounds(117, 325, 67, 25);
			this.panel.add(cbaereo);
			
			this.cbterrestre = new JCheckBox("Terrestre");
			this.cbterrestre.setFont(new Font("Tahoma", Font.PLAIN, 15));
			this.cbterrestre.setBounds(303, 325, 113, 25);
			this.panel.add(cbterrestre);
			
			this.blisto = new JButton("Listo");
			this.blisto.setFont(new Font("Tahoma", Font.PLAIN, 16));
			this.blisto.setBounds(180, 370, 141, 58);
			this.blisto.addActionListener(new ActionListener() {
		        public void actionPerformed(ActionEvent d) {
		        	
		        	String rep = null;
		        	String alim = null;
		        	String temp = null;
		        	String hab = null;
		        	String tip = tfnombre.getText().toString();
		        	String can = tfcan.getText().toString();
		        	
		        	if (cboviparo.isSelected()) {
		        		rep = "Oviparo";
		        	} else if (cbviviparo.isSelected()) {
		        		rep = "Viviparo";
		        	} 
		        	
		        	if (cbcarnivoro.isSelected()) {
		        		alim = "Carnivoro";
		        	} else if (cbherbivoro.isSelected()) {
		        		alim = "Herbivoro";
		        	} else if (cbomnivoro.isSelected()) {
		        		alim = "Omnivoro";
		        	}
		        	
		        	if (cbpacifico.isSelected()) {
		        		temp = "Pacifico";
		        	} else if (cbagresivo.isSelected()) {
		        		temp = "Agresivo";
		        	}
		        	
		        	if (cbterrestre.isSelected()) {
		        		hab = "Terrestre";
		        	} else if (cbsemiacuatico.isSelected()) {
		        		hab = "Semiacuatico";
		        	} else if (cbaereo.isSelected()) {
		        		hab = "Aereo";
		        	}
		        	
		        	
		            try {
		            	String sql="insert into animal values('"+tip+"','"+rep+"','"+alim+"','"+temp+"','"+hab+"','"+can+"')";
		            	
		            	DB.stmt = DB.conn.createStatement();
		    			DB.stmt.executeUpdate(sql);

		            } catch (SQLException e) {
		            
		            	 System.out.print(e);
		            	
		            }	
		            
		            Base_View base = new Base_View();
		            IG.vista.setContentPane(base.getbase());
		            IG.vista.invalidate();
		        	IG.vista.validate();
 
		        }
		    });
			
			this.panel.add(blisto);
			
			this.tfcan = new JTextField();
			this.tfcan.setBounds(270, 42, 146, 22);
			this.panel.add(tfcan);
			this.tfcan.setColumns(10);
			
			this.lblcan = new JLabel("Cantidad en Num");
			this.lblcan.setFont(new Font("Tahoma", Font.BOLD, 15));
			this.lblcan.setBounds(280, 13, 136, 16);
			this.panel.add(lblcan);	
			
			this.panel.setSize(500, 500);
			this.panel.setLayout(null);
			this.panel.setVisible(true);
			
		}
		
		public JPanel getJPanelingresar() {
			return this.panel;
		}
	}

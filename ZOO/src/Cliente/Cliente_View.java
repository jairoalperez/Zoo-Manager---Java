package Cliente;

import java.awt.event.*;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.io.InputStreamReader;


public class Cliente_View extends javax.swing.JFrame implements Runnable{

	private JPanel panel;
	private JLabel label;
	private JTextField tfmensaje;
	private JTextArea chat;
	private JButton enviar;
	private JButton atras;
	private JButton cerrarconexion;
	
	
	
	private String sms = "";
	
	private Socket socket = null;
	private ServerSocket servidor = null;
	
	public Cliente_View() {
		
		this.panel = new JPanel();
		
		this.label = new JLabel("Cliente");
		this.label.setBounds(200, 10, 100, 50);
		this.panel.add(label);
		
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
		this.panel.add(atras);
		
		this.tfmensaje = new JTextField();
		this.tfmensaje.setBounds(50, 75, 275, 30);
		this.panel.add(tfmensaje);
		
		this.enviar = new JButton("Enviar");
		this.enviar.setBounds(330, 75, 100, 30);
		this.enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//System.out.println("Sirve boton");
				try {
					InetSocketAddress sockAdr = new InetSocketAddress("localhost", 9999);
					Socket socket = new Socket();
					int timeout = 10000;
					socket.connect(sockAdr, timeout);
					DataOutputStream sendsms = new DataOutputStream(socket.getOutputStream());
					sendsms.writeUTF(tfmensaje.getText());
					sendsms.close();
					socket.isClosed();
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					System.out.println(e1.getMessage());
				}
				
				chat.append("\nCLIENTE: " + tfmensaje.getText());
				tfmensaje.setText(null);
				
				
			}
		});
		this.panel.add(enviar);
		
		
		
		this.chat = new JTextArea();
		this.chat.setBounds(50, 120, 380, 300);
		this.chat.setEditable(false);
		this.panel.add(chat);
		
		this.panel.setSize(500, 500);
		this.panel.setLayout(null);
		this.panel.setVisible(true);
		
		Thread mihilocliente = new Thread(this);
		mihilocliente.start();
		
		
		
		
} //cierre del client_view

		public JPanel getchat() {
			return this.panel;
		}


		@Override
		public void run() {
			System.out.println("Estoy a la escucha Cliente");
                try {
				
				servidor = new ServerSocket(5555);
				
				
				
				while (!sms.equals("Fin")) {	
				socket = servidor.accept();
			    DataInputStream recievesms = new DataInputStream(socket.getInputStream());
				sms = recievesms.readUTF();
				chat.append("\nSERVIDOR: "+sms);
				socket.isClosed();
				recievesms.close();	
				//System.out.println("Socketcerrandose");
					
				}
				
				
			
		} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//System.out.println(e);
	
			}
			
		}
		
		
		
		

}

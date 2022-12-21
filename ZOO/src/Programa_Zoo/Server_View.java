package Programa_Zoo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import java.io.InputStreamReader;
import java.net.*;
import java.sql.SQLException;

public class Server_View implements Runnable{

	private JPanel panel;
	private JLabel label;
	private JTextField tfmensaje;
	private JTextArea chat;
	private JButton enviar;
	private JButton atras;
	
	private String nombre;
	private String rep;
	private String alim;
	private String temp;
	private String hab;
	private String can;
	
	private String sms = "";
	private String aguila = "\\Aguila";
	private String avestruz = "\\Avestruz";
	private String cocodrilo = "\\Cocodrilo";
	private String foca = "\\Foca";
	private String gorila = "\\Gorila";
	private String jirafa = "\\Jirafa";
	private String leon = "\\Leon";
	private String leopardo = "\\Leopardo";
	private String loro = "\\Loro";
	private String panda = "\\Panda";
	private String pardo = "\\Pardo";
	private String polar = "\\Polar";
	private String pinguino = "\\Pinguino";
	private String rinoceronte = "\\Rinoceronte";
	private String tigre = "\\Tigre";
	
	
	
	
	//private Socket socket = null;
	private ServerSocket servidor = null;
	private DataInputStream in = null;
	private Socket socket = null;
	
	public Server_View() {
		
		this.panel = new JPanel();
		
		this.label = new JLabel("Servidor");
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
					InetSocketAddress sockAdr = new InetSocketAddress("localhost", 5555);
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
				chat.append("\nSERVIDOR: " + tfmensaje.getText());
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
		
		Thread mihiloserver = new Thread(this);
		mihiloserver.start();
		
}
		
		public JPanel getchat() {
			return this.panel;
		}

		
		
		
		
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			System.out.println("Estoy a la escucha Servidor");
			
			try {
				servidor = new ServerSocket(9999);
				
				
				
				while (!sms.equals("Fin")) {	
					
				socket = servidor.accept();
				DataInputStream recievesms = new DataInputStream(socket.getInputStream());
				sms = recievesms.readUTF();
				System.out.println(sms);
				if (sms.equals(aguila)) {
						try {
							String sql = "select * from animal where tipo = 'Aguila'";
						DB.pstmt = DB.conn.prepareStatement(sql);
						DB.rs = DB.pstmt.executeQuery();
						while(DB.rs.next()) {
							nombre = DB.rs.getString("tipo");
							rep = DB.rs.getString("reproduccion");
							alim = DB.rs.getString("alimentacion");
							temp = DB.rs.getString("temperamento");
							hab = DB.rs.getString("habitat");
							can = DB.rs.getString("cantidad");
							chat.append("\n"+nombre+" "+rep+" "+alim+" "+temp+" "+hab+" "+can);
						}
						} catch (SQLException e) {
						e.printStackTrace();
						}	
						
					} else  if (sms.equals(avestruz)){
						try {
							String sql = "select * from animal where tipo = 'Avestruz'";
						DB.pstmt = DB.conn.prepareStatement(sql);
						DB.rs = DB.pstmt.executeQuery();
						while(DB.rs.next()) {
							nombre = DB.rs.getString("tipo");
							rep = DB.rs.getString("reproduccion");
							alim = DB.rs.getString("alimentacion");
							temp = DB.rs.getString("temperamento");
							hab = DB.rs.getString("habitat");
							can = DB.rs.getString("cantidad");
							chat.append("\n"+nombre+" "+rep+" "+alim+" "+temp+" "+hab+" "+can);
						}
						} catch (SQLException e) {
						e.printStackTrace();
						}	
						
						
					} else  if (sms.equals(avestruz)) {
						try {
							String sql = "select * from animal where tipo = 'Cocodrilo'";
						DB.pstmt = DB.conn.prepareStatement(sql);
						DB.rs = DB.pstmt.executeQuery();
						while(DB.rs.next()) {
							nombre = DB.rs.getString("tipo");
							rep = DB.rs.getString("reproduccion");
							alim = DB.rs.getString("alimentacion");
							temp = DB.rs.getString("temperamento");
							hab = DB.rs.getString("habitat");
							can = DB.rs.getString("cantidad");
							chat.append("\n"+nombre+" "+rep+" "+alim+" "+temp+" "+hab+" "+can);
						}
						} catch (SQLException e) {
						e.printStackTrace();
						}
						
					}else  if (sms.equals(cocodrilo)) {
						try {
							String sql = "select * from animal where tipo = 'Cocodrilo'";
						DB.pstmt = DB.conn.prepareStatement(sql);
						DB.rs = DB.pstmt.executeQuery();
						while(DB.rs.next()) {
							nombre = DB.rs.getString("tipo");
							rep = DB.rs.getString("reproduccion");
							alim = DB.rs.getString("alimentacion");
							temp = DB.rs.getString("temperamento");
							hab = DB.rs.getString("habitat");
							can = DB.rs.getString("cantidad");
							chat.append("\n"+nombre+" "+rep+" "+alim+" "+temp+" "+hab+" "+can);
						}
						} catch (SQLException e) {
						e.printStackTrace();
						}
						
					} else  if (sms.equals(foca)) {
						try {
							String sql = "select * from animal where tipo = 'Foca'";
						DB.pstmt = DB.conn.prepareStatement(sql);
						DB.rs = DB.pstmt.executeQuery();
						while(DB.rs.next()) {
							nombre = DB.rs.getString("tipo");
							rep = DB.rs.getString("reproduccion");
							alim = DB.rs.getString("alimentacion");
							temp = DB.rs.getString("temperamento");
							hab = DB.rs.getString("habitat");
							can = DB.rs.getString("cantidad");
							chat.append("\n"+nombre+" "+rep+" "+alim+" "+temp+" "+hab+" "+can);
						}
						} catch (SQLException e) {
						e.printStackTrace();
						}
						
					}else  if (sms.equals(gorila)) {
						try {
							String sql = "select * from animal where tipo = 'Gorila'";
						DB.pstmt = DB.conn.prepareStatement(sql);
						DB.rs = DB.pstmt.executeQuery();
						while(DB.rs.next()) {
							nombre = DB.rs.getString("tipo");
							rep = DB.rs.getString("reproduccion");
							alim = DB.rs.getString("alimentacion");
							temp = DB.rs.getString("temperamento");
							hab = DB.rs.getString("habitat");
							can = DB.rs.getString("cantidad");
							chat.append("\n"+nombre+" "+rep+" "+alim+" "+temp+" "+hab+" "+can);
						}
						} catch (SQLException e) {
						e.printStackTrace();
						}
						
					}else  if (sms.equals(jirafa)) {
						try {
							String sql = "select * from animal where tipo = 'Jirafa'";
						DB.pstmt = DB.conn.prepareStatement(sql);
						DB.rs = DB.pstmt.executeQuery();
						while(DB.rs.next()) {
							nombre = DB.rs.getString("tipo");
							rep = DB.rs.getString("reproduccion");
							alim = DB.rs.getString("alimentacion");
							temp = DB.rs.getString("temperamento");
							hab = DB.rs.getString("habitat");
							can = DB.rs.getString("cantidad");
							chat.append("\n"+nombre+" "+rep+" "+alim+" "+temp+" "+hab+" "+can);
						}
						} catch (SQLException e) {
						e.printStackTrace();
						}
						
					}else  if (sms.equals(leon)) {
						try {
							String sql = "select * from animal where tipo = 'Leon'";
						DB.pstmt = DB.conn.prepareStatement(sql);
						DB.rs = DB.pstmt.executeQuery();
						while(DB.rs.next()) {
							nombre = DB.rs.getString("tipo");
							rep = DB.rs.getString("reproduccion");
							alim = DB.rs.getString("alimentacion");
							temp = DB.rs.getString("temperamento");
							hab = DB.rs.getString("habitat");
							can = DB.rs.getString("cantidad");
							chat.append("\n"+nombre+" "+rep+" "+alim+" "+temp+" "+hab+" "+can);
						}
						} catch (SQLException e) {
						e.printStackTrace();
						}
						
					}else  if (sms.equals(leopardo)) {
						try {
							String sql = "select * from animal where tipo = 'Leopardo'";
						DB.pstmt = DB.conn.prepareStatement(sql);
						DB.rs = DB.pstmt.executeQuery();
						while(DB.rs.next()) {
							nombre = DB.rs.getString("tipo");
							rep = DB.rs.getString("reproduccion");
							alim = DB.rs.getString("alimentacion");
							temp = DB.rs.getString("temperamento");
							hab = DB.rs.getString("habitat");
							can = DB.rs.getString("cantidad");
							chat.append("\n"+nombre+" "+rep+" "+alim+" "+temp+" "+hab+" "+can);
						}
						} catch (SQLException e) {
						e.printStackTrace();
						}
						
					}else  if (sms.equals(loro)) {
						try {
							String sql = "select * from animal where tipo = 'Loro'";
						DB.pstmt = DB.conn.prepareStatement(sql);
						DB.rs = DB.pstmt.executeQuery();
						while(DB.rs.next()) {
							nombre = DB.rs.getString("tipo");
							rep = DB.rs.getString("reproduccion");
							alim = DB.rs.getString("alimentacion");
							temp = DB.rs.getString("temperamento");
							hab = DB.rs.getString("habitat");
							can = DB.rs.getString("cantidad");
							chat.append("\n"+nombre+" "+rep+" "+alim+" "+temp+" "+hab+" "+can);
						}
						} catch (SQLException e) {
						e.printStackTrace();
						}
						
					}else  if (sms.equals(panda)) {
						try {
							String sql = "select * from animal where tipo = 'Oso Panda'";
						DB.pstmt = DB.conn.prepareStatement(sql);
						DB.rs = DB.pstmt.executeQuery();
						while(DB.rs.next()) {
							nombre = DB.rs.getString("tipo");
							rep = DB.rs.getString("reproduccion");
							alim = DB.rs.getString("alimentacion");
							temp = DB.rs.getString("temperamento");
							hab = DB.rs.getString("habitat");
							can = DB.rs.getString("cantidad");
							chat.append("\n"+nombre+" "+rep+" "+alim+" "+temp+" "+hab+" "+can);
						}
						} catch (SQLException e) {
						e.printStackTrace();
						}
						
					}else  if (sms.equals(pardo)) {
						try {
							String sql = "select * from animal where tipo = 'Oso Pardo'";
						DB.pstmt = DB.conn.prepareStatement(sql);
						DB.rs = DB.pstmt.executeQuery();
						while(DB.rs.next()) {
							nombre = DB.rs.getString("tipo");
							rep = DB.rs.getString("reproduccion");
							alim = DB.rs.getString("alimentacion");
							temp = DB.rs.getString("temperamento");
							hab = DB.rs.getString("habitat");
							can = DB.rs.getString("cantidad");
							chat.append("\n"+nombre+" "+rep+" "+alim+" "+temp+" "+hab+" "+can);
						}
						} catch (SQLException e) {
						e.printStackTrace();
						}
						
					}else  if (sms.equals(polar)) {
						try {
							String sql = "select * from animal where tipo = 'Oso Polar'";
						DB.pstmt = DB.conn.prepareStatement(sql);
						DB.rs = DB.pstmt.executeQuery();
						while(DB.rs.next()) {
							nombre = DB.rs.getString("tipo");
							rep = DB.rs.getString("reproduccion");
							alim = DB.rs.getString("alimentacion");
							temp = DB.rs.getString("temperamento");
							hab = DB.rs.getString("habitat");
							can = DB.rs.getString("cantidad");
							chat.append("\n"+nombre+" "+rep+" "+alim+" "+temp+" "+hab+" "+can);
						}
						} catch (SQLException e) {
						e.printStackTrace();
						}
						
					}else  if (sms.equals(pinguino)) {
						try {
							String sql = "select * from animal where tipo = 'Pinguino'";
						DB.pstmt = DB.conn.prepareStatement(sql);
						DB.rs = DB.pstmt.executeQuery();
						while(DB.rs.next()) {
							nombre = DB.rs.getString("tipo");
							rep = DB.rs.getString("reproduccion");
							alim = DB.rs.getString("alimentacion");
							temp = DB.rs.getString("temperamento");
							hab = DB.rs.getString("habitat");
							can = DB.rs.getString("cantidad");
							chat.append("\n"+nombre+" "+rep+" "+alim+" "+temp+" "+hab+" "+can);
						}
						} catch (SQLException e) {
						e.printStackTrace();
						}
						
					}else  if (sms.equals(rinoceronte)) {
						try {
							String sql = "select * from animal where tipo = 'Rinoceronte'";
						DB.pstmt = DB.conn.prepareStatement(sql);
						DB.rs = DB.pstmt.executeQuery();
						while(DB.rs.next()) {
							nombre = DB.rs.getString("tipo");
							rep = DB.rs.getString("reproduccion");
							alim = DB.rs.getString("alimentacion");
							temp = DB.rs.getString("temperamento");
							hab = DB.rs.getString("habitat");
							can = DB.rs.getString("cantidad");
							chat.append("\n"+nombre+" "+rep+" "+alim+" "+temp+" "+hab+" "+can);
						}
						} catch (SQLException e) {
						e.printStackTrace();
						}
						
					}else  if (sms.equals(tigre)) {
						try {
							String sql = "select * from animal where tipo = 'Tigre'";
						DB.pstmt = DB.conn.prepareStatement(sql);
						DB.rs = DB.pstmt.executeQuery();
						while(DB.rs.next()) {
							nombre = DB.rs.getString("tipo");
							rep = DB.rs.getString("reproduccion");
							alim = DB.rs.getString("alimentacion");
							temp = DB.rs.getString("temperamento");
							hab = DB.rs.getString("habitat");
							can = DB.rs.getString("cantidad");
							chat.append("\n"+nombre+" "+rep+" "+alim+" "+temp+" "+hab+" "+can);
						}
						} catch (SQLException e) {
						e.printStackTrace();
						}
						
					}
				
				
					
				chat.append("\nCLIENTE: "+sms);
				socket.isClosed();
				recievesms.close();
				
				}
				
				
				
				
				
				
					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				//System.out.println(e);
			}
		}
		
		
		
		
		
}

package com.jargelo.net.modelo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;



public class Envio extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8897925368841450393L;
	private JPanel contentPane;
	private JTextField txtRuta;
	private JButton btnMostrar;
	private JButton btnImportar;
	private JTextArea txtMostrar;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Envio frame = new Envio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Envio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRuta = new JLabel("RUTA");
		lblRuta.setBounds(26, 24, 56, 16);
		contentPane.add(lblRuta);
		
		txtRuta = new JTextField();
		txtRuta.setBounds(83, 18, 153, 22);
		contentPane.add(txtRuta);
		txtRuta.setColumns(10);
		
		btnMostrar = new JButton("MOSTRAR");
		btnMostrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mostrarDatos();
			}
		});
		btnMostrar.setBounds(46, 74, 97, 25);
		contentPane.add(btnMostrar);
		
		btnImportar = new JButton("IMPORTAR");
		btnImportar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				importar();
				
			}
		});
		btnImportar.setBounds(250, 74, 97, 25);
		contentPane.add(btnImportar);
		
		txtMostrar = new JTextArea();
		txtMostrar.setBounds(26, 112, 177, 128);
		contentPane.add(txtMostrar);
		
		JPanel panel = new JPanel();
		panel.setBounds(215, 99, 205, 141);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
				{null, null, null},
			},
			new String[] {
				"ID", "Nombre", "Sueldo"
			}
		));
		table.setBounds(12, 13, 181, 128);
		panel.add(table);
	}
	GestionBD obj=new GestionBD();

	protected void importar() {
		String ruta=txtRuta.getText();
		String consultaBD="LOAD DATA LOCAL INFILE '"+ruta+"' INTO TABLE nombres FIELDS   TERMINATED BY ','  ;";
		obj.ejecutar(consultaBD);
		
	}

	
	protected void mostrarDatos() {
		
		txtMostrar.setText(null);
		File archivo =null;
		FileReader fr = null;
		BufferedReader br=null;
		
		String ruta=txtRuta.getText();
		
		archivo= new File(ruta);

		if (archivo.exists()){

		try{
		// apertura del fichero y creacion de BufferedReader
			
			fr = new FileReader (archivo);
			br =new BufferedReader(fr);
			
			//lectura del fichero
			String linea;
			while((linea=br.readLine())!=null)
				
				txtMostrar.append("\n"+linea);
		}
			catch(Exception e){
				e.printStackTrace();
				}finally{
			}
			try{
				if(null != fr){
					fr.close();
				}
				}catch (Exception e2){
					e2.printStackTrace();
				}
				
			} else{
				JOptionPane.showMessageDialog(null, "Archivo no encontrado");
			}
			
	}
	}
		

class Envio2 extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3001267616326420178L;
	private JPanel contentPane;
	private JTextField txtRuta;
	private JButton btnExportar;
	private JButton btnMostar;
	private JTextArea txtMostrar;
	private JTable table;
	private String archivo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Envio frame = new Envio();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Envio2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblRuta = new JLabel("RUTA");
		lblRuta.setBounds(26, 24, 56, 16);
		contentPane.add(lblRuta);
		
		txtRuta = new JTextField();
		txtRuta.setBounds(83, 18, 153, 22);
		contentPane.add(txtRuta);
		txtRuta.setColumns(10);
		
		btnExportar = new JButton("EXPORTAR");
		btnExportar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				guardarArchivo();
			}
		});
		btnExportar.setBounds(46, 74, 97, 25);
		contentPane.add(btnExportar);
		
		btnMostar = new JButton("MOSTRAR");
		btnMostar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				mostrar();
				
			}
		});
		btnMostar.setBounds(250, 74, 97, 25);
		contentPane.add(btnMostar);
		
		txtMostrar = new JTextArea();
		txtMostrar.setBounds(26, 112, 177, 128);
		contentPane.add(txtMostrar);
		
		JPanel panel = new JPanel();
		panel.setBounds(215, 99, 205, 141);
		contentPane.add(panel);
		panel.setLayout(null);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
				{null, null, null, null, null, null},
			},
			new String[] {
				"ID", "Nombre", "Sueldo", "New column", "New column", "New column"
			}
		));
		table.setBounds(12, 13, 181, 128);
		panel.add(table);
	}
	GestionBD obj=new GestionBD();

	
	private void mostrar(){
		ResultSet tabla=obj.ejecutarConsulta("SELECT * FROM nombrepersona;");
		archivo="";
		DefaultTableModel resultado = (DefaultTableModel) table.getModel();
		try {
			int fila=0;
			while(tabla.next()){
				resultado.addRow(new Object[1]);
				archivo+=tabla.getString(1)+",";
				resultado.setValueAt(tabla.getString(1), fila, 0);
				archivo+=tabla.getString(2)+",";
				resultado.setValueAt(tabla.getString(2), fila, 1);
				archivo+=tabla.getString(3)+",";
				resultado.setValueAt(tabla.getString(3), fila, 2);
				archivo+=tabla.getString(4)+",";
				resultado.setValueAt(tabla.getString(4), fila, 3);
				archivo+=tabla.getString(5)+",";
				resultado.setValueAt(tabla.getString(5), fila, 4);
				archivo+=tabla.getString(6)+"\r\n";
				resultado.setValueAt(tabla.getString(6), fila, 5);
				fila++;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	
	private void guardarArchivo() {
		
		File archivo =null;
		FileWriter fw = null;
		BufferedWriter bw=null;
		
		String ruta=txtRuta.getText();
		
		archivo= new File(ruta);

		try{
		// apertura del fichero y creacion de BufferedReader
			fw=new FileWriter(archivo);
			bw=new BufferedWriter(fw);
			bw.write(this.archivo);
			bw.close();
		}catch(Exception e){
				e.printStackTrace();
				}
		FileReader fr = null;
		BufferedReader br=null;

		if (archivo.exists()){

		try{
		// apertura del fichero y creacion de BufferedReader
			txtMostrar.setText(null);
			fr = new FileReader (archivo);
			br =new BufferedReader(fr);
			
			//lectura del fichero
			String linea;
			while((linea=br.readLine())!=null)
				
				txtMostrar.append(linea+"\n");
		}
			catch(Exception e){
				e.printStackTrace();
				}finally{
			}
			try{
				if(null != fr){
					fr.close();
				}
				}catch (Exception e2){
					e2.printStackTrace();
				}
				
			} else{
				JOptionPane.showMessageDialog(null, "Archivo no encontrado");
			}

	}
}
		


package com.jargelo.dev;

import java.awt.EventQueue;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.PrintWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class FrmCliente extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtIDCliente;
	private JTextField txtNombre;
	private JTextField txtAPaterno;
	private JTextField txtAMaterno;
	private JComboBox<String> cmbOperacion;
	private JButton btnEnviar;
	private Socket socket;
	private DataInputStream resultados;
	private DataOutputStream datos;
	private String host;
	private int puerto;

	
	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run(){
				try{
					FrmCliente frame = new FrmCliente();
					frame.setVisible(true);
				}catch(Exception e){
					e.printStackTrace();
				}
			}
		});
	}
	
	public FrmCliente(){
		this.host = "localhost";
		this.puerto = 1700;
		establecerServidor();
		try{
			InputStream entrada = socket.getInputStream();
			this.resultados = new DataInputStream(entrada);
			OutputStream salida = socket.getOutputStream();
			this.datos = new DataOutputStream(salida);
		}catch(IOException e1){
			
		}
		addWindowListener(new WindowAdapter(){
			@Override
			public void windowClosing(WindowEvent e){
				desconectar();
			}
		});
		
		setTitle("Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEscribaElPrimer = new JLabel("ID Cliente:");
		lblEscribaElPrimer.setBounds(10, 11, 111, 14);
		contentPane.add(lblEscribaElPrimer);
		
		JLabel lblEscribaElSegundo = new JLabel("Nombre:");
		lblEscribaElSegundo.setBounds(10, 36, 111, 14);
		contentPane.add(lblEscribaElSegundo);
		
		txtIDCliente = new JTextField();
		txtIDCliente.setEditable(false);
		txtIDCliente.setBounds(131, 8, 131, 20);
		contentPane.add(txtIDCliente);
		txtIDCliente.setColumns(10);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setBounds(131, 33, 131, 20);
		contentPane.add(txtNombre);
		txtNombre.setColumns(10);
		
		btnEnviar = new JButton("Enviar información");
		btnEnviar.setEnabled(false);
		btnEnviar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				enviarCampos();
			}
		});
		btnEnviar.setBounds(276, 82, 158, 23);
		contentPane.add(btnEnviar);
		
		cmbOperacion = new JComboBox<String>();
		cmbOperacion.addItemListener(new ItemListener(){
			@Override
			public void itemStateChanged(ItemEvent e){
				if(cmbOperacion.getSelectedIndex()==1&&e.getStateChange()==ItemEvent.SELECTED){
					txtIDCliente.setEditable(false);
					limpiar();
					txtIDCliente.setText(obtenerSiguienteID());
					
					txtNombre.setEditable(true);
					txtAPaterno.setEditable(true);
					txtAMaterno.setEditable(true);
				}else if(cmbOperacion.getSelectedIndex()>1&&e.getStateChange()==ItemEvent.SELECTED){
					txtIDCliente.setEditable(true);
					limpiar();
					
					txtNombre.setEditable(false);
					txtAPaterno.setEditable(false);
					txtAMaterno.setEditable(false);
				}else{
					txtIDCliente.setEditable(false);
					txtNombre.setEditable(false);
					txtAPaterno.setEditable(false);
					txtAMaterno.setEditable(false);
				}
			}
		});
		cmbOperacion.setModel(new DefaultComboBoxModel<String>(new String[] {"Seleccione una acci\u00F3n", "ALTA", "BAJA", "CAMBIO", "CONSULTA"}));
		cmbOperacion.setBounds(276, 8, 158, 20);
		contentPane.add(cmbOperacion);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido paterno:");
		lblApellidoPaterno.setBounds(10, 61, 111, 14);
		contentPane.add(lblApellidoPaterno);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido materno:");
		lblApellidoMaterno.setBounds(10, 86, 111, 14);
		contentPane.add(lblApellidoMaterno);
		
		txtAPaterno = new JTextField();
		txtAPaterno.setEditable(false);
		txtAPaterno.setBounds(131, 58, 131, 20);
		contentPane.add(txtAPaterno);
		txtAPaterno.setColumns(10);
		
		txtAMaterno = new JTextField();
		txtAMaterno.setEditable(false);
		txtAMaterno.setBounds(131, 83, 131, 20);
		contentPane.add(txtAMaterno);
		txtAMaterno.setColumns(10);
	}
	
	private void limpiar(){
		txtIDCliente.setText(null);
		txtNombre.setText(null);
		txtAPaterno.setText(null);
		txtAMaterno.setText(null);
		btnEnviar.setEnabled(true);
	}
	
	private void establecerServidor(){
		conectar();
		if(socket==null)
			do{
				String direccion = JOptionPane.showInputDialog(null,
						"Escriba la dirección del servidor",
						"Conectando al servidor...",JOptionPane.QUESTION_MESSAGE);
				if(direccion!=null)
					this.host = direccion;
				else{
					System.exit(0);
				}
				conectar();
			}while(socket==null);
	}

	private void conectar(){
		try{
			socket = new Socket(host, puerto);
		}catch(UnknownHostException e){
			
		}catch(IOException e){
			
		}
	}
	
	private boolean validarResultado(String resultado){
		if(resultado.startsWith("Error"))
			return false;
		else
			return true;
	}
	
	private boolean camposLlenos(){
		if(cmbOperacion.getSelectedIndex()==1){
			if(!txtNombre.getText().isEmpty()&&!txtAPaterno.getText().isEmpty()&&!txtAMaterno.getText().isEmpty())
				return true;
		}else
			if(!txtIDCliente.getText().isEmpty())
				return true;
		return false;
	}
	
	private void enviarCampos(){
		if(cmbOperacion.getSelectedIndex()>0&&camposLlenos())
			try{
				String resume = "";
				String message;
				//String peticion = String.valueOf(cmbOperacion.getSelectedItem());
				String peticion;
				if(cmbOperacion.getSelectedIndex()==1)
					peticion = "ALTA";
				else
					peticion = "CONSULTA";
				
				boolean segundaPeticion = false;
				do{
					segundaPeticion = false;
					datos.writeUTF(peticion);
					
					message = "Enviando petición de "+peticion+"\t( "+new java.util.Date()+" )";
					logMessage(message);
					resume+=message+"\r\n";
					
					if(cmbOperacion.getSelectedIndex()==1||peticion.equalsIgnoreCase("CAMBIO")){
						String nombre = txtNombre.getText();
						datos.writeUTF(nombre);
						message ="Enviado el Nombre: "+nombre;
						logMessage(message);
						resume+=message+"\r\n";
						
						String apaterno = txtAPaterno.getText();
						datos.writeUTF(apaterno);
						message = "Enviado el Apellido Paterno: "+apaterno;
						logMessage(message);
						resume+=message+"\r\n";
						
						String amaterno = txtAMaterno.getText();
						datos.writeUTF(amaterno);
						message = "Enviado el Apellido Materno: "+amaterno;
						logMessage(message);
						resume+=message+"\r\n";
					}else{
						String id = txtIDCliente.getText();
						datos.writeUTF(id);
						message ="Enviado el ID";
						logMessage(message);
						resume+=message+"\r\n";
					}
					
					message = "Esperando resultado...";
					logMessage(message);
					resume+=message+"\r\n";
					String resultado = resultados.readUTF();
					
					if(validarResultado(resultado)){
						if(peticion.equalsIgnoreCase("ALTA")){
							txtIDCliente.setText(obtenerUltimoID());
							resume="Solicitando en último ID\r\n"+
									resume+
									"Solicitando en último ID\r\n";
						}
						if(peticion.equalsIgnoreCase("BAJA"))
							limpiar();
						if(peticion.equalsIgnoreCase("CONSULTA")){
							txtNombre.setText(resultados.readUTF());
							txtAPaterno.setText(resultados.readUTF());
							txtAMaterno.setText(resultados.readUTF());
						}
						if(cmbOperacion.getSelectedIndex()<2||cmbOperacion.getSelectedIndex()>3||peticion.equalsIgnoreCase("BAJA")||peticion.equalsIgnoreCase("CAMBIO"))
							JOptionPane.showMessageDialog(null,
								resultado,
								"Ok",JOptionPane.INFORMATION_MESSAGE);
						else if(cmbOperacion.getSelectedIndex()==2&&!peticion.equalsIgnoreCase("BAJA")){
							int confirmacion = JOptionPane.showConfirmDialog(null,
								"Si está seguro de borrar el registro presione OK",
								"Confitmación necesaria",JOptionPane.OK_CANCEL_OPTION);
							if(confirmacion==0){
								//logMessage("");
								peticion = "BAJA";
								segundaPeticion = true;
							}
						}else if(cmbOperacion.getSelectedIndex()==3&&!peticion.equalsIgnoreCase("CAMBIO")){
							String nuevoNombre = JOptionPane.showInputDialog(null,
								"Escriba el nuevo valor para el nombre,\nsi deja este campo vacío el nombre no se actualizará\n...",
								"Actualización del nombre",JOptionPane.QUESTION_MESSAGE);
							if(nuevoNombre!=null)
								if(!nuevoNombre.isEmpty())
									txtNombre.setText(nuevoNombre);
							
							String nuevoApPat = JOptionPane.showInputDialog(null,
								"Escriba el nuevo valor para el apellido paterno,\nsi deja este campo vacío el apellido paterno no se actualizará\n...",
								"Actualización del apellido paterno",JOptionPane.QUESTION_MESSAGE);
							if(nuevoApPat!=null)
								if(!nuevoApPat.isEmpty())
									txtAPaterno.setText(nuevoApPat);
							
							String nuevoApMat = JOptionPane.showInputDialog(null,
								"Escriba el nuevo valor para el apellido materno,\nsi deja este campo vacío el apellido materno no se actualizará\n...",
								"Actualización del apellido materno",JOptionPane.QUESTION_MESSAGE);
							if(nuevoApMat!=null)
								if(!nuevoApMat.isEmpty())
									txtAMaterno.setText(nuevoApMat);
							
							//logMessage("");
							peticion = "CAMBIO";
							segundaPeticion = true;
							}
					}else{
						JOptionPane.showMessageDialog(null,
							resultado,
							"Error",JOptionPane.ERROR_MESSAGE);
						txtIDCliente.setText(null);
					}
				}while(segundaPeticion);
				
				message = "HECHO\r\n";
				logMessage(message);
				
				resume+=message;
				datos.writeUTF("REGISTRAR");
				datos.writeUTF(resume);
				
				btnEnviar.setEnabled(false);
				cmbOperacion.setSelectedIndex(0);
			}catch(IOException e){
				JOptionPane.showMessageDialog(null,
					"El servidor no parece estar activo, la aplicación se cerrará",
					"Error",JOptionPane.ERROR_MESSAGE);
				System.exit(1);
			}
		else{
			JOptionPane.showMessageDialog(null,
				"Debes llenar todos los campos habilitados",
				"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private String obtenerUltimoID(){
		String resultado = null;
		try{
			datos.writeUTF("CONSULTAR ULTIMO ID");
			logMessage("Solicitando el último ID");
			
			resultado = resultados.readUTF();
		}catch(IOException e){
			//System.out.println("Error en obtenerSiguienteID()\n"+e);
			JOptionPane.showMessageDialog(null,
				"El servidor no parece estar activo, la aplicación se cerrará",
				"Error",JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		return resultado;
	}
	
	private String obtenerSiguienteID(){
		return String.valueOf(Integer.parseInt(obtenerUltimoID())+1);
	}
	
	private void desconectar(){
		if(socket!=null)
			try{
				String peticion = "SALIR";
				datos.writeUTF(peticion);
				logMessage("Enviando petición de "+peticion+"\r\n");
				
				socket.close();
			}catch(IOException e){
				logMessage("Error en desconectar()"+e);
			}
	}
	
	private void logMessage(String message){
		try{
			FileWriter fileWriter = new FileWriter("Cliente.log",true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			PrintWriter printWriter = new PrintWriter(bufferedWriter);
			
			printWriter.append(message+"\r\n");
			printWriter.close();
			
			System.out.println(message);
		}catch(IOException e){
			System.out.println("Error al acceder al archivo de log del cliente: 'Cliente.log'");
		}
	}
	
}

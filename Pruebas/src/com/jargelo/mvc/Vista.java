package com.jargelo.mvc;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;
import javax.swing.ButtonGroup;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;

@SuppressWarnings("serial")
public class Vista extends JFrame {
	private Controlador controlador;
	private JPanel contentPane;
	private JTextField txtCve_empleado;
	private JTextField txtNombres;
	private JTextField txtA_paterno;
	private JTextField txtA_materno;
	@SuppressWarnings("rawtypes")
	private JComboBox cmbPuesto;
	private JFormattedTextField ftfF_nacimiento;
	private JFormattedTextField ftfF_ingreso;
	private JTextField txtSueldo;
	private JLabel lblNotificaciones;
	private JButton btnRealizarAlta;
	private JButton btnRealizarBsqueda;
	private JButton btnConsultaGeneral;
	private ButtonGroup modoVista;
	private JRadioButton rdbtnAltas;
	private JRadioButton rdbtnBsqueda;
	private JRadioButton rdbtnConsultas;
	private JTable table;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Vista(Controlador controlador) {
		this.controlador=controlador;
		
		setTitle("Alta de usuarios");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 765, 620);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		modoVista = new ButtonGroup();
		
		rdbtnAltas = new JRadioButton("Altas");
		rdbtnAltas.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				establecerBotones();
			}
		});
		rdbtnAltas.setBounds(347, 15, 109, 23);
		contentPane.add(rdbtnAltas);
		modoVista.add(rdbtnAltas);
		
		rdbtnBsqueda = new JRadioButton("B\u00FAsqueda");
		rdbtnBsqueda.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				establecerBotones();
			}
		});
		rdbtnBsqueda.setBounds(458, 15, 109, 23);
		contentPane.add(rdbtnBsqueda);
		modoVista.add(rdbtnBsqueda);
		
		rdbtnConsultas = new JRadioButton("Consultas");
		rdbtnConsultas.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent arg0) {
				establecerBotones();
			}
		});
		rdbtnConsultas.setBounds(569, 15, 109, 23);
		contentPane.add(rdbtnConsultas);
		modoVista.add(rdbtnConsultas);
		
		JLabel lblClaveDeEmpleado = new JLabel("Clave de empleado:");
		lblClaveDeEmpleado.setBounds(35, 58, 115, 14);
		contentPane.add(lblClaveDeEmpleado);
		
		txtCve_empleado = new JTextField();
		txtCve_empleado.setEditable(false);
		txtCve_empleado.setBounds(160, 55, 86, 20);
		contentPane.add(txtCve_empleado);
		
		JLabel lblNombre = new JLabel("Nombre (s):");
		lblNombre.setBounds(35, 93, 73, 14);
		contentPane.add(lblNombre);
		
		txtNombres = new JTextField();
		txtNombres.setEditable(false);
		txtNombres.setBounds(118, 90, 128, 20);
		contentPane.add(txtNombres);
		txtNombres.setColumns(10);
		
		JLabel lblApellidoPaterno = new JLabel("Apellido paterno:");
		lblApellidoPaterno.setBounds(265, 93, 99, 14);
		contentPane.add(lblApellidoPaterno);
		
		txtA_paterno = new JTextField();
		txtA_paterno.setEditable(false);
		txtA_paterno.setBounds(374, 90, 115, 20);
		contentPane.add(txtA_paterno);
		txtA_paterno.setColumns(10);
		
		JLabel lblApellidoMaterno = new JLabel("Apellido materno");
		lblApellidoMaterno.setBounds(508, 93, 99, 14);
		contentPane.add(lblApellidoMaterno);
		
		txtA_materno = new JTextField();
		txtA_materno.setEditable(false);
		txtA_materno.setBounds(615, 90, 115, 20);
		contentPane.add(txtA_materno);
		txtA_materno.setColumns(10);
		
		cmbPuesto = new JComboBox();
		cmbPuesto.setEnabled(false);
		cmbPuesto.setModel(new DefaultComboBoxModel(new String[] {"Seleccione un puesto", "Gerente General", "Director", "Capturista", "Auxiliar", "Guardia de Seguridad", "Personal de Limpieza", "Recepcionista", "Mensajero", "Secretaria"}));
		cmbPuesto.setBounds(265, 55, 150, 20);
		contentPane.add(cmbPuesto);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de nacimiento:");
		lblFechaDeNacimiento.setBounds(35, 128, 115, 14);
		contentPane.add(lblFechaDeNacimiento);
		
		ftfF_nacimiento = new JFormattedTextField();
		ftfF_nacimiento.setEditable(false);
		ftfF_nacimiento.setBounds(160, 124, 86, 20);
		ftfF_nacimiento.setFont(new Font("Tahoma", Font.PLAIN, 13));
		try{
			ftfF_nacimiento.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("####/##/##")));
		}catch(ParseException e){
			
		}
		contentPane.add(ftfF_nacimiento);
		
		JLabel lblFechaDeIngreso = new JLabel("Fecha de ingreso:");
		lblFechaDeIngreso.setBounds(265, 128, 105, 14);
		contentPane.add(lblFechaDeIngreso);
		
		ftfF_ingreso = new JFormattedTextField();
		ftfF_ingreso.setEditable(false);
		ftfF_ingreso.setBounds(384, 124, 86, 20);
		ftfF_ingreso.setFont(new Font("Tahoma", Font.PLAIN, 13));
		try{
			ftfF_ingreso.setFormatterFactory(new DefaultFormatterFactory(new MaskFormatter("####/##/##")));
		}catch(ParseException e){
			
		}
		contentPane.add(ftfF_ingreso);
		
		JLabel lblSueldo = new JLabel("Sueldo:");
		lblSueldo.setBounds(508, 128, 50, 14);
		contentPane.add(lblSueldo);
		
		txtSueldo = new JTextField();
		txtSueldo.setEditable(false);
		txtSueldo.setBounds(569, 125, 86, 20);
		contentPane.add(txtSueldo);
		txtSueldo.setColumns(10);
		
		btnRealizarAlta = new JButton("Realizar Alta");
		btnRealizarAlta.setEnabled(false);
		btnRealizarAlta.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(validarFormulario()){
					enviarDatos();
				}
			}
		});
		btnRealizarAlta.setBounds(35, 175, 129, 23);
		contentPane.add(btnRealizarAlta);
		
		lblNotificaciones = new JLabel("Notificaciones");
		lblNotificaciones.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblNotificaciones.setForeground(Color.BLACK);
		lblNotificaciones.setBounds(25, 218, 297, 14);
		contentPane.add(lblNotificaciones);
		
		btnRealizarBsqueda = new JButton("Realizar b\u00FAsqueda");
		btnRealizarBsqueda.setEnabled(false);
		btnRealizarBsqueda.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				solicitarBusquedaPrimarias();
			}
		});
		btnRealizarBsqueda.setBounds(192, 175, 130, 23);
		contentPane.add(btnRealizarBsqueda);
		
		btnConsultaGeneral = new JButton("Realizar consulta");
		btnConsultaGeneral.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				solicitaConsultaGeneral();
			}
		});
		btnConsultaGeneral.setEnabled(false);
		btnConsultaGeneral.setBounds(345, 175, 130, 23);
		contentPane.add(btnConsultaGeneral);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(25, 257, 705, 298);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Clave de empleado", "Nombre completo", "Puesto", "Fecha de nacimiento", "Fecha de ingreso", "Sueldo"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(115);
		table.getColumnModel().getColumn(1).setPreferredWidth(190);
		table.getColumnModel().getColumn(3).setPreferredWidth(110);
		table.getColumnModel().getColumn(4).setPreferredWidth(100);
		scrollPane.setViewportView(table);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		btnSalir.setBounds(641, 175, 89, 23);
		contentPane.add(btnSalir);
		
		JButton btnLimpiar = new JButton("Limpiar");
		btnLimpiar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				limpiarFormulario();
			}
		});
		btnLimpiar.setBounds(542, 175, 89, 23);
		contentPane.add(btnLimpiar);
		
		JLabel lblSeleccioneUnModo = new JLabel("Seleccione un modo para esta aplicaci\u00F3n:");
		lblSeleccioneUnModo.setForeground(Color.BLACK);
		lblSeleccioneUnModo.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblSeleccioneUnModo.setBounds(25, 18, 316, 14);
		contentPane.add(lblSeleccioneUnModo);
	}
	
	private void limpiarFormulario() {
		txtCve_empleado.setText(null);
		txtNombres.setText(null);
		txtA_paterno.setText(null);
		txtA_materno.setText(null);
		cmbPuesto.setSelectedIndex(0);
		ftfF_nacimiento.setText(null);
		ftfF_ingreso.setText(null);
		txtSueldo.setText(null);
		modoVista.clearSelection();
		resetearNotificaciones();
		borrarTabla();
	}

	private void resetearNotificaciones() {
		lblNotificaciones.setText("Notificaciones");
		lblNotificaciones.setForeground(Color.BLACK);
	}

	private void establecerBotones() {
		if(rdbtnAltas.isSelected()){
			txtCve_empleado.setEditable(true);
			txtNombres.setEditable(true);
			txtA_paterno.setEditable(true);
			txtA_materno.setEditable(true);
			cmbPuesto.setEnabled(true);
			ftfF_nacimiento.setEditable(true);
			ftfF_ingreso.setEditable(true);
			txtSueldo.setEditable(true);
			btnRealizarAlta.setEnabled(true);
			btnRealizarBsqueda.setEnabled(false);
			btnConsultaGeneral.setEnabled(false);
		}else if(rdbtnBsqueda.isSelected()){
			txtCve_empleado.setEditable(true);
			txtNombres.setEditable(false);
			txtA_paterno.setEditable(false);
			txtA_materno.setEditable(false);
			cmbPuesto.setEnabled(false);
			ftfF_nacimiento.setEditable(false);
			ftfF_ingreso.setEditable(false);
			txtSueldo.setEditable(false);
			btnRealizarAlta.setEnabled(false);
			btnRealizarBsqueda.setEnabled(true);
			btnConsultaGeneral.setEnabled(false);
		}else if(rdbtnConsultas.isSelected()){
			txtCve_empleado.setEditable(false);
			txtNombres.setEditable(false);
			txtA_paterno.setEditable(false);
			txtA_materno.setEditable(false);
			cmbPuesto.setEnabled(false);
			ftfF_nacimiento.setEditable(false);
			ftfF_ingreso.setEditable(false);
			txtSueldo.setEditable(false);
			btnRealizarAlta.setEnabled(false);
			btnRealizarBsqueda.setEnabled(false);
			btnConsultaGeneral.setEnabled(true);
		}else{
			txtCve_empleado.setEditable(false);
			txtNombres.setEditable(false);
			txtA_paterno.setEditable(false);
			txtA_materno.setEditable(false);
			cmbPuesto.setEnabled(false);
			ftfF_nacimiento.setEditable(false);
			ftfF_ingreso.setEditable(false);
			txtSueldo.setEditable(false);
			btnRealizarAlta.setEnabled(false);
			btnRealizarBsqueda.setEnabled(false);
			btnConsultaGeneral.setEnabled(false);
		}
	}

	private boolean validarFormulario() {
		int cve_empleado=0;
		int f_nacimiento=0;
		int f_ingreso=0;
		
		resetearNotificaciones();
		borrarTabla();
		
		Date dateHoy = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		
		GregorianCalendar calendarHoy = new GregorianCalendar();
		calendarHoy.setTime(dateHoy);
		calendarHoy.add(Calendar.YEAR,-18);
		
		int fechaInicioEmpresa=19840521;
		int fechaHoy=Integer.parseInt(simpleDateFormat.format(dateHoy).replaceAll("/",""));
		int fechaEmpleo=Integer.parseInt(simpleDateFormat.format(calendarHoy.getTime()).replaceAll("/",""));
		
		try{
			cve_empleado=Integer.parseInt(txtCve_empleado.getText());
		}catch(NullPointerException e){
			
		}catch(NumberFormatException e){
			
		}
		if(cve_empleado>0&&cve_empleado<10000000){
			if(txtNombres.getText().length()>0){
				if(txtA_paterno.getText().length()>0){
					if(txtA_materno.getText().length()>0){
						if(cmbPuesto.getSelectedIndex()!=0){
							try{
								f_nacimiento=Integer.parseInt(ftfF_nacimiento.getText().replaceAll("/",""));
							}catch(NullPointerException e){
								
							}catch(NumberFormatException e){
								
							}
							if(f_nacimiento>=19000101&&f_nacimiento<=fechaEmpleo){
								try{
									f_ingreso=Integer.parseInt(ftfF_ingreso.getText().replaceAll("/",""));
								}catch(NullPointerException e){
									
								}catch(NumberFormatException e){
									
								}
								if(f_ingreso>=fechaInicioEmpresa&&f_ingreso<=fechaHoy){
									double sueldo=0;
									try{
										sueldo=Double.parseDouble(txtSueldo.getText());
									}catch(NullPointerException e){
										
									}catch(NumberFormatException e){
										
									}
									if(sueldo>0)
										return true;
									else
										JOptionPane.showMessageDialog(null,
											"Escriba un sueldo válido",
											"Error",JOptionPane.ERROR_MESSAGE);
								}else
									JOptionPane.showMessageDialog(null,
										"Escriba una fecha de ingreso segun el formato",
										"Error",JOptionPane.ERROR_MESSAGE);
							}else
								JOptionPane.showMessageDialog(null,
									"Escriba una fecha de nacimiento segun el formato",
									"Error",JOptionPane.ERROR_MESSAGE);
						}else
							JOptionPane.showMessageDialog(null,
								"Seleccione un puesto de empleado",
								"Error",JOptionPane.ERROR_MESSAGE);
					}else
						JOptionPane.showMessageDialog(null,
							"Escriba un apellido materno",
							"Error",JOptionPane.ERROR_MESSAGE);
				}else
					JOptionPane.showMessageDialog(null,
						"Escriba un apellido paterno",
						"Error",JOptionPane.ERROR_MESSAGE);
			}else
				JOptionPane.showMessageDialog(null,
					"Escriba un nombre de empleado",
					"Error",JOptionPane.ERROR_MESSAGE);
		}else
			JOptionPane.showMessageDialog(null,
				"Escriba una clave de empleado válida (hasta 8 números)",
				"Error",JOptionPane.ERROR_MESSAGE);
		return false;
	}

	private void enviarDatos() {
		int cve_empleado=Integer.parseInt(txtCve_empleado.getText());
		String nombres=txtNombres.getText();
		String a_paterno=txtA_paterno.getText();
		String a_materno=txtA_materno.getText();
		String puesto=String.valueOf(cmbPuesto.getSelectedItem());
		String f_nacimiento=ftfF_nacimiento.getText();
		String f_ingreso=ftfF_ingreso.getText();
		double sueldo=Double.parseDouble(txtSueldo.getText());
		controlador.gestionarAltas(cve_empleado, nombres, a_paterno, a_materno, puesto, f_nacimiento, f_ingreso, sueldo);
	}
	
	private void solicitaConsultaGeneral(){
		resetearNotificaciones();
		borrarTabla();
		controlador.gestionarConsulta();
	}
	
	private void solicitarBusquedaPrimarias(){
		resetearNotificaciones();
		borrarTabla();
		int cve_empleado=0;
		try{
			cve_empleado=Integer.parseInt(txtCve_empleado.getText());
		}catch(NullPointerException e){
			
		}catch(NumberFormatException e){
			
		}
		if(cve_empleado>0&&cve_empleado<10000000){
			controlador.gestionarConsulta(txtCve_empleado.getText());
		}else
			JOptionPane.showMessageDialog(null,
				"Escriba una clave de empleado válida (hasta 8 números)",
				"Error",JOptionPane.ERROR_MESSAGE);
	}
	
	private void borrarTabla(){
		DefaultTableModel tablaEmpleados = (DefaultTableModel) table.getModel();
		while(tablaEmpleados.getRowCount()>0)
			tablaEmpleados.removeRow(tablaEmpleados.getRowCount()-1);
	}
	
	public void agregarFilaAEmpleados(String cve_empleado, String nombre, String puesto, String f_nacimiento, String f_ingreso, String sueldo){
		DefaultTableModel tablaEmpleados = (DefaultTableModel) table.getModel();
		tablaEmpleados.addRow(new Object[1]);
		int row=tablaEmpleados.getRowCount()-1;
		tablaEmpleados.setValueAt(cve_empleado, row, 0);
		tablaEmpleados.setValueAt(nombre, row, 1);
		tablaEmpleados.setValueAt(puesto, row, 2);
		tablaEmpleados.setValueAt(f_nacimiento, row, 3);
		tablaEmpleados.setValueAt(f_ingreso, row, 4);
		tablaEmpleados.setValueAt(sueldo, row, 5);
	}
	
	public void iniciarAplicación(){
		this.setVisible(true);
	}
	
	public void notificarAlta(String notify){
		lblNotificaciones.setText(notify);
		lblNotificaciones.setForeground(Color.GREEN);
	}
	
	public void notificarError(String notify){
		lblNotificaciones.setText(notify);
		lblNotificaciones.setForeground(Color.RED);
	}
}

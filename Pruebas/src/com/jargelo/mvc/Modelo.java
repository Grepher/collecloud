package com.jargelo.mvc;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Modelo {
	private Vista vista;
	private Statement statement;
	private ResultSet resultset;
	private Connection connection;
	private String nombreDB,usuario,pass,url;
	
	public Modelo(Vista vista){
		this.vista = vista;
	}
	
	public void establecerConexion(){
		nombreDB="Base";
		usuario="root";
		pass=null;
		url="jdbc:mysql://localhost/"+nombreDB;
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection=DriverManager.getConnection(url,usuario,pass);
				JOptionPane.showMessageDialog(null,
					"Conexion exitosa",
					"Aviso",JOptionPane.INFORMATION_MESSAGE);
		}catch(InstantiationException e) {
			JOptionPane.showMessageDialog(null,
					"No se pudo crear la instancia",
					"Error",JOptionPane.ERROR_MESSAGE);
		}catch(IllegalAccessException e) {
			JOptionPane.showMessageDialog(null,
					"Aceso denegado a la clase",
					"Error",JOptionPane.ERROR_MESSAGE);
		}catch(ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null,
					"No se encontro la clase",
					"Error",JOptionPane.ERROR_MESSAGE);
 		}catch(SQLException e) {
			JOptionPane.showMessageDialog(null,
			"Error con la base de datos",
			"Error",JOptionPane.ERROR_MESSAGE);
		}
	}
	
	protected boolean ejecutarSentencia(String sentenciaSQL){
		try {
			statement=connection.createStatement();
			statement.execute(sentenciaSQL);
			return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
				"Ocurrio el error\n"+e,
				"Error",JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}
	
	protected ResultSet ejecutarConsulta(String consultaSQL){
		resultset=null;
		try {
			statement=connection.createStatement();
			resultset=statement.executeQuery(consultaSQL);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
				"Ocurrio el error\n"+e,
				"Error",JOptionPane.ERROR_MESSAGE);
		}
		return resultset;
	}

	public void notificarUsuario(String notify, int subject) {
		switch(subject){
			case 1:
				vista.notificarError(notify);
			break;
			case 2:
				vista.notificarAlta(notify);
			break;
		}
	}
	
	public boolean enviarTabla(String consultaSQL){
		resultset=ejecutarConsulta(consultaSQL);
		String cve_empleado=null;
		String nombre=null;
		String puesto=null;
		String f_nacimiento=null;
		String f_ingreso=null;
		String sueldo=null;
		try {
			while(resultset.next()){
				cve_empleado=resultset.getString(1);
				nombre=resultset.getString(3)+" "+resultset.getString(4)+" "+resultset.getString(2);
				puesto=resultset.getString(5);
				f_nacimiento=resultset.getString(6);
				f_ingreso=resultset.getString(7);
				sueldo=resultset.getString(8);
				vista.agregarFilaAEmpleados(cve_empleado, nombre, puesto, f_nacimiento, f_ingreso, sueldo);
			}
			if(cve_empleado==null)
				return false;
			else
				return true;
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,
					"Ocurrio el error\n"+e,
					"Error",JOptionPane.ERROR_MESSAGE);
		}
		return false;
	}
	
}

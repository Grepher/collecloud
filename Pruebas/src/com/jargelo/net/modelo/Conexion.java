package com.jargelo.net.modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {
	private String nombreBD;
	private String usuario;
	private String passw;
	private String ruta;
	private Connection conn;

	public Conexion() {
		nombreBD = "miBase";
		usuario = "root";
		passw = "";
		ruta = "jdbc:mysql://localhost/" + nombreBD;
	}

	public Conexion(String nombreBD, String usuario, String passw) {
		this.nombreBD = nombreBD;
		this.usuario = usuario;
		this.passw = passw;
		ruta = "jdbc:mysql://localhost/" + nombreBD;
	}

	public Connection conectandoBD() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(ruta, usuario, passw);
			JOptionPane.showMessageDialog(null, "Te has Conectado con la Base" + nombreBD, "Felicidades",
					JOptionPane.INFORMATION_MESSAGE);
		} catch (InstantiationException e) {
			JOptionPane.showMessageDialog(null, "No se Puedo Crear la Instancia con el Driver", "Error",
					JOptionPane.ERROR_MESSAGE);
		} catch (IllegalAccessException e) {
			JOptionPane.showMessageDialog(null, "No tiene acceso al Dirver", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, "No encontro el Driver", "Error", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, "Nombre de Usuario o Contraseña incorrecto", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
		return conn;
	}

	public String ejecutarConsulta(String consulta) {
		String resultados = "";
		try {
			ResultSet resultSet = conn.createStatement().executeQuery(consulta);
			int registros = 0;
			while (resultSet.next()) {
				if (registros > 1)
					resultados += "\r\n";
				try {
					int numeroCadena = 1;
					while (registros >= 0) {
						if (numeroCadena > 1)
							resultados += "\r\n" + resultSet.getString(numeroCadena);
						else
							resultados += resultSet.getString(numeroCadena);
						numeroCadena++;
					}
				} catch (NullPointerException e) {
				}
				registros++;
			}
		} catch (SQLException e) {
		}
		return resultados;
	}

	public String ejecutarSentencia(String sentencia) {
		try {
			conn.createStatement().execute(sentencia);
			return "true";
		} catch (SQLException e) {
			return "Error en ejecutarSentencia()\r\n" + e;
		}
	}

	public Connection getConnection() {
		return conn;
	}

}

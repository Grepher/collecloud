package com.jargelo.igd.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
	private static String servidor = "jdbc:mysql://localhost/ayuda";
	private static String usuario = "root";
	private static String contr = "";
	private static String driver = "com.mysql.jdbc.Driver";
	private static Connection conexion;
	
	public Conexion(){
		try {
			Class.forName(driver);
			conexion = DriverManager.getConnection(servidor,usuario,contr);
			//System.out.println("Conexión realizada");
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println("Conexión fallida");
		}
	}
	
	public Connection  getConnection(){
			return conexion;	
	}
}

package com.jargelo.skt;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

//import adiciones.Logger;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexion{
	private Connection connection;
	private Statement statement;
	
	public Conexion(){
		conectar();
	}
	
	private void conectar(){
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection("jdbc:mysql://localhost/empresa","root","");
			statement = connection.createStatement();
		}catch(Exception e){
//			Logger.logMessage("Error de conexion:\r\n"+e);
			System.exit(1);
		}
	}
	
	public String ejecutarConsulta(String consulta){
		String resultados = "";
		try{
			ResultSet resultSet = statement.executeQuery(consulta);
			int registros = 0;
			while(resultSet.next()){
				if(registros>1)
					resultados+="\r\n";
				try{
					int numeroCadena = 1;
					while(registros>=0){
						if(numeroCadena>1)
							resultados+="\r\n"+resultSet.getString(numeroCadena);
						else
							resultados+=resultSet.getString(numeroCadena);
						numeroCadena++;
					}
				}catch(NullPointerException e){
//					Logger.logMessage("Error en ejecutarConsulta()-1\r\n"+e);
				}
				registros++;
			}
		}catch(SQLException e){
			//Logger.logMessage("Error en ejecutarConsulta()-2\r\n"+e);
		}
		return resultados;
	}
	
	public String ejecutarSentencia(String sentencia){
		try{
			statement.execute(sentencia);
			return "true";
		}catch(SQLException e){
			return "Error en ejecutarSentencia()\r\n"+e;
		}
	}
	
}

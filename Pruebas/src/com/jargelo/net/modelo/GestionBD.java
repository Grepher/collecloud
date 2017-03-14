package com.jargelo.net.modelo;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class GestionBD {
	
	Connection lineaConexion;
    Statement sentencia;
	 Conexion objConexion=new Conexion();
    
    public GestionBD(){
    	lineaConexion=objConexion.conectandoBD();
    	
    }
    
	public void ejecutar(String sentenciaBD){
		try {
			sentencia=lineaConexion.createStatement();
			sentencia.execute(sentenciaBD);
			JOptionPane.showMessageDialog(null,"Quey OK", "Congratulation", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"No se pudo cargar la informacion de la BD"+e,
					"Error", JOptionPane.ERROR_MESSAGE);
		}
				
	}

	public ResultSet ejecutarConsulta(String sentenciaBD) {
		ResultSet rs=null;
		try {
			sentencia=lineaConexion.createStatement();
			rs=sentencia.executeQuery(sentenciaBD);
			
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null,"No se pudo realizar la consulta" +e,
					"Error", JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		return rs;
	}


	
	
	
}

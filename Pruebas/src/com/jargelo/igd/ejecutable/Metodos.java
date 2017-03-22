package com.jargelo.igd.ejecutable;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.jargelo.igd.conexion.Conexion;

public class Metodos {
	static Conexion cn = new Conexion();
	static Connection  conex = cn.getConnection();
	static Statement st;
	static ResultSet rs;
	static Random rm = new Random();
	static int id = 0; //toRandom
	static String nombreObt = "";
	static int i;
	
	/*public void nombres(int cantidad){
		int ar = 0;
		int nam = 0;
		for (int i = 0; i < cantidad; i++) {
			ar++;
			nam++;
			if (nam < nombres.length) {
				
			}else{
				nam = 0;
			}
			System.out.println("Hola "+ nombres[nam] +" "+ ar);
		}
	}*/
	
	
	public void insertar(int cantidad, String tablaObtencion){
		for (i = 0; i < cantidad; i++) {
			
			String sql= String.format("insert into prueba values (null,'%s');",obtenerNombre(tablaObtencion));

			try {
				st = conex.createStatement();
				st.executeUpdate(sql);
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		//conex.close();
		//st.close();
		System.out.println(String.format("Se insertaron %d registros",i));
	}
	
	//Cálcula la cantidad de registos que tiene mi tabla de ayuda
	public int cantidadRegistros(String tabla){
		
		String sql = "Select count(id_nombre) from "+ tabla + ";";
		int cantidad = 0;
		
		try {
			st = conex.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				cantidad = rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return cantidad;
		
	}
	
	public static String obtenerNombre(String tabla){

		id = rm.nextInt(204)+1;
		String sql= String.format("Select nombre from %s where id_nombre= %d",tabla,id);
		
		
		try {
			st = conex.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				nombreObt = rs.getString(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return nombreObt;
		
		//conex.close();
		//st.close();
		
	}
	
	public void insertenUno(int cantidad, String tablaObtencion){
		
		for (i = 0; i < cantidad; i++) {
		id = rm.nextInt(204)+1;
		String sql= String.format("Select nombre from %s where id_nombre= %d",tablaObtencion,id);
		try {
			st = conex.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				nombreObt = rs.getString(1);
			}
			String sql2= String.format("insert into prueba values (null,'%s');",nombreObt);
			st = conex.createStatement();
			st.executeUpdate(sql2);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		}
		System.out.println(String.format("Se insertaron %d registros",i));
	}
	
	
	
	//Se ocupa para llenar tablas desde un arreglo de caenas
	/*public void insertarNombres(){
		
		for (int i = 0; i < nombresN.length; i++) {
			String sql="insert into nombres values (null,'"+nombresN[i]+"');";
			
		
		
		
			try {
				st = conex.createStatement();
				st.executeUpdate(sql);
				//conex.close();
				//st.close();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Insetado");
	}*/
}

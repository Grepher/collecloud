package com.jargelo.skt;

import com.jargelo.net.modelo.Conexion;

public class Cliente{
	private int ID;
	private String nombre;
	private String apaterno;
	private String amaterno;
	private Conexion conexion;
	
	public Cliente(Conexion conexion){
		this.conexion = conexion;
	}
	
	public int getID() {
		return ID;
	}
	
	public void setID(int iD) {
		ID = iD;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApaterno() {
		return apaterno;
	}
	
	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}
	
	public String getAmaterno() {
		return amaterno;
	}
	
	public void setAmaterno(String amaterno) {
		this.amaterno = amaterno;
	}
	
	public String alta(){
		String resultado = conexion.ejecutarSentencia("INSERT INTO Empleado VALUES(null,'"+nombre+"','"+apaterno+"','"+amaterno+"');");
		if(resultado.equalsIgnoreCase("true"))
			return "Registro insertado correctamente";
		else
			return resultado;
	}
	
	public String baja(){
		String resultado = conexion.ejecutarSentencia("DELETE FROM Empleado WHERE idEmpl = '"+ID+"';");
		if(resultado.equalsIgnoreCase("true"))
			return "Registro eliminado correctamente";
		else
			return resultado;
	}
	
	public String cambio(){
		String resultado = conexion.ejecutarSentencia("UPDATE Empleado SET nombre = '"+nombre+"', apPat = '"+apaterno+"', apMat = '"+amaterno+"' WHERE idEmpl = '"+ID+"';");
		if(resultado.equalsIgnoreCase("true"))
			return "Registro modificado correctamente";
		else
			return resultado;
	}
	
	public String consulta(){
		String resultadoConsulta = conexion.ejecutarConsulta("SELECT nombre,apPat,apMat FROM Empleado WHERE idEmpl = '"+ID+"';");
		return resultadoConsulta;
	}
	
	public int consultaUltimoID(){
		String ultimaId = conexion.ejecutarConsulta("SELECT MAX(IdEmpl) FROM Empleado;");
		int siguienteID;
		try{
			siguienteID = Integer.parseInt(ultimaId);
		}catch(NumberFormatException e){
			siguienteID = 0;
		}
		return siguienteID;
	}
	
	public boolean existeID(String ID) {
		String IDConfirmada = conexion.ejecutarConsulta("SELECT idEmpl FROM Empleado WHERE idEmpl = '"+ID+"';");
		if(IDConfirmada.equalsIgnoreCase(ID))
			return true;
		else
			return false;
	}
	
}

package com.jargelo.mvc;

public class Controlador {
	private Modelo modelo;
	
	public static void main(String[] args) {
		// new Logger(new Controlador().getClass().getSimpleName()).mostrarMensaje("titulo", "mensaje");
	}

	public void setModelo(Modelo modelo) {
		this.modelo = modelo;
		modelo.establecerConexion();
	}
	
	public void gestionarAltas(int cve_empleado, String nombres, String a_paterno, String a_materno, String puesto, String f_nacimiento, String f_ingreso, double sueldo){
		if(modelo.ejecutarSentencia("INSERT INTO empleados VALUES("+cve_empleado+",'"+nombres+"','"+a_paterno+"','"+a_materno+"','"+puesto+"','"+f_nacimiento+"','"+f_ingreso+"',"+sueldo+");"))
			modelo.notificarUsuario("Inserción realizada correctamente",2);
		else
			modelo.notificarUsuario("Inserción no completada",1);
	}

	public void gestionarConsulta() {
		if(modelo.enviarTabla("SELECT * FROM empleados;"))
			modelo.notificarUsuario("Consulta realizada correctamente",2);
		else
			modelo.notificarUsuario("No se encontraron registros",1);
	}
	
	public void gestionarConsulta(String clause) {
		if(modelo.enviarTabla("SELECT * FROM empleados WHERE cve_empleado='"+clause+"';"))
			modelo.notificarUsuario("Búsqueda realizada correctamente",2);
		else
			modelo.notificarUsuario("No se encontraron coincidencias",1);
	}
	
}

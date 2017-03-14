package com.jargelo.skt;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Scanner;

//import adiciones.// Logger;

import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ServicioABCQ implements Runnable{
	private Socket socketCliente;
	private DataInputStream entradaDatos;
	private DataOutputStream salidaDatos;
	private Cliente cliente;
	
	public ServicioABCQ(Socket socket, Conexion conexion){
		socketCliente = socket;
		this.cliente = new Cliente(conexion);
		try{
			InputStream entrada = socketCliente.getInputStream();
			entradaDatos = new DataInputStream(entrada);
			OutputStream salida = socketCliente.getOutputStream();
			salidaDatos = new DataOutputStream(salida);
		}catch(IOException e){
//			// Logger.logMessage("Error en (Servidor) BaseDeDatos.BaseDeDatos()\r\n"+e);
		}
	}
	
	private void registrarOperacionCliente(String resume){
		String rutaLog = (socketCliente.getRemoteSocketAddress()+" ("+(new SimpleDateFormat("yyyy_MM_dd").format(new Date()))+").log").substring(1).replace(':', '_');
		try{
			FileWriter fileWriter = new FileWriter(rutaLog,true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			PrintWriter printWriter = new PrintWriter(bufferedWriter);
			
			printWriter.append(resume+"\r\n");
			printWriter.close();
		}catch(IOException e){
			System.out.println("Error al acceder al archivo de log: '"+rutaLog+"'");
		}
	}
	
	private void recibirPeticion(){
		String peticion;
		try{
			//// Logger.logMessage("");
			peticion = entradaDatos.readUTF();
			switch(peticion){
				case "ALTA":
					// Logger.logMessage("\r\nAtendiendo solicitud de ALTA del cliente: "+socketCliente.getRemoteSocketAddress());
					// Logger.logMessage("( "+new Date()+" )");
					if(recibirDatos(false))
						enviarResultado(cliente.alta());
				break;
				case "BAJA":
					// Logger.logMessage("\r\nAtendiendo solicitud de BAJA del cliente: "+socketCliente.getRemoteSocketAddress());
					// Logger.logMessage("( "+new Date()+" )");
					if(recibirDatos(true))
						enviarResultado(cliente.baja());
				break;
				case "CAMBIO":
					// Logger.logMessage("\r\nAtendiendo solicitud de CAMBIO del cliente: "+socketCliente.getRemoteSocketAddress());
					// Logger.logMessage("( "+new Date()+" )");
					if(recibirDatos(false))
						enviarResultado(cliente.cambio());
				break;
				case "CONSULTA":
					// Logger.logMessage("\r\nAtendiendo solicitud de CONSULTA del cliente: "+socketCliente.getRemoteSocketAddress());
					// Logger.logMessage("( "+new Date()+" )");
					if(recibirDatos(true)){
						enviarResultado("Registro encontrado");
						enviarRegistros();
					}
				break;
				case "CONSULTAR ULTIMO ID":
					// Logger.logMessage("\r\nAtendiendo solicitud de CONSULTAR ULTIMO ID del cliente: "+socketCliente.getRemoteSocketAddress());
					// Logger.logMessage("( "+new Date()+" )");
					enviarResultado(String.valueOf(cliente.consultaUltimoID()));
				break;
				case "REGISTRAR":
					registrarOperacionCliente(entradaDatos.readUTF());
				break;
				case "SALIR":
					// Logger.logMessage("\r\n"+socketCliente.getLocalAddress()+" ("+socketCliente.getRemoteSocketAddress()+") se desconectó");
					// Logger.logMessage("( "+new Date()+" )");
					socketCliente.close();
				break;
			}
		}catch(IOException e){
			
		}
		if(!socketCliente.isClosed())
			recibirPeticion();
	}
	
	private boolean recibirDatos(boolean requiereId){
		// Logger.logMessage("Esperando datos...");
		try{
			if(!requiereId){
				cliente.setNombre(entradaDatos.readUTF());
				// Logger.logMessage("Leído el nombre: "+cliente.getNombre());
				cliente.setApaterno(entradaDatos.readUTF());
				// Logger.logMessage("Leído el apellido paterno: "+cliente.getApaterno());
				cliente.setAmaterno(entradaDatos.readUTF());
				// Logger.logMessage("Leído el apellido materno: "+cliente.getAmaterno());
				return true;
			}else{
				String cadenaID = entradaDatos.readUTF();
				try{
					cliente.setID(Integer.parseInt(cadenaID));
					// Logger.logMessage("Leído el ID: "+cliente.getID());
					if(cliente.getID()<=0){
						// Logger.logMessage("Enviando error de iD menor o igual a 0");
						enviarError(": el ID ingresado es menor o igual a 0");
					}else if(!cliente.existeID(cadenaID)){
						// Logger.logMessage("Enviando error de iD no existente");
						enviarError(": el ID ingresado no coincide con ningun registro");
					}else
						return true;
				}catch(NumberFormatException e){
					// Logger.logMessage("Enviando error de iD no válido");
					if(cadenaID.isEmpty())
						enviarError(": escriba un número mayor a 0 en el campo ID");
					else
						enviarError(": el ID  "+'"'+" "+cadenaID+" "+'"'+"  no es un número mayor a 0 válido");
				}
			}
		}catch(IOException e){
			// Logger.logMessage("Error en recibirDatos()\r\n"+e);
		}
		return false;
	}
	
	private void enviarRegistros(){
		@SuppressWarnings("resource")
		Scanner resultadoConsulta = new Scanner(cliente.consulta());
		String lineaLeida = "";
		try{
			while(resultadoConsulta!=null){
				lineaLeida = resultadoConsulta.nextLine();
				enviarResultado(lineaLeida);
			}
		}catch(NoSuchElementException e){
			
		}
	}
	
	private void enviarResultado(String resultado){
		try{
			//// Logger.logMessage("Enviando resultado...\r\n*******\r\n"+resultado+"\r\n*******");
			// Logger.logMessage("Enviando resultado...\r\n\t"+resultado);
			salidaDatos.writeUTF(resultado);
		}catch(IOException e){
			// Logger.logMessage("Error en enviarResultado()\r\n"+e);
		}
	}
	
	private void enviarError(String error){
		try{
			salidaDatos.writeUTF("Error"+error);
		}catch(IOException e){
			// Logger.logMessage("Error en enviarError()\r\n"+e);
		}
	}
	
	@Override
	public void run(){
		recibirPeticion();
	}
	
}

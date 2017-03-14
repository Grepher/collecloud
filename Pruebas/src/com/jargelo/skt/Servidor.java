package com.jargelo.skt;

import java.net.ServerSocket;
import java.net.Socket;

import java.io.IOException;
//import java.util.Date;

//import adiciones.Logger;

public class Servidor{
	private int puerto;
	private int capacidadClientes;
	
	public Servidor(){
		puerto = 1700;
		capacidadClientes = 33;
	}
	
	public static void main(String[] args){
		Servidor servidor = new Servidor();
//		Logger.logMessage("\t*** INICIO DEL SERVIDOR ***\t( "+new Date()+" )");
		Thread[] hilosCliente = new Thread[servidor.capacidadClientes];
		
		try{
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(servidor.puerto);
//			Logger.logMessage("Escuchando el puerto "+servidor.puerto+"...");
			
			int nConexiones = 0;
			Conexion conexion = new Conexion();
			
			while(0<=servidor.capacidadClientes){
				Socket socketCliente = serverSocket.accept();
				
				hilosCliente[nConexiones] = new Thread(new ServicioABCQ(socketCliente,conexion));
				hilosCliente[nConexiones].start();
				
//				Logger.logMessage("\r\nAtendiendo al cliente: "+socketCliente.getLocalAddress()+" ("+socketCliente.getRemoteSocketAddress()+")");
				servidor.capacidadClientes--;
//				Logger.logMessage("quedan: "+servidor.capacidadClientes+" conexiones otorgables");
				
				nConexiones++;
			}
		}catch(IOException e){
//			Logger.logMessage("Error en Servidor.main()\r\n"+e);
		}
	}
	
}

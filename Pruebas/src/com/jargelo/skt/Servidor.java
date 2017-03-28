package com.jargelo.skt;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import com.jargelo.net.modelo.Conexion;

public class Servidor {
	private int puerto;
	private int capacidadClientes;

	public Servidor() {
		puerto = 1700;
		capacidadClientes = 33;
	}

	public static void main(String[] args) {
		Servidor servidor = new Servidor();
		Thread[] hilosCliente = new Thread[servidor.capacidadClientes];

		try {
			@SuppressWarnings("resource")
			ServerSocket serverSocket = new ServerSocket(servidor.puerto);
			int nConexiones = 0;
			Conexion conexion = new Conexion();

			while (0 <= servidor.capacidadClientes) {
				Socket socketCliente = serverSocket.accept();

				hilosCliente[nConexiones] = new Thread(new ServicioABCQ(socketCliente, conexion));
				hilosCliente[nConexiones].start();

				servidor.capacidadClientes--;
				nConexiones++;
			}
		} catch (IOException e) {
		}
	}

}

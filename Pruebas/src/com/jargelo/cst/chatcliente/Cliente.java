package com.jargelo.cst.chatcliente;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.swing.JEditorPane;

/**
 *
 * @author david
 */
public class Cliente implements Runnable {
	// Declaramos las variables necesarias para la conexion y comunicacion
	private Socket cliente;
	private DataInputStream in;
	private DataOutputStream out;
	// El puerto debe ser el mismo en el que escucha el servidor
	private int puerto = 2027;
	// Si estamos en nuestra misma maquina usamos localhost si no la ip de la
	// maquina servidor
	private String host = "10.12.0.11";
	private String mensajes = "";
	JEditorPane panel;

	// Constructor recibe como parametro el panel donde se mostraran los
	// mensajes
	public Cliente(JEditorPane panel) {
		this.panel = panel;
		try {
			cliente = new Socket(host, puerto);
			in = new DataInputStream(cliente.getInputStream());
			out = new DataOutputStream(cliente.getOutputStream());
			System.out.println("la ip es " + cliente.getInetAddress());
			System.out.println("socketLocal " + cliente.getLocalSocketAddress());
			System.out.println("conectado " + cliente.isConnected());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void run() {
		try {
			// Ciclo infinito que escucha por mensajes del servidor y los
			// muestra en el panel
			while (true) {
				mensajes += in.readUTF();
				panel.setText(mensajes);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Funcion sirve para enviar mensajes al servidor
	public void enviarMsg(String msg) {
		try {
			out.writeUTF(msg);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}

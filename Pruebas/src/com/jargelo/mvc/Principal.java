package com.jargelo.mvc;


public class Principal{
	
	public static void main(String[] args) {
		Controlador controlador = new Controlador();
		Vista vista = new Vista(controlador);
		Modelo modelo = new Modelo(vista);
		controlador.setModelo(modelo);
		vista.iniciarAplicación();
	}
	
}

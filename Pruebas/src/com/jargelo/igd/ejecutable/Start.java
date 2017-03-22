package com.jargelo.igd.ejecutable;

import java.io.IOException;
import java.util.Scanner;

public class Start {

	public static void main(String[] args) throws IOException {
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		Metodos nt = new Metodos();
		Archivo ar = new Archivo();
		
		
		System.out.println("Elija una opción; \n 1) Crear archivo. \n 2) Ingresar nombres aleatoreos.");
		int opcion = sc.nextInt();
		
		switch (opcion) {
		case 1:
			System.out.println("¿Qué tipo de archivo quieres crear? \n 1) .txt \n 2) .sql");
			int tipo = sc.nextInt();
			switch (tipo) {
			case 1:
				String nombreAr = "archivo.txt";
				String ruta = String.format("E:/%s",nombreAr);
				ar.crearArchivo(ruta);
				break;
			
			case 2:
				nombreAr = "archivo.sql";
				ruta = String.format("E:/%s",nombreAr);
				ar.crearArchivo(ruta);
				break;

			default:
				break;
			}
			
			break;
			
		case 2:
			System.out.println("¿Cuántos registros quieres?");
			int cant = sc.nextInt();
			nt.insertar(cant,"nombres");
			//nt.insertenUno(cant, "nombres");
			break;

		default:
			break;
		}
		
		
		
		//nt.insertarNombres();
		
		
		
		
		//Colocar cuantos registros se quieren y de que tabla obtendrá los registros
		//nt.insertar(1000000,"nombres");
	}
	


}

package com.jargelo.dev;

import java.util.Scanner;

public class Carrera {
	private int edadInferiorDeInscripcion;
	private int edadSuperiorDeInscripcion;
	
	public Carrera(){
		this.edadInferiorDeInscripcion = 18;
		this.edadSuperiorDeInscripcion = 40;
	}
	
	public static void main(String[] args) {
		/*
		System.out.println("Corriendo a 20km/hr tardas "+(float)(10*60)/20+" minutos");
		System.out.println("Esto es el "+(float)20/20*100+"% de la velocidad simulada ("+(float)(10*30)/20+" ms)");
		System.out.println();
		System.out.println("Corriendo a 18km/hr tardas "+(float)(10*60)/18+" minutos");
		System.out.println("Esto es el "+(float)18/20*100+"% de la velocidad simulada ("+(float)(10*30)/18+" ms)");
		System.out.println();
		System.out.println("Corriendo a 15km/hr tardas "+(float)(10*60)/15+" minutos");
		System.out.println("Esto es el "+(float)15/20*100+"% de la velocidad simulada ("+(float)(10*30)/15+" ms)");
		System.out.println();
		*/
		Carrera carrera = new Carrera();
		boolean usarArreglo = true;
		if(usarArreglo)
			carrera.registrarCorredorConArreglos();
		else
			carrera.registrarCorredor();
	}
	
	@SuppressWarnings("resource")
	private void registrarCorredor() {
		// Obtenci�n del nombre
		System.out.print("Ingresa el nombre del corredor: "+1+" ");
		String nomCorredor1 = new Scanner(System.in).nextLine();
		
		// Obtencion de la edad
		boolean repetirEdad = true;
		int edad1 = 0;
		do
			try{
				System.out.print("Ingresa la edad del corredor: "+1+" ");
				edad1 = Integer.parseInt(new Scanner(System.in).nextLine());
				if(edad1<edadInferiorDeInscripcion){
					System.out.println("La edad de inscripci�n no puede ser menor a: "+edadInferiorDeInscripcion+" a�os\n");
				}else if(edad1>edadSuperiorDeInscripcion){
					System.out.println("La edad de inscripci�n no puede ser mayor a: "+edadSuperiorDeInscripcion+" a�os\n");
				}else
					repetirEdad = false;
			}catch(NumberFormatException e){
				System.out.println("La edad ingresada no es v�lida\n");
			}
		while(repetirEdad);
		System.out.println();
		
		// Inicializaci�n del corredor
		Corredor corredor1 = new com.jargelo.dev.Corredor(edad1, 1, 10);
		corredor1.setTipoCarrera(1);
		
		// Incializaci�n del hilo
		Thread carril1 = new Thread(corredor1);
		carril1.setName(nomCorredor1);
		
		// Obtenci�n del nombre
		System.out.print("Ingresa el nombre del corredor: "+2+" ");
		String nomCorredor2 = new Scanner(System.in).nextLine();
		
		// Obtencion de la edad
		boolean repetirEdad2 = true;
		int edad2 = 0;
		do
			try{
				System.out.print("Ingresa la edad del corredor: "+2+" ");
				edad2 = Integer.parseInt(new Scanner(System.in).nextLine());
				if(edad2<edadInferiorDeInscripcion){
					System.out.println("La edad de inscripci�n no puede ser menor a: "+edadInferiorDeInscripcion+" a�os\n");
				}else if(edad2>edadSuperiorDeInscripcion){
					System.out.println("La edad de inscripci�n no puede ser mayor a: "+edadSuperiorDeInscripcion+" a�os\n");
				}else
					repetirEdad2 = false;
			}catch(NumberFormatException e){
				System.out.println("La edad ingresada no es v�lida\n");
			}
		while(repetirEdad2);
		System.out.println();
		
		// Inicializaci�n del corredor
		Corredor corredor2 = new Corredor(edad2, 1, 10);
		corredor2.setTipoCarrera(1);
		
		// Incializaci�n del hilo
		Thread carril2 = new Thread(corredor2);
		carril2.setName(nomCorredor2);
		
		// Obtenci�n del nombre
		System.out.print("Ingresa el nombre del corredor: "+3+" ");
		String nomCorredor3 = new Scanner(System.in).nextLine();
		
		// Obtencion de la edad
		boolean repetirEdad3 = true;
		int edad3 = 0;
		do
			try{
				System.out.print("Ingresa la edad del corredor: "+3+" ");
				edad3 = Integer.parseInt(new Scanner(System.in).nextLine());
				if(edad3<edadInferiorDeInscripcion){
					System.out.println("La edad de inscripci�n no puede ser menor a: "+edadInferiorDeInscripcion+" a�os\n");
				}else if(edad3>edadSuperiorDeInscripcion){
					System.out.println("La edad de inscripci�n no puede ser mayor a: "+edadSuperiorDeInscripcion+" a�os\n");
				}else
					repetirEdad3 = false;
			}catch(NumberFormatException e){
				System.out.println("La edad ingresada no es v�lida\n");
			}
		while(repetirEdad3);
		System.out.println();
		
		// Inicializaci�n del corredor
		Corredor corredor3 = new Corredor(edad3, 1, 10);
		corredor3.setTipoCarrera(1);
		
		// Incializaci�n del hilo
		Thread carril3 = new Thread(corredor3);
		carril3.setName(nomCorredor3);
		
		// Obtenci�n del nombre
		System.out.print("Ingresa el nombre del corredor: "+4+" ");
		String nomCorredor4 = new Scanner(System.in).nextLine();
		
		// Obtencion de la edad
		boolean repetirEdad4 = true;
		int edad4 = 0;
		do
			try{
				System.out.print("Ingresa la edad del corredor: "+4+" ");
				edad4 = Integer.parseInt(new Scanner(System.in).nextLine());
				if(edad4<edadInferiorDeInscripcion){
					System.out.println("La edad de inscripci�n no puede ser menor a: "+edadInferiorDeInscripcion+" a�os\n");
				}else if(edad4>edadSuperiorDeInscripcion){
					System.out.println("La edad de inscripci�n no puede ser mayor a: "+edadSuperiorDeInscripcion+" a�os\n");
				}else
					repetirEdad4 = false;
			}catch(NumberFormatException e){
				System.out.println("La edad ingresada no es v�lida\n");
			}
		while(repetirEdad4);
		System.out.println();
		
		// Inicializaci�n del corredor
		Corredor corredor4 = new Corredor(edad4, 1, 10);
		corredor4.setTipoCarrera(1);
		
		// Incializaci�n del hilo
		Thread carril4 = new Thread(corredor4);
		carril4.setName(nomCorredor4);
		
		//Obtenci�n del nombre
		System.out.print("Ingresa el nombre del corredor: "+5+" ");
		String nomCorredor5 = new Scanner(System.in).nextLine();
		
		//Obtencion de la edad
		boolean repetirEdad5 = true;
		int edad5 = 0;
		do
			try{
				System.out.print("Ingresa la edad del corredor: "+5+" ");
				edad5 = Integer.parseInt(new Scanner(System.in).nextLine());
				if(edad5<edadInferiorDeInscripcion){
					System.out.println("La edad de inscripci�n no puede ser menor a: "+edadInferiorDeInscripcion+" a�os\n");
				}else if(edad5>edadSuperiorDeInscripcion){
					System.out.println("La edad de inscripci�n no puede ser mayor a: "+edadSuperiorDeInscripcion+" a�os\n");
				}else
					repetirEdad5 = false;
			}catch(NumberFormatException e){
				System.out.println("La edad ingresada no es v�lida\n");
			}
		while(repetirEdad5);
		System.out.println();
		
		//Inicializaci�n del corredor
		Corredor corredor5 = new Corredor(edad5, 1, 10);
		corredor5.setTipoCarrera(1);
		
		//Incializaci�n del hilo
		Thread carril5 = new Thread(corredor5);
		carril5.setName(nomCorredor5);
		
		// Inicio carrera
		carril1.start();
		System.out.println(nomCorredor1+" Oy� el disparo");
		carril2.start();
		System.out.println(nomCorredor2+" Oy� el disparo");
		carril3.start();
		System.out.println(nomCorredor3+" Oy� el disparo");
		carril4.start();
		System.out.println(nomCorredor4+" Oy� el disparo");
		carril5.start();
		System.out.println(nomCorredor5+" Oy� el disparo");
		/*
		try{
			carril1.sleep(corredor1.obtenerRetraso());
			System.out.println("Se retras�: "+nomCorredor1);
			carril2.sleep(corredor2.obtenerRetraso());
			System.out.println("Se retras�: "+nomCorredor2);
			carril3.sleep(corredor3.obtenerRetraso());
			System.out.println("Se retras�: "+nomCorredor3);
			carril4.sleep(corredor4.obtenerRetraso());
			System.out.println("Se retras�: "+nomCorredor4);
			carril5.sleep(corredor5.obtenerRetraso());
			System.out.println("Se retras�: "+nomCorredor5);
		}catch(InterruptedException e){
			
		}
		*/
	}
	
	@SuppressWarnings({ "unused", "resource" })
	private void registrarCorredorConArreglos() {
		// Obtenenci�n del n�mero de corredores
		boolean repetirNumCorredores = true;
		int numCorredores = 0;
		do
		try{
			System.out.print("Ingresa el n�mero de corredores: ");
			numCorredores = Integer.parseInt(new Scanner(System.in).nextLine());
			if(numCorredores>0)
				repetirNumCorredores = false;
			else
				System.out.println("El n�mero de corredoresdebe ser mayor a 0\n");
		}catch(NumberFormatException e){
			System.out.println("El n�mero de corredores no es v�lido\n");
		}
		while(repetirNumCorredores);
		
		// Creaci�n de los arreglos necesarios
		String[] nomCorredor = new String[numCorredores+1];
		int[] edad = new int[numCorredores+1];
		Corredor[] corredor = new Corredor[numCorredores+1];
		Thread[] carril = new Thread[numCorredores+1];
		
		for(int c=1;c<=numCorredores;c++){
			// Obtenci�n de los nombres
			System.out.print("\nIngresa el nombre del corredor: "+c+" ");
			nomCorredor[c] = new Scanner(System.in).nextLine();
			
			// Obtencion de las edades
			boolean repetirEdad = true;
			do
				try{
					System.out.print("Ingresa la edad del corredor: "+c+" ");
					edad[c] = Integer.parseInt(new Scanner(System.in).nextLine());
					if(edad[c]<edadInferiorDeInscripcion){
						System.out.println("La edad de inscripci�n no puede ser menor a: "+edadInferiorDeInscripcion+" a�os\n");
					}else if(edad[c]>edadSuperiorDeInscripcion){
						System.out.println("La edad de inscripci�n no puede ser mayor a: "+edadSuperiorDeInscripcion+" a�os\n");
					}else
						repetirEdad = false;
				}catch(NumberFormatException e){
					System.out.println("La edad ingresada no es v�lida\n");
				}
			while(repetirEdad);
		}
		System.out.println();
		
		for(int c=1;c<=numCorredores;c++){
			// Inicializaci�n del corredor
			corredor[c] = new Corredor(edad[c], 1, 10, false);
			corredor[c].setTipoCarrera(1);
			
			// Incializaci�n del hilo
			carril[c] = new Thread(corredor[c]);
			carril[c].setName(nomCorredor[c]);
		}
		
		System.out.println("Lista de Rangers corredores");
		System.out.println("Nombre"+"\t\t"+"Edad");
		for(int c=1;c<=numCorredores;c++){
			System.out.println(" "+nomCorredor[c]+"\t\t"+edad[c]);
		}
		
		System.out.println("\nPresiona ENTER para comenzar!!");
		String noImporta = new Scanner(System.in).nextLine();
		System.out.println("\nGo go Power Rangers!!!");
				
		for(int c=1;c<=numCorredores;c++){
			// Inicio carrera
			carril[c].start();
			System.out.println(nomCorredor[c]+" Oy� el disparo");
		}
		
		/*
		// Agregar retraso
		for(int c=1;c<=numCorredores;c++){
			try{
				Thread.sleep(corredor[c].obtenerRetraso());
				System.out.println("Se retras�: "+nomCorredor[c]);
			}catch(InterruptedException e){
				
			}
		}
		*/
	}
	
}

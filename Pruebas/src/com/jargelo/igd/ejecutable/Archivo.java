package com.jargelo.igd.ejecutable;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Archivo {
	public void crearArchivo(String ruta) throws IOException{
		File archivo = new File(ruta);
		BufferedWriter bw;
		
		if(archivo.exists()){
			System.out.println("Archivo ya creado");
			
		}else{
			bw = new BufferedWriter(new FileWriter(archivo));
			for (int i = 0; i < 100; i++) {
				bw.write("hola");
			}
			
			
			System.out.println("Se creó corrctamente");
		}
		
	}
}

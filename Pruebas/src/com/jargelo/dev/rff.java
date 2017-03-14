package com.jargelo.dev;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class rff {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		cargarArchivoSQL();
	}
	
	public static boolean cargarArchivoSQL() {
		try {
			String command = "\"C:\\Program Files\\WampServer\\bin\\mysql\\mysql5.5.8\\bin\\mysqldump\" -u root base";
			Process cmd = Runtime.getRuntime().exec(command);
			OutputStream outputStream = cmd.getOutputStream();
			FileInputStream fileInputStream = new FileInputStream(
					"C:\\base.sql");
			
			InputStream es = cmd.getErrorStream();
			Thread hiloError = new Thread() {
			   @Override
			public void run() {
			      try {
			         byte[] buffer = new byte[1024];
			         int leido = es.read(buffer);
			         while (leido > 0) {
			            System.out.println(new String(buffer, 0, leido));
			            leido = es.read(buffer);
			         }
			         es.close();
			      } catch (Exception e) {
			         e.printStackTrace();
			      }
			   }
			};
			hiloError.start();
			
			byte[] buffer = new byte[1024];
			int leido = fileInputStream.read(buffer);
			while (leido > 0) {
				System.out.println(new String(buffer, 0, leido));
				outputStream.write(buffer, 0, leido);
				leido = fileInputStream.read(buffer);
			}
			outputStream.flush();
			outputStream.close();
			fileInputStream.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

}

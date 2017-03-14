package com.jargelo.dev;

public class Pruebas {

	public static void main(String[] args) {
//		// conexion.seEjecuto("USE " + obtenerNombre() + ";");
//		// conexion.seEjecuto("INSERT INTO "
//		// + tablasAleatorias.elementAt(indice).obtenerNombre()
//		// + " VALUES(\""
//		// + tablasAleatorias.elementAt(indice).getRegistros()
//		// .replace(", ", "\",\"").replace("],[", "\"),(\"")
//		// + "\");");
//		
//		Conexion conexion = new Conexion("root", null, Conexion.MYSQL, "localhost", "fountainData");
//		Database base = new Database("db_20160203");
//		base.crear(conexion);
//		conexion = new Conexion("root", null, Conexion.MYSQL, "localhost", "db_20160203");
//		conexion.seEjecuto("USE db_20160203;");
//		// conexion.seEjecuto("source ");
//		// base.cargarArchivoSQL("dfdgfdgd");
		
//		JFrame ventana = new JFrame();
//		ventana.add(new JPanel().add(new TablaSwing(new String[][] {{"we","","we"},{"",null,""}})));
//		ventana.setVisible(true);
	}

	// public boolean cargarArchivoSQL(String contenidoArchivo) {
	// FileInputStream fileInputStream = null;
	// try {
	// fileInputStream = new FileInputStream(new
	// Consulta(conexion).getBaseDirectory() + "data\\"
	// + obtenerNombre() + "\\" + obtenerNombre() + ".sql");
	// } catch (FileNotFoundException e1) {
	// // TODO Auto-generated catch block
	// e1.printStackTrace();
	// }
	// try {
	// String command = "\"" + new Consulta(conexion).getBaseDirectory() +
	// "bin\\mysqldump\" -u root "
	// + obtenerNombre() + " ";
	// Process cmd = Runtime.getRuntime().exec(command);
	// OutputStream outputStream = cmd.getOutputStream();
	//
	// OutputStreamWriter osw = new OutputStreamWriter(outputStream);
	// osw.append(archivo.leer(new File(new
	// Consulta(conexion).getBaseDirectory() + "data\\"
	// + obtenerNombre() + "\\" + obtenerNombre() + ".sql")));
	// osw.flush();
	//
	//// new OutputStreamWriter(outputStream).write(archivo.leer(new File(new
	// Consulta(conexion).getBaseDirectory() + "data\\"
	//// + obtenerNombre() + "\\" + obtenerNombre() + ".sql")));
	//
	//// BufferedWriter bufferredWriter = new BufferedWriter(new
	// OutputStreamWriter(outputStream));
	//// bufferredWriter.write(archivo.leer(new File(new
	// Consulta(conexion).getBaseDirectory() + "data\\"
	//// + obtenerNombre() + "\\" + obtenerNombre() + ".sql")));
	//// bufferredWriter.flush();
	//// bufferredWriter.close();
	//
	//
	// byte[] buffer = new byte[1024];
	// int leido = fileInputStream.read(buffer);
	// while (leido > 0) {
	// outputStream.write(buffer, 0, leido);
	// leido = fileInputStream.read(buffer);
	//
	// }
	// outputStream.flush();
	// outputStream.close();
	// fileInputStream.close();
	// logger.logMessage("Archivo SQL cargado");
	//
	// return true;
	// } catch (IOException e) {
	// e.printStackTrace();
	// }
	// return false;
	// }

}

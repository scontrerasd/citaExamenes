package servicios;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import modelo.Cita;

public class EscribeArchivo {

	private String rutaArchivo;

	public EscribeArchivo(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}

	public void escribir_fecha(Cita cita){
		File file= new File(rutaArchivo);
		FileWriter fileWriter;
		PrintWriter printWriter;
		
		if (file.exists()) {
		   try {
			fileWriter = new FileWriter(file,true);
            printWriter = new PrintWriter(fileWriter);
			printWriter.println(cita.getFecha());
			if (printWriter != null) {
				printWriter.close();
			}
			if (fileWriter != null) {
				fileWriter.close();
			}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
		   try {
			fileWriter = new FileWriter(file);
	        printWriter = new PrintWriter(fileWriter);
			printWriter.println(cita.getFecha());
			if (printWriter != null) {
				printWriter.close();
			}
			if (fileWriter != null) {
				fileWriter.close();
			}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void escribir_cita(Cita cita){
		File file= new File(rutaArchivo);
		FileWriter fileWriter;
		PrintWriter printWriter;
		
		if (file.exists()) {
		   try {
			fileWriter = new FileWriter(file,true);
            printWriter = new PrintWriter(fileWriter);
            printWriter.println(cita.getHora() + "|" + cita.toString());
			if (printWriter != null) {
				printWriter.close();
			}
			if (fileWriter != null) {
				fileWriter.close();
			}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
		   try {
			fileWriter = new FileWriter(file);
	        printWriter = new PrintWriter(fileWriter);
            printWriter.println(cita.getHora() + "|" + cita.toString());
			if (printWriter != null) {
				printWriter.close();
			}
			if (fileWriter != null) {
				fileWriter.close();
			}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

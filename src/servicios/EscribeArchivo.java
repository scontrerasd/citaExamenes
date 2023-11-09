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
		FileWriter fw;
		PrintWriter pw;
		
		if (file.exists()) {
		   try {
			fw = new FileWriter(file,true);
            pw = new PrintWriter(fw);
			pw.println(cita.getFecha());
			if (pw != null) {
				pw.close();
			}
			if (fw != null) {
				fw.close();
			}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
		   try {
			fw = new FileWriter(file);
	        pw = new PrintWriter(fw);
			pw.println(cita.getFecha());
			if (pw != null) {
				pw.close();
			}
			if (fw != null) {
				fw.close();
			}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void escribir_cita(Cita cita){
		File file= new File(rutaArchivo);
		FileWriter fw;
		PrintWriter pw;
		
		if (file.exists()) {
		   try {
			fw = new FileWriter(file,true);
            pw = new PrintWriter(fw);
            pw.println(cita.getHora() + "|" + cita.toString());
			if (pw != null) {
				pw.close();
			}
			if (fw != null) {
				fw.close();
			}
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
		   try {
			fw = new FileWriter(file);
	        pw = new PrintWriter(fw);
            pw.println(cita.getHora() + "|" + cita.toString());
			if (pw != null) {
				pw.close();
			}
			if (fw != null) {
				fw.close();
			}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

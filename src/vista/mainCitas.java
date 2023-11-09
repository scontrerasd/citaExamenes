package vista;

import java.util.ArrayList;
import java.io.IOException;

import modelo.Cita;
import servicios.LeeArchivo;
import servicios.LeeArchivoNuevaCita;
import servicios.EscribeArchivo;

public class mainCitas {
    public static void main(String[] args) {
		Cita cita = new Cita();
		ArrayList<Cita> citas= new ArrayList<Cita>();
		String fechaCitaAnterior = "2020-01-01";

        LeeArchivoNuevaCita leeGuardaNuevaCitaArchivo = new LeeArchivoNuevaCita("C:\\Tmp\\lab_input.txt");
		LeeArchivo leeGuardaCitasExistentes = new LeeArchivo("C:\\Tmp\\lab_input.txt");
        EscribeArchivo escribeCitasArchivo = new EscribeArchivo("C:\\Tmp\\lab_output.txt");

		try {
			cita=leeGuardaNuevaCitaArchivo.leer();
			escribeCitasArchivo.escribir_fecha(cita);

			citas=leeGuardaCitasExistentes.leer();
			for(Cita c:citas){
				if(!c.getFecha().equals(fechaCitaAnterior)){
					escribeCitasArchivo.escribir_fecha(c);
				}
				escribeCitasArchivo.escribir_cita(c);
				fechaCitaAnterior = c.getFecha();
            };
		} catch (IOException e){
			System.out.println("Error al leer o escribir el archivo.");
		}
    }
}
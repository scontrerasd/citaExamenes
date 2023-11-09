package servicios;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import modelo.Cita;
import modelo.Examen;
import modelo.Paciente;
import modelo.Apoderado;
import modelo.Calendario;

public class LeeArchivoNuevaCita {

	private String rutaArchivo;
	private Calendario calendario = new Calendario();

	public LeeArchivoNuevaCita(String rutaArchivo) {
		this.rutaArchivo = rutaArchivo;
	}

	public Cita leer() throws IOException {
		File file = new File(rutaArchivo);
		
		BufferedReader br = null;
		FileReader fileReader = null;
		
		String 		linea = "";
		String[] 	partes;
		Examen 		examen;
		Paciente 	paciente;
		Apoderado 	apoderado = new Apoderado();
		Cita 		cita = new Cita();
		Integer 	nuevaCitaenCurso = 0;
		try {
			fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);
			
			while ((linea = br.readLine()) != null) {
			if (linea.equals("NUEVA CITA") || nuevaCitaenCurso == 1) {
				nuevaCitaenCurso = 1;
				linea = br.readLine();
				
				partes=linea.split("\\|");

					examen = new Examen (partes[2], partes[3]);

					if (partes[5].equals("PMENOR")){
						paciente = new Paciente(partes[7], 		//identificacion
												partes[6], 		//tipoIdentificacion
												partes[4], 		//nombrePaciente
												partes[9], 		//fechaNacimiento
												partes[8], 		//telefono
												"@", //correoElectronico
												partes[5], 		//tipoPaciente
												partes[13]); 	//IdentificacionApoderado
						apoderado = new Apoderado(partes[13], 	//IdentificacionApoderado
												  partes[12], 	//tipoIdentificacionApoderado
												  partes[11], 	//nombreApoderado
												  partes[14], 	//fechaNacimientoApoderado
												  partes[8], 	//telefonoApoderado
												  "@", //correoElectronicoApoderado
												  "ADULTO"); //tipoPaciente
					} else {
						paciente = new Paciente(partes[7], 		//identificacion
												partes[6], 		//tipoIdentificacion
												partes[4], 		//nombrePaciente
												partes[9], 		//fechaNacimiento
												partes[8], 		//telefono
												"@", //correoElectronico
												partes[5], 		//tipoPaciente
												""); 	//IdentificacionApoderado
					}
					cita = new Cita(examen, paciente, apoderado, partes[0], partes[1]);
					System.out.println("Cita: " + cita.toString());
					calendario.agregarCita(cita);
					return cita;
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("No existe el archivo " + rutaArchivo);
			
		} catch (IOException e) {
			System.out.println("Error al leer el archivo " + rutaArchivo);
		} finally {
			try {
				if (br != null) {
					br.close();
				}
			} catch (IOException e) {
				System.out.println("Error al cerrar el BufferReader br.");
			}
			try {
				if (fileReader != null) {
					fileReader.close();
				}
			} catch (IOException e) {
				System.out.println("Error al cerrar el fileReader fr.");
			}
		}
		return cita;
	}
}

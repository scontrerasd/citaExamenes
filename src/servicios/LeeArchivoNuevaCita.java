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
		String ruta = file.getAbsolutePath();
		
		BufferedReader br = null;
		FileReader fileReader = null;
		
		String linea = "";
		String[] partes;
		Examen examen;
		Paciente paciente;
		Apoderado apoderado;
		Cita cita = new Cita();
		String fechaCita = "2020-01-01";
		Integer nuevaCitaenCurso = 0;
		try {
			fileReader = new FileReader(file);
			br = new BufferedReader(fileReader);
			
			while ((linea = br.readLine()) != null) {
			if (linea.equals("NUEVA CITA") || nuevaCitaenCurso == 1) {
				nuevaCitaenCurso = 1;
				linea = br.readLine();
				
				if (linea.equals("2023-10-24")) { //PENDIENTE: Quitar fechas quemadas
                    fechaCita = linea;
                } else {
					partes=linea.split("\\|");

					examen = new Examen (partes[1], partes[2]);

					if (partes[4].equals("PMENOR")){
						paciente = new Paciente(partes[6], 		//identificacion
												partes[5], 		//tipoIdentificacion
												partes[3], 		//nombrePaciente
												partes[8], 		//fechaNacimiento
												partes[7], 		//telefono
												"@", //correoElectronico
												partes[4], 		//tipoPaciente
												partes[12]); 	//IdentificacionApoderado
						apoderado = new Apoderado(partes[12], 	//IdentificacionApoderado
												  partes[11], 	//tipoIdentificacionApoderado
												  partes[10], 	//nombreApoderado
												  partes[13], 	//fechaNacimientoApoderado
												  partes[7], 	//telefonoApoderado
												  "@", //correoElectronicoApoderado
												  "ADULTO"); //tipoPaciente
					} else {
						paciente = new Paciente(partes[6], 		//identificacion
												partes[5], 		//tipoIdentificacion
												partes[3], 		//nombrePaciente
												partes[8], 		//fechaNacimiento
												partes[7], 		//telefono
												"@", //correoElectronico
												partes[4], 		//tipoPaciente
												""); //IdentificacionApoderado
					}
					cita = new Cita(examen, paciente, fechaCita, partes[0]);
					System.out.println("Cita: " + cita.toString());
					calendario.agregarCita(cita);
					return cita;
				}
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

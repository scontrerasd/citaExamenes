package modelo;

import servicios.AdminPersona;

public class Cita {
    private int id;
    private Examen examen;
    private Paciente paciente;
    private String fecha;
    private String hora;

    public Cita(){};

    public Cita(int id, Examen examen, Paciente paciente, String fecha, String hora) {
        this.id = 1;
        this.examen = examen;
        this.paciente = paciente;
        this.fecha = fecha;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        //return "Cita [Id=" + id + ", examen=" + examen + ", paciente=" + paciente + ", fecha=" + fecha + ", hora=" + hora + "]";
        if (paciente.getTipoPaciente().equals("PMENOR")) {
            return examen.getNombre() + "|" + examen.getTemprano() + "|" + paciente.getNombre() + "|"
            + paciente.getTipoPaciente() + "|" + paciente.getTipoIdentificacion() + "|" + paciente.getIdentificacion() + "|"
            + paciente.getTelefono() + "|"+ paciente.getFechaNacimiento() + "|";
            //+ (AdminPersona.buscarPorIdentificacion(paciente.getIdentificacionApoderado())).toString() ;
        } else {
            return examen.getNombre() + "|" + examen.getTemprano() + "|" + paciente.getNombre() + "|"
            + paciente.getTipoPaciente() + "|" + paciente.getTipoIdentificacion() + "|" + paciente.getIdentificacion() + "|"
            + paciente.getTelefono() + "|"+ paciente.getFechaNacimiento() + "|";
        }
    }

    public void mostrarDetalleCita() {
        System.out.println("Examen: " + examen);
        System.out.println("Paciente: " + paciente);
        System.out.println("Fecha: " + fecha);
        System.out.println("Hora: " + hora);
    }

}

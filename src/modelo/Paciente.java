package modelo;

public class Paciente extends Persona{
    private String IdentificacionApoderado;

    public Paciente(String identificacion, String tipoIdentificacion, String nombre,
            String fechaNacimiento, String telefono, String correoElectronico, String tipoPaciente,
            String identificacionApoderado) {
        super(identificacion, tipoIdentificacion, nombre, fechaNacimiento, telefono, correoElectronico,
                tipoPaciente);
        IdentificacionApoderado = identificacionApoderado;
    }

    public Paciente(String identificacionApoderado) {
        IdentificacionApoderado = identificacionApoderado;
    }

    public String getIdentificacionApoderado() {
        return IdentificacionApoderado;
    }

    public void setIdentificacionApoderado(String identificacionApoderado) {
        IdentificacionApoderado = identificacionApoderado;
    }

    @Override
    public String toString() {
        return "Paciente [IdentificacionApoderado=" + IdentificacionApoderado + "]";
    }
    
}

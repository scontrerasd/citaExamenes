package modelo;

import modelo.Apoderado;

public class Apoderado extends Persona{

    public Apoderado(String identificacion, String tipoIdentificacion, String nombre,
        String fechaNacimiento, String telefono, String correoElectronico, String tipoPaciente) {

        super(identificacion, tipoIdentificacion, nombre, fechaNacimiento, telefono, correoElectronico, tipoPaciente);
    }

    @Override
    public String toString() {
        return "APO" + "|" + getNombre() + "|" + getTipoIdentificacion() + "|" + getIdentificacion() + "|" + getFechaNacimiento() + "|";
    }

}

package modelo;

public class Examen {
    private String nombre;
    private String temprano;
    
    public Examen(String nombre, String temprano) {
        this.nombre = nombre;
        this.temprano = temprano;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTemprano() {
        return temprano;
    }

    public void setTemprano(String temprano) {
        this.temprano = temprano;
    }

    @Override
    public String toString() {
        return "examen [nombre=" + nombre + ", temprano=" + temprano + "]";
    }
    
}


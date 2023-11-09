package servicios;

import java.util.ArrayList;
import java.util.List;

import modelo.Apoderado;

public class AdminPersona {
    public static List<Apoderado> apoderados = new ArrayList<>();

    public static List<Apoderado> getApoderados() {
        return apoderados;
    }

    public void agregarApoderado(Apoderado apoderado) {
            apoderados.add(apoderado);
    }

    public static void mostrarApoderados() {
        for (Apoderado apoderado : apoderados) {
            System.out.println(apoderado.toString());
        }
    }

    public static Apoderado buscarPorIdentificacion(String identificacion){
        for(Apoderado p:apoderados){
            System.out.println(p.toString());
            if(p.getIdentificacion().equals(identificacion)){
                return p;
            };
        }
        return null;
    }
}
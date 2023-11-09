package servicios;

import java.util.ArrayList;
import java.util.List;

import modelo.Apoderado;

public class AdminPersona {
    //public static List<Persona> personas = new ArrayList<>();
    public static List<Apoderado> apoderados = new ArrayList<>();
/*
    public static List<Persona> getPersonas() {
        return personas;
    }
*/
    public static Apoderado buscarPorIdentificacion(String identificacion){
        for(Apoderado p:apoderados){
            System.out.println(p.toString());
            if(p.getIdentificacion().equals(identificacion)){
                return p;
            };
        }
        return null;
    }

/*
    public static Persona buscarPorIdentificacion(String identificacion){
        for(Persona p:personas){
            System.out.println(p.toString());
            if(p.getIdentificacion().equals(identificacion)){
                return p;
            };
        }
        return null;
    }  */

}

package modelos;

import java.util.ArrayList;

/**
 * Estudiantes:
 * Jennifer Ramirez C.I 26.480.892
 * Daniel Mosquera C.I 26.779.308
 * Yovani Navas C.I 26.668.030
 * Alyeluz Perez C.I 21.129.930
 * Samary Vargas C.I 26.835.762
 * 
 */

public class Estudiante extends Persona{
     
    private int carreraId, semestreId, seccionId;//seccionN_Codigo; //relacion de uso 
    public ArrayList<Inscripcion> inscripciones= new ArrayList();

    public Estudiante(){
        
    }
    
    public Estudiante(int id, String codigo, String nombres, String apellidos,
            String genero,String direccion, String telefonos, String email,
            int carreraId,int semestreId/*int seccionId*/)
    {
        //String seccionN_Codigo
        super();
        this.id = id;
        this.codigo= codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefonos = telefonos;
        this.email = email;
        this.genero = genero;
        this.carreraId=carreraId;
        this.semestreId=semestreId;
        //this.seccionId=seccionId;
        //this.seccionN_Codigo=seccionN_Codigo;
    }

   

   /* public String getSeccionN_Codigo() {
        return seccionN_Codigo;
    }

    public void setSeccionN_Codigo(String seccionN_Codigo) {
        this.seccionN_Codigo = seccionN_Codigo;
    }*/

    

    public ArrayList<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(ArrayList<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }
    
    public int getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(int carreraId) {
        this.carreraId = carreraId;
    }

    public int getSemestreId() {
        return semestreId;
    }

    public void setSemestreId(int semestreId) {
        this.semestreId = semestreId;
    }
    /*
    public int getSeccionId() {
        return seccionId;
    }

    public void setSeccionId(int seccionId) {
        this.seccionId = seccionId;
    }*/

    


   
    
        
}

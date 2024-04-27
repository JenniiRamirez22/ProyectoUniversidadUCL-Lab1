
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

public class Profesor extends Persona{

    public ArrayList<Asignatura> asignaturas = new ArrayList();
    public ArrayList<Nota> notas = new ArrayList();
    
    public Profesor(){
        
    }
    
    public Profesor(int id,String codigo,String nombres, String genero, String apellidos,
            String direccion, String telefonos, String email)
    {
        super();
        this.codigo = codigo;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.genero = genero;
        this.direccion = direccion;
        this.telefonos = telefonos;
        this.email = email;
        
    }

             public ArrayList<Asignatura> getAsignaturas(){
           return asignaturas;
           
    }

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }

    
      
    

}
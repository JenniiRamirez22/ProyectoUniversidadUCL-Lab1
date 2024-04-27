
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
public class Carrera {
     private int id,decanatoId;
    private String codigo ,nombre;// seccionN_Codigo;
    public  ArrayList<Asignatura> asignaturas = new ArrayList();
    public  ArrayList<Estudiante> estudiantes = new ArrayList();
    

    public Carrera(int id,String codigo,String nombre_carrera, int decanatoId)
   //,String seccionN_Codigo 
    {
        this.id=id;
        this.nombre = nombre_carrera;
        this.codigo = codigo;
        this.decanatoId=decanatoId;
        //this.seccionN_Codigo=seccionN_Codigo;
    
    }

    public Carrera() {
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    
    public ArrayList<Asignatura> getAsignaturas() {
        return asignaturas;
    }

    public void setAsignaturas(ArrayList<Asignatura> asignaturas) {
        this.asignaturas = asignaturas;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    

   /* public String getSeccionN_Codigo() {
        return seccionN_Codigo;
    }

    public void setSeccionN_Codigo(String seccionN_Codigo) {
        this.seccionN_Codigo = seccionN_Codigo;
    }*/

    public int getDecanatoId() {
        return decanatoId;
    }

    public void setDecanatoId(int decanatoId) {
        this.decanatoId = decanatoId;
    }

    
     
           
   
    
    
    
    
}

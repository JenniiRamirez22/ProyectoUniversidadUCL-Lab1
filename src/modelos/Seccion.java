
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

public class Seccion {
    private int numero;
    private String  carreraId; //seccionN_Codigo
    public ArrayList<Estudiante> estudiantes = new ArrayList();
    public ArrayList<Inscripcion> inscripciones = new ArrayList();

    public Seccion(int numero, String carreraId, String seccionN_Codigo) {
        this.numero=numero;
        this.carreraId = carreraId;
        //this.seccionN_Codigo = seccionN_Codigo;
    }

    public Seccion() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

   
    public String getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(String carreraId) {
        this.carreraId = carreraId;
    }

   
    /*public String getSeccionN_Codigo() {
        return seccionN_Codigo;
    }

    public void setSeccionN_Codigo(String seccionN_Codigo) {
        this.seccionN_Codigo = seccionN_Codigo;
    }*/

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }

    public ArrayList<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(ArrayList<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }

 
    
}

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
public class Asignatura {
    private int id;
    private String codigo, nombre;
    private int carreraId, profesorId, semestreId;
            //, seccionN_Codigo;
    public ArrayList<Seccion> secciones = new ArrayList();
    public ArrayList<Nota> notas = new ArrayList();

    public Asignatura(int id,String codigo, String nombre,int carreraId,
            int semestreId,int profesorId )//String seccionN_Codigo)
    {
        this.id=id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.carreraId=carreraId;
        this.profesorId=profesorId;
        this.semestreId=semestreId;
        //this.seccionN_Codigo=seccionN_Codigo;
      
    }

    public Asignatura() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getProfesorId() {
        return profesorId;
    }

    public void setProfesorId(int profesorId) {
        this.profesorId = profesorId;
    }

    public int getSemestreId() {
        return semestreId;
    }

    public void setSemestreId(int semestreId) {
        this.semestreId= semestreId;
    }

   /* public String getSeccionN_Codigo() {
        return seccionN_Codigo;
    }

    public void setSeccionN_Codigo(String seccionN_Codigo) {
        this.seccionN_Codigo = seccionN_Codigo;
    }*/

    public ArrayList<Nota> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Nota> notas) {
        this.notas = notas;
    }

   
    
      public ArrayList<Seccion> getSecciones() {
        return secciones;
    }

    public void setSecciones(ArrayList<Seccion> secciones) {
        this.secciones = secciones;
    }

    public int getCarreraId() {
        return carreraId;
    }

    public void setCarreraId(int carreraId) {
        this.carreraId = carreraId;
    }
    
    
  
    
}

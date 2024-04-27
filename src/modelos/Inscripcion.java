package modelos;
import java.util.ArrayList;

/**
 * 
 *      Integrantes:
 *          Mosquera, Daniel   C.I: 26.779.308
 *          Navas, Yovani      C.I: 26.668.030
 *          Perez, Alyeluz     C.I: 21.129.930
 *          Ramirez, Jennifer  C.I: 26.480.892
 *          Vargas, Samary     C.I: 26.835.762
 */



public class Inscripcion 
{
    private String codigo;
    private String fecha;
    private int id,estudianteId, asignaturaId, seccionId, lapsoId;

    
   

    public Inscripcion(int id,String codigo, String fecha,int lapsoId, int estudianteId,
                       int asignaturaId, int seccionId)
    {
        this.codigo = codigo;
        this.fecha = fecha;
        this.id=id;
        this.estudianteId=estudianteId;
        this.asignaturaId=asignaturaId;
        this.seccionId=seccionId;
        this.lapsoId=lapsoId;
    }

    public Inscripcion() {
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

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getEstudianteId() {
        return estudianteId;
    }

    public void setEstudianteId(int estudianteId) {
        this.estudianteId = estudianteId;
    }

    public int getAsignaturaId() {
        return asignaturaId;
    }

    public void setAsignaturaId(int asignaturaId) {
        this.asignaturaId = asignaturaId;
    }

    public int getSeccionId() {
        return seccionId;
    }

    public void setSeccionId(int seccionId) {
        this.seccionId = seccionId;
    }

    public int getLapsoId() {
        return lapsoId;
    }

    public void setLapsoId(int lapsoId) {
        this.lapsoId = lapsoId;
    }

     

   
    
    
}

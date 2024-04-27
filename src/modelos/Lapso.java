/**
 * 
 *      Integrantes:
 *          Mosquera, Daniel   C.I: 26.779.308
 *          Navas, Yovani      C.I: 26.668.030
 *          Perez, Alyeluz     C.I: 21.129.930
 *          Ramirez, Jennifer  C.I: 26.480.892
 *          Vargas, Samary     C.I: 26.835.762
 */

package modelos;
import java.util.ArrayList;
import java.util.Date;

public class Lapso {
    
    private String codigo ;//seccionN_Codigo
    private int semana, año, id ;
    private Date fechaInicial, fechaFinal;
    public ArrayList<Nota> notas= new ArrayList();
    public ArrayList<Inscripcion> inscripciones= new ArrayList();



    public Lapso(int id,String codigo,String seccionN_Codigo, int semana, int año, Date fechaInicial, Date fechaFinal) {
        this.id=id;
        this.codigo = codigo;
        //this.seccionN_Codigo=seccionN_Codigo;
        this.semana = semana;
        this.año = año;
        this.fechaInicial = fechaInicial;
        this.fechaFinal = fechaFinal;
    }

    public Lapso() {
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

    public Integer getSemana() {
        return semana;
    }

    public void setSemana(int semana) {
        this.semana = semana;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public Date getFechaInicial() {
        return fechaInicial;
    }

    public void setFechaInicial(Date fechaInicial) {
        this.fechaInicial = fechaInicial;
    }

    public Date getFechaFinal() {
        return fechaFinal;
    }

    public void setFechaFinal(Date fechaFinal) {
        this.fechaFinal = fechaFinal;
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

    public ArrayList<Inscripcion> getInscripciones() {
        return inscripciones;
    }

    public void setInscripciones(ArrayList<Inscripcion> inscripciones) {
        this.inscripciones = inscripciones;
    }
    
    
}

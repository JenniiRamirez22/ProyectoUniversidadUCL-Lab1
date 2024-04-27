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

public class Nota 
{
    private String codigo, estudiantecodigo, profesorcodigo,asignaturacodigo, seccionN_Codigo;
    private float nota_Final;
    private Lapso lapso_Academico;

    public Nota(String codigo, Float nota_Final, Lapso lapso_Academico, 
           String estudiantecodigo, String profesorcodigo, String asignaturacodigo, String seccionN_Codigo) {
        
        this.codigo = codigo;
        this.nota_Final = nota_Final;
        this.lapso_Academico = lapso_Academico;
        this.estudiantecodigo = estudiantecodigo;
        this.asignaturacodigo = asignaturacodigo;
        this.profesorcodigo=profesorcodigo;
        this.seccionN_Codigo=seccionN_Codigo;
    }

    public String getAsignaturacodigo() {
        return asignaturacodigo;
    }

    public void setAsignaturacodigo(String asignaturacodigo) {
        this.asignaturacodigo = asignaturacodigo;
    }

    public String getEstudiantecodigo() {
        return estudiantecodigo;
    }

    public void setEstudiantecodigo(String estudiantecodigo) {
        this.estudiantecodigo = estudiantecodigo;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public float getNota_Final() {
        return nota_Final;
    }

    public void setNota_Final(float nota_Final) {
        this.nota_Final = nota_Final;
    }

    public Lapso getLapso_Academico() {
        return lapso_Academico;
    }

    public void setLapso_Academico(Lapso lapso_Academico) {
        this.lapso_Academico = lapso_Academico;
    }

    public String getProfesorcodigo() {
        return profesorcodigo;
    }

    public void setProfesorcodigo(String profesorcodigo) {
        this.profesorcodigo = profesorcodigo;
    }

    public String getSeccionN_Codigo() {
        return seccionN_Codigo;
    }

    public void setSeccionN_Codigo(String seccionN_Codigo) {
        this.seccionN_Codigo = seccionN_Codigo;
    }

    
    
    
}

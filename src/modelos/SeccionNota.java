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


public class SeccionNota 
{
     private String codigo;
    //private Float acum_notas_Seccion;
    private Estudiante estudiantes;
    private Seccion seccion;
    private Lapso lapso_Academico;
    private Asignatura asignatura;
    private Nota notas;
 
    public SeccionNota(String codigo, Estudiante estudiantes, Seccion seccion, Lapso lapsoAcademico, Asignatura asignatura, Nota notas) {
        this.codigo = codigo;
        this.estudiantes = estudiantes;
        this.seccion = seccion;
        this.lapso_Academico = lapsoAcademico;
        this.asignatura = asignatura;
        this.notas = notas;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }


    public Estudiante getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(Estudiante estudiantes) {
        this.estudiantes = estudiantes;
    }

    public Seccion getSeccion() {
        return seccion;
    }

    public void setSeccion(Seccion seccion) {
        this.seccion = seccion;
    }

    public Lapso getLapsoAcademico() {
        return lapso_Academico;
    }

    public void setLapsoAcademico(Lapso lapsoAcademico) {
        this.lapso_Academico = lapsoAcademico;
    }

    public Asignatura getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public Nota getNotas() {
        return notas;
    }

    public void setNotas(Nota notas) {
        this.notas = notas;
    }
    
    public int ContarAprobados(Nota[] notas)
    {
        int contAprobados=0;
         for (Nota nota : notas) {
             if (nota.getNota_Final() >= 50) {
                 contAprobados++;
             }
         }
        
        return contAprobados;
    }
    
    public int ContarReprobados(Nota[] notas)
    {
         int contReprobados= 0;
         for (Nota nota : notas) {
             if (nota.getNota_Final() < 50) {
                 contReprobados++;
             }
         } 
        
        return contReprobados;
    }
    
    
    public float CalcularPromedioSeccion(Nota[] notas)
    {
        float acum_notas_finales=0;
        int contEstudiantes= 0;
         for (Nota nota : notas) {
             acum_notas_finales += nota.getNota_Final();
         }
        contEstudiantes=notas.length;
        return acum_notas_finales/contEstudiantes;
    }
    
    
}

/*
 * Integrantes:
 *   Mosquera, Daniel   C.I: 26.779.308
 *   Navas, Yovani      C.I: 26.668.030
 *   Perez, Alyeluz     C.I: 21.129.930
 *   Ramirez, Jennifer  C.I: 26.480.892
 *   Vargas, Samary     C.I: 26.835.762
 */
package controlador;

import database.*;
import java.awt.event.*;
import vistas.*;
import javax.swing.*;

public class Controlador_Menu implements java.awt.event.ActionListener {

    //vistas
    private View_Menuu vistamenu;
    private View_Inscripcion vistaInsc;
    private View_Gestion_Estudiiante vistaGestu;
    private View_Gestion_Profesores vistaGprofe;
    private View_Gestion_Asignatura vistaAsig;
    private View_Gestion_Carrera vistaCarr;
    private View_Cargar_Notas vistaNotas;
    private View_Reportes_Seccion vistaRepor;
    private View_Retiro vistaRet;
    
    //databases
    private InscripcionCrud insc;
    private EstudianteCrud estuc;
    private ProfesorCrud profc;
    private AsignaturaCrud asigc;
    private CarreraCrud carrc;
    private LapsoCrud lapsc;
    private SeccionCrud secc;
    
    //controladores
    private Controlador_Inscripcion cins;
    private Controlador_Gestion_Estudiantes cest;
    private Controlador_Gestion_Profesor cprof;
    private Controlador_Asignatura casig;
    private Controlador_Reporte_Estudiante crepor;
    private ControladorNotasEstudiante cnoest;
    
    public Controlador_Menu() {
        // Instanciamos las vistas y las cargamos en memoria
        vistamenu = new View_Menuu();
        vistaGestu = new View_Gestion_Estudiiante();
        cest = new Controlador_Gestion_Estudiantes();
       
        //evento a los botones
        vistamenu.addEvents(this);
    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        
        if(evt.getSource() == vistamenu.btnRegistrarEstu){
            System.out.println("Botón btnRegistrarEstu presionado");
            //Controlador_Gestion_Estudiantes cest = new Controlador_Gestion_Estudiantes();
            View_Gestion_Estudiiante vistaGestu = new View_Gestion_Estudiiante();
            vistaGestu.setVisible(true);
            this.vistamenu.dispose();
            
        }else if (evt.getSource() == vistamenu.btnRegistrarProf){
            
        
        } else if (evt.getSource() == vistamenu.btnInscribir){
            
        }else if (evt.getSource() == vistamenu.btnAsignaturas){
            
        }else if (evt.getSource() == vistamenu.btnSeccion){
            
        }else if (evt.getSource() == vistamenu.btnRetiro){
            
        }else if (evt.getSource() == vistamenu.btnCargarN){
            
        }else if (evt.getSource() == vistamenu.btnReportes){
            
        }
     
    }
        
        
}


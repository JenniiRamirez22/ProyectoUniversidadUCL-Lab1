/**
 * Estudiantes:
 * Jennifer Ramirez C.I 26.480.892
 * Daniel Mosquera C.I 26.779.308
 * Yovani Navas C.I 26.668.030
 * Alyeluz Perez C.I 21.129.930
 * Samary Vargas C.I 26.835.762
 * 
 */
package controlador;

import database.AsignaturaCrud;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import modelos.Asignatura;
import vistas.View_Gestion_Asignatura;


public class Controlador_Asignatura implements ActionListener {
    
    private View_Gestion_Asignatura vistaAsig;
    private Asignatura asig;
    private AsignaturaCrud asigCrud;
    
    public Controlador_Asignatura(){}
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaAsig.btn_agregar_asig) {
        
        }else if(e.getSource() == vistaAsig.btn_modificar_asig){
        
        }else if(e.getSource() == vistaAsig.btn_eliminar_asig){}
    
    }
    
}

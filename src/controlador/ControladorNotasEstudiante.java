/*
 *      Integrantes:
 *          Mosquera, Daniel   C.I: 26.779.308
 *          Navas, Yovani      C.I: 26.668.030
 *          Perez, Alyeluz     C.I: 21.129.930
 *          Ramirez, Jennifer  C.I: 26.480.892
 *          Vargas, Samary     C.I: 26.835.762
 */

package controlador;
// importar libreria
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//importar modelo
import modelos.Estudiante;
import database.EstudianteCrud;

//importar visat
import vistas.View_Cargar_Notas;

public class ControladorNotasEstudiante implements ActionListener {
    
    /*para conectar la vista asignar notas con el modelo estudiante se declaran como atributos */
    private Estudiante estudiante; /*agarro la clase estudiante del modelo estudiante*/
    private View_Cargar_Notas vistaNotas; /*agarro la clase vista asignar notas del paq vista*/
    
    /*inicializamos*/
    public ControladorNotasEstudiante(Estudiante estudiante, View_Cargar_Notas vistaNotas){
        
        this.estudiante = estudiante;
        this.vistaNotas = vistaNotas;
        //this.vistaNotas.btn_Agregar.addActionListener(this); /*le estoy dando evento al boton guardar*/
        
    }
    
    public void iniciarVentanaNotas(){
        vistaNotas.setTitle("Cargas Notas Estudiante");
        vistaNotas.setLocationRelativeTo(null);
    }
    
    /*asignamos la referencia a cada campo de entrada*/
    public void actionPerformed(ActionEvent e) {
        //estudiante.setnota_Final(Integer.parseInt(vistaNotas.txtNotaF.getText()));
       
    }
    
}


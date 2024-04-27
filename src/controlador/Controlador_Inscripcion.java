

/*
 *      Integrantes:
 *          Mosquera, Daniel   C.I: 26.779.308
 *          Navas, Yovani      C.I: 26.668.030
 *          Perez, Alyeluz     C.I: 21.129.930
 *          Ramirez, Jennifer  C.I: 26.480.892
 *          Vargas, Samary     C.I: 26.835.762
 */
package controlador;

//importamos librerias de java a utilizar
import static java.awt.Frame.ICONIFIED;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

//importamos los modelos a utilizar
import modelos.Inscripcion;
import modelos.Estudiante;
import modelos.Asignatura;
import modelos.Seccion;

//importamos las clases del crud base de datos
import database.AsignaturaCrud;
import database.InscripcionCrud;
import database.EstudianteCrud;
import database.LapsoCrud;
import database.SeccionCrud;
//vista de inscripcion
import vistas.View_Inscripcion;


public class Controlador_Inscripcion implements ActionListener {
    private View_Inscripcion vistaIns;
    private EstudianteCrud estudianteCrud;
    private AsignaturaCrud asignaturaCrud;
    private LapsoCrud lapsoCrud;
    private SeccionCrud seccionCrud;
    private DefaultTableModel model;
    private InscripcionCrud insCrud;

    //CONSTRUCTOR DE LA CLASE CONTROLADOR INSCRIPCION
    public Controlador_Inscripcion() {
        vistaIns = new View_Inscripcion();
        vistaIns.btn_buscar_estu.addActionListener(this);
        vistaIns.btn_guardar_insc.addActionListener(this);
        vistaIns.btn_limpiar.addActionListener(this);
      
        vistaIns.addEvents(this);
       
        estudianteCrud = new EstudianteCrud();
        asignaturaCrud = new AsignaturaCrud();
        seccionCrud = new SeccionCrud();
        lapsoCrud = new LapsoCrud();
        insCrud = new InscripcionCrud();
        
      
        //LLAMA AL METODO DE LA BASE DE DATOS PARA LLENAR LOS COMBO BOX
        llenar_combo_box(vistaIns.getjComboBoxAsig(), asignaturaCrud.obtener_todas_asignaturas());
        llenar_combo_box(vistaIns.getjComboBoxSecc(), seccionCrud.obtener_listaSecciones());
        llenar_combo_box(vistaIns.getjComboBoxLapso(), lapsoCrud.obtener_lapso());

        // PREPARAMOS LA CONFIGURACION
        vistaIns.getjComboBoxAsig().addItemListener(this::asignatura_seleccionada);
        vistaIns.getjComboBoxSecc().addItemListener(this::seccion_seleccionada);
    }
    
    private void llenar_combo_box(JComboBox<String> comboBox, List<String> items) {
        //comboBox.removeAllItems(); // Limpia los elementos existentes en el combo box
        for (String item : items) {
            comboBox.addItem(item);
        }
    }
    
    private String asignaturaSeleccionada = null;
    private String seccionSeleccionada = null;

    private void asignatura_seleccionada(ItemEvent event) {
        if (event.getStateChange() == ItemEvent.SELECTED) {
            asignaturaSeleccionada = (String) vistaIns.getjComboBoxAsig().getSelectedItem();
            agregar_asignaturaseccion_a_tabla();
        }
    }

    private void seccion_seleccionada(ItemEvent event) {
        if (event.getStateChange() == ItemEvent.SELECTED) {
            seccionSeleccionada = (String) vistaIns.getjComboBoxSecc().getSelectedItem();
            agregar_asignaturaseccion_a_tabla();
        }
    }

    private void agregar_asignaturaseccion_a_tabla() {
        if (asignaturaSeleccionada != null && seccionSeleccionada != null) {
            DefaultTableModel model = (DefaultTableModel) vistaIns.getTable_inscripcion().getModel();
            model.addRow(new Object[]{asignaturaSeleccionada, seccionSeleccionada});
            // Reinicia las selecciones para el próximo par de asignatura y sección
            asignaturaSeleccionada = null;
            seccionSeleccionada = null;
        }
    }
    
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vistaIns.btn_buscar_estu) {
            String cedula = vistaIns.txtCodigoEI.getText().trim();
            if (cedula.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese la cédula del estudiante");
            } else {
                Estudiante estudiante = estudianteCrud.buscarUnEstudiante(cedula);
                if (estudiante != null) {
                    vistaIns.txtNombreEI.setText(estudiante.getNombres());
                    vistaIns.txtApeEI.setText(estudiante.getApellidos());
                } else {
                    JOptionPane.showMessageDialog(null, "Estudiante no encontrado");
                    // Limpia los campos de texto si no se encuentra el estudiante
                    vistaIns.txtNombreEI.setText("");
                    vistaIns.txtApeEI.setText("");
                }
            }
            
            //EVENTO DE TODO LO QUE OCURRE AL PRESIONAR EL BOTON GUARDAR
        }else if(e.getSource() == vistaIns.btn_guardar_insc){
            //obtener los datos
            String codigo = vistaIns.txtCodigoInsc.getText().trim();
            Date fecha = vistaIns.jDateChooserFechaIns.getDate();
            String cedEstu = vistaIns.txtCodigoEI.getText().trim();
            int indexLapso = vistaIns.jComboBoxLapso.getSelectedIndex();
            int indexAsignatura = vistaIns.jComboBoxAsig.getSelectedIndex();
            int indexSeccion = vistaIns.jComboBoxSecc.getSelectedIndex();
            int nuevoLapsoId = vistaIns.jComboBoxLapso.getItemAt(indexLapso);
            int nuevaAsignaturaId = vistaIns.jComboBoxAsig.getItemAt(indexAsignatura);
            int nuevaSeccionId = vistaIns.jComboBoxSecc.getItemAt(indexSeccion);
            //convertimos el java utilDate a sqlDate, se necesitan los dos tipos
            long fec = fecha.getTime();
            java.sql.Date fechains = new java.sql.Date(fec);
            
            Inscripcion nuevaInscripcion = new Inscripcion(codigo,fechains,cedEstu,nuevoLapsoId,nuevaAsignaturaId,nuevaSeccionId);
        
            boolean exito = insCrud.registrarInscripcion(nuevaInscripcion);

        if (exito) {
            JOptionPane.showMessageDialog(vistaIns, "Guardado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            // Limpiar los campos de texto después de guardar
            vistaIns.txtCodigoInsc.setText("");
            vistaIns.jDateChooserFechaIns.setDate(fecha);
            //vistaIns.txtFechaInsc.setText("");
            vistaIns.txtCodigoEI.setText("");
            vistaIns.txtNombreEI.setText("");
            vistaIns.txtApeEI.setText("");
        } else {
            JOptionPane.showMessageDialog(vistaIns, "Error al guardar", "Error", JOptionPane.ERROR_MESSAGE);
        }
            
        }else if(e.getSource() == vistaIns.btn_limpiar){
            
            
            String cedula = vistaIns.txtCodigoEI.getText().trim();
            if (cedula.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Los campos ya están vacíos");
            } else {
                vistaIns.txtCodigoInsc.setText("");
                Date fecha = vistaIns.jDateChooserFechaIns.getDate();
                vistaIns.jDateChooserFechaIns.setDate(fecha);
                //vistaIns.txtFechaInsc.setText("");
                vistaIns.txtCodigoEI.setText("");
                vistaIns.txtNombreEI.setText("");
                vistaIns.txtApeEI.setText("");
                DefaultTableModel model = (DefaultTableModel) vistaIns.getTable_inscripcion().getModel();
                model.setRowCount(0);
            }
        }
    }
   

}
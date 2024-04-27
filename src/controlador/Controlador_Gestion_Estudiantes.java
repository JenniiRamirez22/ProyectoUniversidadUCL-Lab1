/*
 *      Integrantes:
 *          Mosquera, Daniel   C.I: 26.779.308
 *          Navas, Yovani      C.I: 26.668.030
 *          Perez, Alyeluz     C.I: 21.129.930
 *          Ramirez, Jennifer  C.I: 26.480.892
 *          Vargas, Samary     C.I: 26.835.762
 */
package controlador;

import database.EstudianteCrud;
import database.CarreraCrud;
import database.SemestreCrud;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelos.Carrera;
import modelos.Estudiante;
import vistas.View_Gestion_Estudiiante;

public class Controlador_Gestion_Estudiantes implements ActionListener /*KeyListener*/ {
    private final EstudianteCrud estuCrud;
    private final View_Gestion_Estudiiante vGestionEstu; 
    private final CarreraCrud carreraCrud;
    private final Carrera carrera;
    private final SemestreCrud semestreCrud;
    private final DefaultTableModel model; //modelo de la tabla
    
    

    public Controlador_Gestion_Estudiantes() {
        
        estuCrud = new EstudianteCrud();
        vGestionEstu = new View_Gestion_Estudiiante();
        carreraCrud = new CarreraCrud();
        carrera = new Carrera();
        semestreCrud = new SemestreCrud();

        //LLAMAMOS A LA INSTACIA DE CARRERAS // le decimos que se nos muestre carreras en el combobox
        carreraCrud.llenarComboBoxCarreras(vGestionEstu.jComboBoxCarrera);
        
        semestreCrud.llenarComboBoxSemestres(vGestionEstu.jComboBoxSemestre);
        
        // Se crea un modelo de tabla vacío con las columnas deseadas
        String[] columnNames = {"codigo", "nombres", "apellidos","genero","direccion","telefonos","email"};
        model = new DefaultTableModel(columnNames, 0);
        vGestionEstu.tabla_est.setModel(model);

         //BOTONES DE LA VISTA //
        vGestionEstu.btn_buscar_est.addActionListener(this);
        vGestionEstu.btn_modificar_est.addActionListener(this);
        vGestionEstu.btn_agregar_est.addActionListener(this);
        vGestionEstu.btn_eliminar_est.addActionListener(this);
        
         //inicializamos comboBox de genero
        JComboBox<String> jComboBoxGenero = new JComboBox<>();
        String generoSeleccionado = (String) jComboBoxGenero.getSelectedItem();
        
    }
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vGestionEstu.btn_buscar_est) {
         String codigo = vGestionEstu.txt_codigo_est.getText().trim();
            if (codigo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese la cédula del estudiante");
            } else {
                Estudiante estudiante = estuCrud.buscarUnEstudiante(codigo);
                if (estudiante != null) {
                    //muestra los datos en los campos
                    /*vGestionEstu.txt_codigo_est.setText(estudiante.getCodigo());*/
                    vGestionEstu.txt_nombres_est.setText(estudiante.getNombres());
                    vGestionEstu.txt_apellidos_est1.setText(estudiante.getApellidos());
                    vGestionEstu.jComboBoxGenero.setSelectedItem(estudiante.getGenero());
                    vGestionEstu.txt_direccion_est.setText(estudiante.getDireccion());
                    vGestionEstu.txt_telefonos_est1.setText(estudiante.getTelefonos());
                    vGestionEstu.txt_email_est.setText(estudiante.getEmail());
                } else {
                    JOptionPane.showMessageDialog(null, "Estudiante no encontrado");
                    // Limpia los campos de texto si no se encuentra el estudiante
                    vGestionEstu.txt_nombres_est.setText("");
                    vGestionEstu.txt_apellidos_est1.setText("");
                    vGestionEstu.txt_direccion_est.setText("");
                    vGestionEstu.txt_telefonos_est1.setText("");
                    vGestionEstu.txt_email_est.setText("");
                    vGestionEstu.jComboBoxGenero.setSelectedItem("");
                }
            }
            
            //MODIFICAR datos del estudiante
    } else if (e.getSource() == vGestionEstu.btn_modificar_est) {
        // Obtener la cedula del estudiante a modificar
    String codigoEstudiante = vGestionEstu.txt_codigo_est.getText();

    // Buscar el estudiante en la base de datos
    Estudiante estudianteEncontrado = estuCrud.buscarUnEstudiante(codigoEstudiante);

    if (estudianteEncontrado != null) {
        // Actualizar los datos del estudiante con los valores ingresados por el usuario
        estudianteEncontrado.setNombres(vGestionEstu.txt_nombres_est.getText());
        estudianteEncontrado.setApellidos(vGestionEstu.txt_apellidos_est1.getText());
        estudianteEncontrado.setGenero(vGestionEstu.jComboBoxGenero.getSelectedItem().toString());
        estudianteEncontrado.setDireccion(vGestionEstu.txt_direccion_est.getText());
        estudianteEncontrado.setTelefonos(vGestionEstu.txt_telefonos_est1.getText());
        estudianteEncontrado.setEmail(vGestionEstu.txt_email_est.getText());

        // Lógica para modificar el estudiante en la base de datos
        boolean exito = estuCrud.modificarEstudiante(estudianteEncontrado);

        if (exito) {
            JOptionPane.showMessageDialog(vGestionEstu, "Estudiante modificado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(vGestionEstu, "Error al modificar el estudiante", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(vGestionEstu, "Estudiante no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
    }
        
        
    } else if (e.getSource() == vGestionEstu.btn_agregar_est) {
        // Obtener los datos ingresados por el usuario
        String nuevaCedula = vGestionEstu.txt_codigo_est.getText();
        String nuevosNombres = vGestionEstu.txt_nombres_est.getText();
        String nuevosApellidos = vGestionEstu.txt_apellidos_est1.getText();
        String nuevoGenero = vGestionEstu.jComboBoxGenero.getSelectedItem().toString();
        String nuevaDireccion = vGestionEstu.txt_direccion_est.getText();
        String nuevosTelefonos = vGestionEstu.txt_telefonos_est1.getText();
        String nuevoEmail = vGestionEstu.txt_email_est.getText();
        int indexCarrera = vGestionEstu.jComboBoxCarrera.getSelectedIndex();
        int indexSemestre = vGestionEstu.jComboBoxSemestre.getSelectedIndex();
        int nuevaCarreraId = vGestionEstu.jComboBoxCarrera.getItemAt(indexCarrera);
        int nuevoSemestreId = vGestionEstu.jComboBoxSemestre.getItemAt(indexSemestre);

        // Agrega una fila al modelo de tabla
        model.addRow(new Object[]{nuevaCedula, nuevosNombres, nuevosApellidos, nuevoGenero, nuevaDireccion, nuevosTelefonos, nuevoEmail});
                // Actualiza la vista de la tabla
        vGestionEstu.tabla_est.setModel(model);

        // Crear un nuevo objeto Estudiante con los datos ingresados
        Estudiante nuevoEstudiante = new Estudiante(0, nuevaCedula, nuevosNombres, nuevosApellidos, nuevoGenero, nuevaDireccion, nuevosTelefonos, nuevoEmail,nuevaCarreraId, nuevoSemestreId /*nuevaSeccion*/);
        
        // Registrar el estudiante y obtener su ID
        int idEstudiante = estuCrud.registrarEstudiante(nuevoEstudiante);
        //boolean exito = estuCrud.registrarEstudiante(nuevoEstudiante);

        if (/*exito*/idEstudiante != -1) {
            nuevoEstudiante.setId(idEstudiante);
            boolean exito = true;
            
            if (exito) {
                JOptionPane.showMessageDialog(vGestionEstu, "Estudiante agregado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            // Limpiar los campos de texto después de agregar
            vGestionEstu.txt_codigo_est.setText("");
            vGestionEstu.txt_nombres_est.setText("");
            vGestionEstu.txt_apellidos_est1.setText("");
            vGestionEstu.txt_direccion_est.setText("");
            vGestionEstu.txt_telefonos_est1.setText("");
            vGestionEstu.txt_email_est.setText("");
            }
            
        } else {
            JOptionPane.showMessageDialog(vGestionEstu, "Error al agregar el estudiante", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        //ACCION del boton para eliminar un estudiante
        } else if (e.getSource() == vGestionEstu.btn_eliminar_est) {
            Estudiante estu = new Estudiante();
            String codigoEstudiante = vGestionEstu.txt_codigo_est.getText();
            // Lógica para cambiar el estatus del estudiante a "I" (inactivo) en la base de datos
            boolean exito = estuCrud.eliminarEstudiante(estu);

            if (exito) {
                JOptionPane.showMessageDialog(vGestionEstu, "Estudiante eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(vGestionEstu, "Error al eliminar el estudiante", "Error", JOptionPane.ERROR_MESSAGE);
            }
            
               
    }
} 
    

}

             

    
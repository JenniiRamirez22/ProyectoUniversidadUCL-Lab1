/*
 *      Integrantes:
 *          Mosquera, Daniel   C.I: 26.779.308
 *          Navas, Yovani      C.I: 26.668.030
 *          Perez, Alyeluz     C.I: 21.129.930
 *          Ramirez, Jennifer  C.I: 26.480.892
 *          Vargas, Samary     C.I: 26.835.762
 */
package controlador;

import database.ProfesorCrud;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import modelos.Profesor;
import vistas.View_Gestion_Profesores;

public class Controlador_Gestion_Profesor implements ActionListener /*KeyListener*/ {
    private ProfesorCrud profeCrud;
    private View_Gestion_Profesores vGestionProfe; 
    private DefaultTableModel model; //modelo de la tabla
    
    

    public Controlador_Gestion_Profesor() {
        
        profeCrud = new ProfesorCrud();
        vGestionProfe = new View_Gestion_Profesores();
        
        // Se crea un modelo de tabla vacío con las columnas deseadas
        String[] columnNames = {"codigo", "nombres", "apellidos","genero","direccion","telefonos","email"};
        model = new DefaultTableModel(columnNames, 0);
        vGestionProfe.getTabla_prof().setModel(model);

         //BOTONES DE LA VISTA //
        vGestionProfe.btn_buscar_prof.addActionListener(this);
        vGestionProfe.btn_modificar_prof.addActionListener(this);
        vGestionProfe.btn_agregar_prof.addActionListener(this);
        vGestionProfe.btn_Eliminar_prof.addActionListener(this);
       
        //inicializamos comboBox de genero
        JComboBox<String> jComboBoxGenero = new JComboBox<>();
        String generoSeleccionado = (String) jComboBoxGenero.getSelectedItem();
    }
        
        
        @Override
        public void actionPerformed(ActionEvent e) {
        if (e.getSource() == vGestionProfe.btn_buscar_prof) {
         String codigo = vGestionProfe.txt_codigo_prof.getText().trim();
            if (codigo.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Ingrese la cédula del profesor");
            } else {
                Profesor profesor = profeCrud.buscarProfesor(codigo);
                if (profesor != null) {
                    //muestra los datos en los campos
                    /*vGestionProfe.txt_codigo_prof.setText(profesor.getCodigo());*/
                    vGestionProfe.txt_nombre_prof.setText(profesor.getNombres());
                    vGestionProfe.txt_apellidos_prof.setText(profesor.getApellidos());
                    vGestionProfe.jComboBoxGenero.setSelectedItem(profesor.getGenero());
                    vGestionProfe.txt_direccion_prof.setText(profesor.getDireccion());
                    vGestionProfe.txt_telefono_prof.setText(profesor.getTelefonos());
                    vGestionProfe.txt_email_prof.setText(profesor.getEmail());
                } else {
                    JOptionPane.showMessageDialog(null, "Profesor no encontrado");
                    // Limpia los campos de texto si no se encuentra al profe
                    vGestionProfe.txt_nombre_prof.setText("");
                    vGestionProfe.txt_apellidos_prof.setText("");
                    vGestionProfe.jComboBoxGenero.setSelectedItem("");
                    vGestionProfe.txt_direccion_prof.setText("");
                    vGestionProfe.txt_telefono_prof.setText("");
                    vGestionProfe.txt_email_prof.setText("");
                }
            }
            
            //MODIFICAR datos del profesor
    } else if (e.getSource() == vGestionProfe.btn_modificar_prof) {
        // Obtener la cedula del estudiante a modificar
    String codigoProfesor = vGestionProfe.txt_codigo_prof.getText();

    // Buscar el profesor en la base de datos
    Profesor profesorEncontrado = profeCrud.buscarProfesor(codigoProfesor);

    if (profesorEncontrado != null) {
        // Actualizar los datos del profe con los valores ingresados por el usuario
        profesorEncontrado.setNombres(vGestionProfe.txt_nombre_prof.getText());
        profesorEncontrado.setApellidos(vGestionProfe.txt_apellidos_prof.getText());
        profesorEncontrado.setGenero(vGestionProfe.jComboBoxGenero.getSelectedItem().toString()); 
        profesorEncontrado.setDireccion(vGestionProfe.txt_direccion_prof.getText());
        profesorEncontrado.setTelefonos(vGestionProfe.txt_telefono_prof.getText());
        profesorEncontrado.setEmail(vGestionProfe.txt_email_prof.getText());

        // Lógica para modificar el peoferos en la base de datos
        boolean exito = profeCrud.modificarProfesor(profesorEncontrado);

        if (exito) {
            JOptionPane.showMessageDialog(vGestionProfe, "profesor modificado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(vGestionProfe, "Error al modificar el rpofesor", "Error", JOptionPane.ERROR_MESSAGE);
        }
    } else {
        JOptionPane.showMessageDialog(vGestionProfe, "profesor no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
    }
        
        
    } else if (e.getSource() == vGestionProfe.btn_agregar_prof) {
        // Obtener los datos ingresados por el usuario
        String nuevaCedula = vGestionProfe.txt_codigo_prof.getText();
        String nuevosNombres = vGestionProfe.txt_nombre_prof.getText();
        String nuevosApellidos = vGestionProfe.txt_apellidos_prof.getText();
        String nuevoGenero = vGestionProfe.jComboBoxGenero.getSelectedItem().toString();
        String nuevaDireccion = vGestionProfe.txt_direccion_prof.getText();
        String nuevosTelefonos = vGestionProfe.txt_telefono_prof.getText();
        String nuevoEmail = vGestionProfe.txt_email_prof.getText();

        // Agrega una fila al modelo de tabla
        model.addRow(new Object[]{nuevaCedula, nuevosNombres, nuevosApellidos, nuevoGenero, nuevaDireccion, nuevosTelefonos, nuevoEmail});
                // Actualiza la vista de la tabla
        vGestionProfe.tabla_prof.setModel(model);

        // Crear un nuevo objeto profesore con los datos ingresados
        Profesor nuevoProfesor = new Profesor(nuevaCedula, nuevosNombres, nuevosApellidos, nuevoGenero, nuevaDireccion, nuevosTelefonos, nuevoEmail);
        
        boolean exito = profeCrud.registrarProfesor(nuevoProfesor);

        if (exito) {
            JOptionPane.showMessageDialog(vGestionProfe, "Profesor agregado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            // Limpiar los campos de texto después de agregar
            vGestionProfe.txt_codigo_prof.setText("");
            vGestionProfe.txt_nombre_prof.setText("");
            vGestionProfe.txt_apellidos_prof.setText("");
            vGestionProfe.txt_direccion_prof.setText("");
            vGestionProfe.txt_telefono_prof.setText("");
            vGestionProfe.txt_email_prof.setText("");
        } else {
            JOptionPane.showMessageDialog(vGestionProfe, "Error al agregar el profesor", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        //ACCION del boton para eliminar un profesor
        } else if (e.getSource() == vGestionProfe.btn_Eliminar_prof) {
            
            String codigoProfesor = vGestionProfe.txt_codigo_prof.getText();
            // Lógica para cambiar el estatus del profesor a "I" (inactivo) en la base de datos
            boolean exito = profeCrud.eliminarProfesor(codigoProfesor, "I");

            if (exito) {
                JOptionPane.showMessageDialog(vGestionProfe, "profesor eliminado exitosamente", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(vGestionProfe, "Error al eliminar el profesor", "Error", JOptionPane.ERROR_MESSAGE);
            }          
        }
} 
    

}

             

    

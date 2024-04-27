/**
 * Estudiantes:
 * Jennifer Ramirez C.I 26.480.892
 * Daniel Mosquera C.I 26.779.308
 * Yovani Navas C.I 26.668.030
 * Alyeluz Perez C.I 21.129.930
 * Samary Vargas C.I 26.835.762
 * 
 */

package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;

/**
 *
 * @author Personal
 */
public class SemestreCrud {
    
    public void llenarComboBoxSemestres(JComboBox<Integer> comboBox) {
    DefaultComboBoxModel<Integer> model = new DefaultComboBoxModel<>();
    
    // Establecer la conexión a la base de datos
    try (Connection conn = Singleton.getInstance()) {
        String sql = "SELECT id FROM semestre";      
        try (PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                model.addElement(resultSet.getInt("id"));
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }

    // Asignar el modelo al JComboBox pasado como parámetro
    comboBox.setModel(model);
}

    
    
}

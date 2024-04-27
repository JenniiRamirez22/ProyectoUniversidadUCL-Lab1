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

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Seccion;


public class SeccionCrud {
    
    
    // Obtener lista de todas las asignaturas desde la base de datos
    public List<Seccion>obtener_listaSecciones() {
         
        List<Seccion> secciones = null; //Inicializacion del array
        try
        {
            Singleton.getInstance().setAutoCommit(false);
            String selectSQL = "SELECT id FROM seccion"; // consulta
           PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(selectSQL);

            ResultSet resultado = preparedStatement.executeQuery(selectSQL);
                    
                    secciones=new ArrayList<>(); // Instanciacion del array
                    
                    while (resultado.next())
                    {
                        Seccion sec=new Seccion();
                        
                         sec.setNumero(resultado.getInt("numero"));
                        
                        secciones.add(sec);
                    }
                } catch (SQLException ex) { 
                Logger.getLogger(SeccionCrud.class.getName()).log(Level.SEVERE, null, ex);
            } 
             return secciones;// retorna el array
        }
    }
        
    
    
    /*private String obtener_codigo_seccion(String asignatura) {
    String codigoSeccion = ""; 

    try (Connection conn = Conexion.getConnection()) {
            String sql = "SELECT codigo FROM seccion";
        PreparedStatement 
        
        ResultSet resultSet = statement.executeQuery("SELECT CodigoSeccion FROM Secciones WHERE CodigoAsignatura = ?");
        resultSet.next();
        codigoSeccion = resultSet.getString("CodigoSeccion");
    } catch (SQLException e) {
        e.printStackTrace();
    }

    return codigoSeccion;
}*/


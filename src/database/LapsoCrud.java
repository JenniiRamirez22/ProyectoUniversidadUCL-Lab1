
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Lapso;
/**
 *
 * @author Jennifer Ramirez
 */
public class LapsoCrud {

    // Obtener informacion de los lapso desde la base de datos
    public List<Lapso>obtener_lapso() {
        
        List<Lapso> lapsos = null;
        try
        {
            Singleton.getInstance().setAutoCommit(false);

            String selectSQL = "SELECT id FROM lapso"; // consulta
                   
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(selectSQL);

            ResultSet resultado = preparedStatement.executeQuery(selectSQL);
                lapsos=new ArrayList<>();
                while (resultado.next())
                {
                    Lapso lap=new Lapso();
                    
                        lap.setId(resultado.getInt("id"));
                        lap.setSemana(resultado.getInt("semana"));
                        lap.setAño(resultado.getInt("año"));
                        lap.setCodigo(resultado.getString("codigo"));
                        lap.setFechaInicial(resultado.getDate("fecha_inicial"));
                        lap.setFechaFinal(resultado.getDate("fecha_final"));
                        lapsos.add(lap);
                }
         } 
        catch (SQLException ex)
        {
                Logger.getLogger(LapsoCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
             return lapsos;
        } 
       
        
        
        
       
    }
    


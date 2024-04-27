/**
 * 
 *      Integrantes:
 *          Mosquera, Daniel   C.I: 26.779.308
 *          Navas, Yovani      C.I: 26.668.030
 *          Perez, Alyeluz     C.I: 21.129.930
 *          Ramirez, Jennifer  C.I: 26.480.892
 *          Vargas, Samary     C.I: 26.835.762
 */
package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Asignatura;
import modelos.Estudiante;
import modelos.Inscripcion;
import modelos.Lapso;
import modelos.Seccion;



public class InscripcionCrud 
{
    
    
    public InscripcionCrud(){}

    //buscar estudiante se llama directamente en el controlador de inscripcion
    
    //metodo que se llama cuando se le da al boton guardar en la vista de incripcion
    public boolean registrarInscripcion(Inscripcion ins) 
    {
         boolean flag = false;
        try {
            Singleton.getInstance().setAutoCommit(false);// 
            String sql = "INSERT INTO inscripcion (codigo,fecha,estatus, lapso_id,"
                    + "estudiante_id,asignatura_id,  seccion_id)"
                    + " VALUES(?,?,?,?,?,?,?)";
            
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(sql);
            
            
            preparedStatement.setString(1, ins.getCodigo());
            preparedStatement.setString(2, ins.getFecha());
            preparedStatement.setString(3, "Activo");
            preparedStatement.setInt(4,ins.getLapsoId());
             preparedStatement.setInt(5, ins.getEstudianteId());
            preparedStatement.setInt(6,ins.getAsignaturaId());
            preparedStatement.setInt(7, ins.getSeccionId());

            preparedStatement.execute();

            if (preparedStatement.execute()) {
                System.out.println("Inscripcion registrada.");
            } else {
                System.out.println("Error: el registro no pudo ser guardado.");

            }
            Singleton.getInstance().commit();
            flag = true;

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            try {
                Singleton.getInstance().rollback();
            } catch (SQLException ex1) {
                System.out.println(ex.getMessage());
            }

        }
        return flag;
    }
           
    //Se realiza una búsqueda especifica, por lo que necesitamos el codigo identificador por parametro.
    public Inscripcion ObtenerUnaInscripcion(String codigo)
    {
           Inscripcion ins = null;
           Estudiante estu=null;
           Lapso lap=null;
           Asignatura asigna=null;
           Seccion secc=null;
        try {
            Singleton.getInstance().setAutoCommit(false);

            String selectSQL = "SELECT fecha, lapso.codigo, "
                    + "estudiante.codigo,estudiante.nombres, estudiante.apellidos,"
                    + "asignatura.codigo, asignatura.nombre_asignatura,"
                    + " seccion.numero  "
                    + "FROM inscripcion JOIN lapso ON inscripcion.lapso_id=lapso.id"
                    + "JOIN estudiante ON inscripcion.estudiante_id=estudiante.id"
                    + "JOIN asignatura ON inscripcion.asignatura_id=asignatura.id"
                    + "JOIN seccion ON inscripcion.seccion_id=seccion.numero"
                    + "WHERE estudiante.codigo='?'";
            
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(selectSQL);

            preparedStatement.setString(1, codigo);

            ResultSet resultado = preparedStatement.executeQuery();

            resultado.last();// se coloca en el ultimo registro recibido.

            System.out.println("Cantidad de registros" + resultado.getRow());

            if (resultado.getRow() > 0) {
                resultado.beforeFirst();

                ins = new Inscripcion();

                while (resultado.next()) {

                    ins.setId(resultado.getInt("id"));
                    ins.setFecha(resultado.getString("fecha"));
                    lap.setCodigo(resultado.getString("codigo"));
                    //NO BORRAR: ins.setLapsoId(resultado.getInt("lapso_id"));
                    //NO BORRAR: ins.setEstudianteId(resultado.getInt("estudiante_id"));
                    estu.setCodigo(resultado.getString("codigo"));
                    estu.setNombres(resultado.getString("nombres"));
                    estu.setApellidos(resultado.getString("apellidos"));
                    asigna.setCodigo(resultado.getString("codigo"));
                    asigna.setNombre(resultado.getString("nombre_asignatura"));
                    secc.setNumero(resultado.getInt("numero"));
                    //NO BORRAR: ins.setAsignaturaId(resultado.getInt("asignatura_id"));
                    //NO BORRAR: ins.setSeccionId(resultado.getInt("seccion_id"));

                }
                resultado.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(InscripcionCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ins;

    }
    
    
    public boolean eliminarInscripcion(Inscripcion ins)
    {
       boolean flag=false;
        try
        {
            Singleton.getInstance().setAutoCommit(false);
            String sql = "DELETE FROM inscripcion WHERE id=?";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(sql);
            preparedStatement.setInt(1, ins.getId());
            
            preparedStatement.execute();
            
            
            Singleton.getInstance().commit();
            flag=true;
            
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            try 
            {
                Singleton.getInstance().rollback();
            } 
            catch (SQLException ex1) 
            {
                System.out.println(ex.getMessage());
            }
        
        }
        return flag;
    
       
  }
}


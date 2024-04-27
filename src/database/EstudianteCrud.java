/*
 *      Integrantes:
 *          Mosquera, Daniel   C.I: 26.779.308
 *          Navas, Yovani      C.I: 26.668.030
 *          Perez, Alyeluz     C.I: 21.129.930
 *          Ramirez, Jennifer  C.I: 26.480.892
 *          Vargas, Samary     C.I: 26.835.762
 */
package database;

//import java.beans.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Estudiante;
import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.Statement;


public class EstudianteCrud
{
    public EstudianteCrud() { }
    
     public /*boolean*/ int registrarEstudiante(Estudiante estu) 
    {
        /*boolean flag=false;*/
        int idEstudiante = -1; 
        try
        {
            Singleton.getInstance().setAutoCommit(false);
            String sql = "INSERT INTO estudiante (codigo,nombres,apellidos,genero,"
                + "direccion,telefonos, email,estatus, carrera_id, semestre_id)"
                + " VALUES(?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);/*,seccion_id*/
            
       //No se necesita pedir el ID en el insert ya que es auto incrementable en BD.

            preparedStatement.setString(1, estu.getCodigo());
            preparedStatement.setString(2, estu.getNombres());
            preparedStatement.setString(3, estu.getApellidos());
            preparedStatement.setString(4, estu.getGenero());
            preparedStatement.setString(5, estu.getDireccion());
            preparedStatement.setString(6, estu.getTelefonos());
            preparedStatement.setString(7, estu.getEmail());
            preparedStatement.setString(8, "Activo");
            preparedStatement.setInt(9, estu.getCarreraId());
            preparedStatement.setInt(10, estu.getSemestreId());
            //preparedStatement.setInt(11, estu.getSeccionId());
            
            //preparedStatement.execute();
             // Ejecutar la inserción
            int affectedRows = preparedStatement.executeUpdate();
            
            if(affectedRows == 1)/*preparedStatement.execute()*/
            {
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                //System.out.println("Estudiante registrado.");
                if (generatedKeys.next()) {
                idEstudiante = generatedKeys.getInt(1); // Obtener el ID generado
                System.out.println("Estudiante registrado con ID: " + idEstudiante);
                } else {
                System.out.println("Error al obtener el ID del estudiante registrado.");
                }
            }   
            else
            {
                //System.out.println("Error: el registro no pudo ser guardado.");
                 System.out.println("Error: el registro no pudo ser guardado.");
            }
            Singleton.getInstance().commit();
            //flag=true;    
        }
        catch(SQLException ex)
        {
            System.out.println("Error al registrar estudiante: " + ex.getMessage());
            try {
                Singleton.getInstance().rollback();
            } catch (SQLException ex1) 
            {
                System.out.println("Error al hacer rollback: " + ex1.getMessage());
            }   
        }
        return /*flag*/idEstudiante;    
    }
     
     
     

     public List<Estudiante> buscarEstudiantes() 
    {
        List<Estudiante> estud = null;
        try {
            Singleton.getInstance().setAutoCommit(false);

            String selectSQL = "SELECT * FROM estudiante";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(selectSQL);
            
            ResultSet resultado = preparedStatement.executeQuery(selectSQL);

            resultado.last();// se coloca en el ultimo registro recibido.

            System.out.println("Cantidad de registros" + resultado.getRow());

            if (resultado.getRow() > 0) {
                resultado.beforeFirst();

                estud = new ArrayList<>();

                while (resultado.next()) {
                    Estudiante estu = new Estudiante();
                    
                    estu.setId(resultado.getInt("id"));
                    estu.setCodigo(resultado.getString("codigo"));
                    estu.setNombres(resultado.getString("nombres"));
                    estu.setApellidos(resultado.getString("apellidos"));
                    estu.setGenero(resultado.getString("genero"));
                    estu.setDireccion(resultado.getString("direccion"));
                    estu.setTelefonos(resultado.getString("telefonos"));
                    estu.setEmail(resultado.getString("email"));
                    estu.setCarreraId(resultado.getInt("carrera_id"));
                    estu.setSemestreId(resultado.getInt("semestre_id"));
                    //estu.setSeccionId(resultado.getInt("seccion_id"));

                    estud.add(estu);
                }
                resultado.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(EstudianteCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return estud;

    }

          
        
 // Se esta localizando un registro, de acuerdo al codigo identificador del Estudiante.       
    public Estudiante buscarUnEstudiante(String codigo)
    {
        
        Estudiante estu = null;
        try {
            Singleton.getInstance().setAutoCommit(false);

            String selectSQL = "SELECT * FROM estudiante WHERE codigo= ? ";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(selectSQL,ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
            
            preparedStatement.setString(1, codigo);
            
            ResultSet resultado = preparedStatement.executeQuery();

            System.out.println("Cantidad de registros" + resultado.next());

            //if (resultado.next()) {
                //resultado.beforeFirst();

                 estu = new Estudiante();
                    
                 estu.setId(resultado.getInt("id"));
                 estu.setCodigo(resultado.getString("codigo"));
                 estu.setNombres(resultado.getString("nombres"));
                 estu.setApellidos(resultado.getString("apellidos"));
                 estu.setGenero(resultado.getString("genero"));
                 estu.setDireccion(resultado.getString("direccion"));
                 estu.setTelefonos(resultado.getString("telefonos"));
                 estu.setEmail(resultado.getString("email"));
                 estu.setCarreraId(resultado.getInt("carrera_id"));
                 estu.setSemestreId(resultado.getInt("semestre_id"));
                 //estu.setSeccionId(resultado.getInt("seccion_id"));
                
                resultado.close();
            //}
        } catch (SQLException ex) {
            /*Logger.getLogger(EstudianteCrud.class.getName()).log(Level.SEVERE, null, ex);*/
            JOptionPane.showMessageDialog(null, "Error al buscar estudiante: " + ex.getMessage());
            ex.printStackTrace();
        }
        //System.out.println("Retorna estudiante" + estu);
        return estu;

 
    }
            
    public boolean modificarEstudiante( Estudiante estu)  
    {
         boolean flag=false;
        try
        {
            Singleton.getInstance().setAutoCommit(false);
            String sql = "UPDATE  estudiante SET (codigo='?',nombres='?',apellidos='?'"
                + "genero='?',direccion='?', telefonos='?',email='?', carrera_id='?',"
                    + " semestre_id='?', seccion_id='?'"
                + " WHERE id=?)";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(sql);
            preparedStatement.setString(1, estu.getCodigo());
            preparedStatement.setString(2, estu.getNombres());
            preparedStatement.setString(3, estu.getApellidos());
            preparedStatement.setString(4, estu.getGenero());
            preparedStatement.setString(5, estu.getDireccion());
            preparedStatement.setString(6, estu.getTelefonos());
            preparedStatement.setString(7, estu.getEmail());
            preparedStatement.setInt(8, estu.getCarreraId());
            preparedStatement.setInt(9, estu.getSemestreId());
            //preparedStatement.setInt(10, estu.getSeccionId());
            
            preparedStatement.setInt(11,estu.getId());
            
            preparedStatement.execute();
            
            if(preparedStatement.execute())
            {
                System.out.println("Registro del estudiante actualizado.");
            }
            
            else
            {
                System.out.println("Error: el registro no pudo ser actualizado.");
            
            }
            Singleton.getInstance().commit();
            flag=true;
            
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            try {
                Singleton.getInstance().rollback();
            } catch (SQLException ex1) 
            {
                System.out.println(ex.getMessage());
            }
        
        }
        return flag;
       
    }
     
    
 
  // Método para eliminar un estudiante.
    public boolean eliminarEstudiante(Estudiante estu)
    {
       boolean flag=false;
        try
        {
            Singleton.getInstance().setAutoCommit(false);
            String sql = "DELETE FROM estudiante WHERE id = ? ";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(sql);
            preparedStatement.setInt(1, estu.getId());
            
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
     
     




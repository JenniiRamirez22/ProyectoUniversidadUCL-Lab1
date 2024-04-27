/*
 *      Integrantes:
 *          Mosquera, Daniel   C.I: 26.779.308
 *          Navas, Yovani      C.I: 26.668.030
 *          Perez, Alyeluz     C.I: 21.129.930
 *          Ramirez, Jennifer  C.I: 26.480.892
 *          Vargas, Samary     C.I: 26.835.762
 */
package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.Profesor;

public class ProfesorCrud {

    public ProfesorCrud() { }
      
 public boolean registrarProfesor(Profesor prof) 
    {
        boolean flag=false;
        try
        {
            Singleton.getInstance().setAutoCommit(false);
            String sql = "INSERT INTO profesor (codigo,nombres,apellidos,genero"
                + "direccion,telefonos, email,estatus )"
                + " VALUES(?,?,?,?,?,?,?,?)"; 
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(sql);
            // Se prepara el Statement para recibir los datos de la variables
            //No se necesita pedir el ID ya que es auto incrementable en BD.
            preparedStatement.setString(1, prof.getCodigo());
            preparedStatement.setString(2, prof.getNombres());
            preparedStatement.setString(3, prof.getApellidos());
            preparedStatement.setString(4, prof.getGenero());
            preparedStatement.setString(5, prof.getDireccion());
            preparedStatement.setString(6, prof.getTelefonos());
            preparedStatement.setString(7, prof.getEmail());
            preparedStatement.setString(8, "Activo");
            
            preparedStatement.execute();
            
            if(preparedStatement.execute())
            {
                System.out.println("Profesor registrado.");
            }
            
            else
            {
                System.out.println("Error: el registro no pudo ser guardado.");
            
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
     
  
     public List<Profesor> buscarProfesores() 
    {
        List<Profesor> profs = null;
        try {
            Singleton.getInstance().setAutoCommit(false);

            String selectSQL = "SELECT * FROM profesor";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(selectSQL);
            
            ResultSet resultado = preparedStatement.executeQuery(selectSQL);

            resultado.last();// se coloca en el ultimo registro recibido.

            System.out.println("Cantidad de registros" + resultado.getRow());

            if (resultado.getRow() > 0) {
                resultado.beforeFirst();

               profs = new ArrayList<>();

                while (resultado.next()) {
                    Profesor prof = new Profesor();
                    
                    prof.setId(resultado.getInt("id"));
                    prof.setCodigo(resultado.getString("codigo"));
                    prof.setNombres(resultado.getString("nombres"));
                    prof.setApellidos(resultado.getString("apellidos"));
                    prof.setGenero(resultado.getString("genero"));
                    prof.setDireccion(resultado.getString("direccion"));
                    prof.setTelefonos(resultado.getString("telefonos"));
                    prof.setEmail(resultado.getString("email"));
                   

                    profs.add(prof);
                }
                resultado.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesorCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return profs;

    }

          
        
 // Se esta localizando un registro, de acuerdo al codigo identificador del Estudiante.       
    public Profesor buscarUnProfesor(String codigo)
    {
     Profesor prof = null;
        try {
            Singleton.getInstance().setAutoCommit(false);

            String selectSQL = "SELECT * FROM profesor WHERE codigo = ? ";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(selectSQL);
            
            preparedStatement.setString(1, codigo);
            
            ResultSet resultado = preparedStatement.executeQuery(selectSQL);

            resultado.last();// se coloca en el ultimo registro recibido.

            System.out.println("Cantidad de registros" + resultado.getRow());

            if (resultado.getRow() > 0) {
                resultado.beforeFirst();

                 prof = new Profesor();

                while (resultado.next()) {
                    
                    prof.setId(resultado.getInt("id"));
                    prof.setCodigo(resultado.getString("codigo"));
                    prof.setNombres(resultado.getString("nombres"));
                    prof.setApellidos(resultado.getString("apellidos"));
                    prof.setGenero(resultado.getString("genero"));
                    prof.setDireccion(resultado.getString("direccion"));
                    prof.setTelefonos(resultado.getString("telefonos"));
                    prof.setEmail(resultado.getString("email"));
                    
                }
                resultado.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ProfesorCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prof;

    }
            
    public boolean modificarProfesor( Profesor prof)  
    {
         boolean flag=false;
        try
        {
            Singleton.getInstance().setAutoCommit(false);
            String sql = "UPDATE  profesor SET (codigo='?',nombres='?',apellidos='?'"
                + "genero='?',direccion='?', telefonos='?',email='?', estatus='?',"
                + " WHERE id=?)";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(sql);
            preparedStatement.setString(1, prof.getCodigo());
            preparedStatement.setString(2, prof.getNombres());
            preparedStatement.setString(3, prof.getApellidos());
            preparedStatement.setString(4, prof.getGenero());
            preparedStatement.setString(5, prof.getDireccion());
            preparedStatement.setString(6, prof.getTelefonos());
            preparedStatement.setString(7, prof.getEmail());
            preparedStatement.setString(8, "Activo");
            preparedStatement.setInt(9, prof.getId());
          
            preparedStatement.execute();
            
            if(preparedStatement.execute())
            {
                System.out.println("Registro del profesor actualizado.");
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
     
    
 
  // Método para eliminar una Asignatura.
    public boolean eliminarProfesor(Profesor prof)
    {
       boolean flag=false;
        try
        {
            Singleton.getInstance().setAutoCommit(false);
            String sql = "DELETE FROM profesor WHERE id=?";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(sql);
            preparedStatement.setInt(1, prof.getId());
            
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
    

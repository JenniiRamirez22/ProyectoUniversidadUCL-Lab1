/*
 *      Integrantes:
 *          Mosquera, Daniel   C.I: 26.779.308
 *          Navas, Yovani      C.I: 26.668.030
 *          Perez, Alyeluz     C.I: 21.129.930
 *          Ramirez, Jennifer  C.I: 26.480.892
 *          Vargas, Samary     C.I: 26.835.762
 */
package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import modelos.Carrera;

public class CarreraCrud
{

    public CarreraCrud() {}
    
  public boolean registrarCarrera(Carrera carr) 
    {
        boolean flag=false;
        try
        {
            Singleton.getInstance().setAutoCommit(false);
            String sql = "INSERT INTO carrera (codigo,nombre_carrera,estatus"
                + " decanato_id)"
                + " VALUES(?,?,?,?)";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(sql);
            //No se necesita pedir el ID en el insert ya que es auto incrementable en BD.

            preparedStatement.setString(1, carr.getCodigo());
            preparedStatement.setString(2, carr.getNombre());
            preparedStatement.setString(3, "A");
            preparedStatement.setInt(4, carr.getDecanatoId());
            
            
            preparedStatement.execute();
            
            if(preparedStatement.execute())
            {
                System.out.println(" La Carrera ha sido registrada.");
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
     
     
     // se estan buscand varios registros referentes a la clase Carrera.
     
    public List<Carrera> buscarCarreras() 
    {
        List<Carrera> car = null;
        try {
            Singleton.getInstance().setAutoCommit(false);

            String selectSQL = "SELECT * FROM carrera";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(selectSQL);
            
            ResultSet resultado = preparedStatement.executeQuery(selectSQL);

            resultado.last();// se coloca en el ultimo registro recibido.

            System.out.println("Cantidad de registros" + resultado.getRow());

            if (resultado.getRow() > 0) {
                resultado.beforeFirst();

                car = new ArrayList<>();

                while (resultado.next()) {
                   Carrera carr = new Carrera();
                    
                    carr.setId(resultado.getInt("id"));
                    carr.setCodigo(resultado.getString("codigo"));
                    carr.setNombre(resultado.getString("nombre_carrera"));
                    carr.setDecanatoId(resultado.getInt("decanato_id"));
                    

                    car.add(carr);
                }
                resultado.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarreraCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return car;

    }

          
        
        
    public Carrera buscarUnaCarrera(String codigo)
    {
     Carrera carr = null;
        try {
            Singleton.getInstance().setAutoCommit(false);

            String selectSQL = "SELECT * FROM carrera WHERE codigo='?'";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(selectSQL);
            
            preparedStatement.setString(1, codigo);
            
            ResultSet resultado = preparedStatement.executeQuery(selectSQL);

            resultado.last();// se coloca en el ultimo registro recibido.

            System.out.println("Cantidad de registros" + resultado.getRow());

            if (resultado.getRow() > 0) {
                resultado.beforeFirst();

                 carr = new Carrera();

                while (resultado.next()) {
                    
                    carr.setId(resultado.getInt("id"));
                    carr.setCodigo(resultado.getString("codigo"));
                    carr.setNombre(resultado.getString("nombre_carrera"));
                    carr.setDecanatoId(resultado.getInt("decanato_id"));
                    
                }
                resultado.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(CarreraCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return carr;

    }
            
    public boolean modificarCarrera( Carrera carr)  
    {
         boolean flag=false;
        try
        {
            Singleton.getInstance().setAutoCommit(false);
            String sql = "UPDATE  carrera SET (codigo='?',nombre_carrera='?',"
                + " estatus='?', decanato_id='?'"
                + " WHERE id=?)";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(sql);
            preparedStatement.setString(1, carr.getCodigo());
            preparedStatement.setString(2, carr.getNombre());
            preparedStatement.setString(3, "Activo");
            preparedStatement.setInt(4, carr.getDecanatoId());
            
            preparedStatement.execute();
            
            if(preparedStatement.execute())
            {
                System.out.println("Carrera actualizada.");
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
     
    
 
  // Método para eliminar una Carrera.
    public boolean eliminarCarrera(Carrera carr)
    {
       boolean flag=false;
        try
        {
            Singleton.getInstance().setAutoCommit(false);
            String sql = "DELETE FROM carrera WHERE id=?";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(sql);
            preparedStatement.setInt(1, carr.getId());
            
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
    
    
    
    public void llenarComboBoxCarreras(JComboBox<Integer> comboBox) {
    DefaultComboBoxModel<Integer> model = new DefaultComboBoxModel<>();
    
    // Establecer la conexión a la base de datos
    try (Connection conn = Singleton.getInstance()) {
        String sql = "SELECT id FROM carrera";      
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
    
 
        
        /*
        try (Connection conn = Singleton.getConexionDB()) {
        String sql = "SELECT nombre_carrera FROM carrera";
        try (PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String nombreCarrera = resultSet.getString("nombre_carrera");
                comboBox.addItem(nombreCarrera);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
    */
    

    
        
 }
    
    
        

      
    
    
    


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
import javax.swing.JComboBox;
import modelos.Decanato;


public class DecanatoCrud {

    public DecanatoCrud() { }

          public boolean registrarDecanato(Decanato dec) 
    {
        boolean flag=false;
        try
        {
            Singleton.getInstance().setAutoCommit(false);
            String sql = "INSERT INTO asignatura (codigo,nombre_decanato,direccion,"
                    + "telefonos, email,estatus, universidad_id"
                
                + " VALUES(?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(sql);
    
//No se necesita pedir el ID en el insert ya que es auto incrementable en BD.

            preparedStatement.setString(1, dec.getCodigo());
            preparedStatement.setString(2, dec.getNombre());
            preparedStatement.setString(3, dec.getDireccion());
            preparedStatement.setString(4, dec.getTelefonos());
            preparedStatement.setString(5, dec.getEmail());
            preparedStatement.setString(6, "Activo");
            preparedStatement.setInt(7, dec.getUnivId());

            
            preparedStatement.execute();
            
            if(preparedStatement.execute())
            {
                System.out.println("Decanato registrado.");
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
     
     
     // se estan buscand varios registros referentes a la clase Decanato.
     
    public List<Decanato> buscarDecanatos() 
    {
        List<Decanato> deca = null;
        try {
            Singleton.getInstance().setAutoCommit(false);

            String selectSQL = "SELECT * FROM decanato";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(selectSQL);
            
            ResultSet resultado = preparedStatement.executeQuery(selectSQL);

            resultado.last();// se coloca en el ultimo registro recibido.

            System.out.println("Cantidad de registros" + resultado.getRow());

            if (resultado.getRow() > 0) {
                resultado.beforeFirst();

                deca = new ArrayList<>();

                while (resultado.next()) {
                    Decanato dec = new Decanato();
                    
                    dec.setId(resultado.getInt("id"));
                    dec.setCodigo(resultado.getString("codigo"));
                    dec.setNombre(resultado.getString("nombre_decanato"));
                    dec.setDireccion(resultado.getString("direccion"));
                    dec.setTelefonos(resultado.getString("telefonos"));
                    dec.setEmail(resultado.getString("email"));
                    dec.setUnivId(resultado.getInt("universidad_id"));

                    deca.add(dec);
                }
                resultado.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DecanatoCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return deca;

    }

          
        
        
    public Decanato buscarUnDecanato(String codigo)
    {
     Decanato dec = null;
        try {
            Singleton.getInstance().setAutoCommit(false);

            String selectSQL = "SELECT * FROM decanato WHERE codigo = ? ";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(selectSQL);
            
            preparedStatement.setString(1, codigo);
            
            ResultSet resultado = preparedStatement.executeQuery(selectSQL);

            resultado.last();// se coloca en el ultimo registro recibido.

            System.out.println("Cantidad de registros" + resultado.getRow());

            if (resultado.getRow() > 0) {
                resultado.beforeFirst();

                 dec = new Decanato();

                while (resultado.next()) {
                    
                    dec.setId(resultado.getInt("id"));
                    dec.setCodigo(resultado.getString("codigo"));
                    dec.setNombre(resultado.getString("nombre_decanato"));
                    dec.setDireccion(resultado.getString("direccion"));
                    dec.setTelefonos(resultado.getString("telefonos"));
                    dec.setEmail(resultado.getString("email"));
                    
                    dec.setUnivId(resultado.getInt("universidad_id"));

                }
                resultado.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(DecanatoCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dec;

    }
            
    public boolean modificarDecanato( Decanato dec)  
    {
         boolean flag=false;
        try
        {
            Singleton.getInstance().setAutoCommit(false);
            String sql = "UPDATE  decanato SET (codigo='?',nombre_decanato='?',"
                + "direccion='?', telefonos='?',email='?', estatus='?',universidad_id='?'"
                + " WHERE id=?)";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(sql);
            
            preparedStatement.setString(1, dec.getCodigo());
            preparedStatement.setString(2, dec.getNombre());
            preparedStatement.setString(3, dec.getDireccion());
            preparedStatement.setString(4, dec.getTelefonos());
            preparedStatement.setString(5, dec.getEmail());
            preparedStatement.setString(6, "Activo");
            preparedStatement.setInt(7,dec.getUnivId());
            preparedStatement.setInt(8,dec.getId());
           
            
            preparedStatement.execute();
            
            if(preparedStatement.execute())
            {
                System.out.println("Decanato actualizado.");
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
    public boolean eliminarDecanato(Decanato dec)
    {
       boolean flag=false;
        try
        {
            Singleton.getInstance().setAutoCommit(false);
            String sql = "DELETE FROM decanato WHERE id=?";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(sql);
            preparedStatement.setInt(1, dec.getId());
            
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
    
    
    
    
    public void obtenerListadoDecanatos(JComboBox<String> comboBox) {
    try (Connection conn = Singleton.getInstance()) {
        String sql = "SELECT nombre_decanato FROM decanato";
        try (PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                String nombreDecanato = resultSet.getString("nombre_decanato");
                comboBox.addItem(nombreDecanato);
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }

        
    
    
}

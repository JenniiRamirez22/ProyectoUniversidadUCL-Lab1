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
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Singleton
{
    private Singleton(){}
    private static Connection instance;
    public static Connection getInstance() 
    {
        try
        {
            if(instance==null || instance.isClosed())
            {
                String driver = "org.postgresql.Driver";
                String bd = "Unicl";
                String url = "jdbc:postgresql://localhost:5432/" + bd;
                String usuario = "postgres";
                String contraseña = "2211";//sql
                Class.forName(driver);
                instance = (Connection)DriverManager.getConnection(url, usuario, contraseña);
                System.out.println("Conexion Exitosa");
            }
        }
        catch(ClassNotFoundException ex)
        {
             System.out.println(ex.getException());
              System.out.println("Error al conectar");
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
            System.out.println("Error en el SQL");
        }
    
    return instance;
 
  }
    
    public static void desconectar() {
        try {
            if (instance != null && !instance.isClosed()) { // Verifica si la conexión no es nula y no está cerrada.
                instance.close();
                System.out.println("Conexion cerrada"); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(Singleton.class.getName()).log(Level.SEVERE, "Error closing connection", ex);
        }
    }
    
    
   /* public static void desconectar()
    {
        try {
            conexionDB.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }*/
}
//CAMBIAR ESTOS DATOS por los datos de tu base de datos
//public class Conexion {




    /*tributos privados final ; los describen como constantes y no pueden 
    cambiar su valor , durante la ejecucion de la aplicacion.*/ 
    
    /*private final String BD = "Unicl";
    private final String URL = "jdbc:postgresql://localhost:5432/" + BD;
    private final String USUARIO = "postgres";
    private final String CONTRASEÑA = "123456";//sql
    private final String DRIVER = "org.postgresql.Driver";

    public static Conexion instancia; //SINGLENTON
    public Connection conectar;

    /* se crea el constructor, y se abrira la coneccion cuando se cree el objeto
    nuestra clase va a ejecutar la conexion con la base de datos.*/
   /*  private Conexion() 
    {

        try 
        {
            Class.forName(DRIVER);
            conectar = DriverManager.getConnection(URL, USUARIO, CONTRASEÑA);
            // JOptionPane.showMessageDialog(null,"Base de Datos conectadacon exito");

        } 
        catch (ClassNotFoundException | SQLException e) 
        {
            JOptionPane.showMessageDialog(null, "Error al conectar" + e.getMessage());
        }

    }
       
    public static Conexion Estado() 
    {
        if (instancia == null) 
        {
            instancia = new Conexion();
        }
        return instancia;
    }

    public Connection getConectar() 
    {
        return conectar;
    }

    
    
    public void cerrarConeccion() 
    {
        instancia = null;
    }

    PreparedStatement prepareStatement(String sql) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
    
   /* private static final String NOMBRE_BD = "Unicl";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/"+NOMBRE_BD;
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "123456";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }*/

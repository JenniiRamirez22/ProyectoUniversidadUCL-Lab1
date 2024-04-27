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
import modelos.Usuario;
import java.sql.Connection;


public class UsuarioConexion {
    
    
    public Usuario login(String codigo, String clave) {
    Usuario usu = null;
    String selectSQL = "SELECT * FROM usuario WHERE codigo = ? AND clave = ?";
    try (Connection connection = Singleton.getInstance();
         PreparedStatement preparedStatement = connection.prepareStatement(selectSQL)) {

        preparedStatement.setString(1, codigo);
        preparedStatement.setString(2, clave);

        try (ResultSet resultado = preparedStatement.executeQuery()) {
            if (resultado.next()) {
                usu = new Usuario();
                usu.setCodigo(resultado.getString("codigo"));
                usu.setClave(resultado.getString("clave"));
            }
        }
    } catch (SQLException ex) {
        Logger.getLogger(UsuarioConexion.class.getName()).log(Level.SEVERE, null, ex);
    }
    return usu;
}

 
}  









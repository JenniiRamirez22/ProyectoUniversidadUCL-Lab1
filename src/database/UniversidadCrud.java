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
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelos.Universidad;

/**
 *
 * @author Personal
 */
public class UniversidadCrud {

    public UniversidadCrud() {}

    public boolean registrarUniversidad(Universidad uni) {
        boolean flag = false;
        try {
            Singleton.getInstance().setAutoCommit(false);
            String sql = "INSERT INTO universidad (codigo,nombre_universidad,"
                    + "direccion,telefonos,email,estatus"
                    + " VALUES(?,?,?,?,?,?)";
            
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(sql);
    //No se necesita pedir el ID en el insert ya que es auto incrementable en BD.

            preparedStatement.setString(1, uni.getCodigo());
            preparedStatement.setString(2, uni.getNombre());
            preparedStatement.setString(3, uni.getDireccion());
            preparedStatement.setString(4, uni.getTelefonos());
            preparedStatement.setString(5, uni.getEmail());
            preparedStatement.setString(6, "Activo");
            
            preparedStatement.execute();

            if (preparedStatement.execute()) {
                System.out.println("Universidad registrada.");
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

    // se estan buscand varios registros referentes a la clase asignatura.
    public List<Universidad> buscarUniversidad() {
        List<Universidad> univ = null;
        try {
            Singleton.getInstance().setAutoCommit(false);

            String selectSQL = "SELECT * FROM universidad";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(selectSQL);

            ResultSet resultado = preparedStatement.executeQuery(selectSQL);

            resultado.last();// se coloca en el ultimo registro recibido.

            System.out.println("Cantidad de registros" + resultado.getRow());

            if (resultado.getRow() > 0) {
                resultado.beforeFirst();

                univ = new ArrayList<>();

                while (resultado.next()) {
                    Universidad uni = new Universidad();

                    uni.setId(resultado.getInt("id"));
                    uni.setCodigo(resultado.getString("codigo"));
                    uni.setNombre(resultado.getString("nombre_universidad"));
                    uni.setDireccion(resultado.getString("direccion"));
                    uni.setTelefonos(resultado.getString("telefonos"));
                    uni.setEmail(resultado.getString("email"));
                    

                    univ.add(uni);
                }
                resultado.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UniversidadCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return univ;

    }

    public Universidad buscarUnaUniversidad(String codigo) {
        Universidad uni = null;
        try {
            Singleton.getInstance().setAutoCommit(false);

            String selectSQL = "SELECT * FROM universidad WHERE codigo='?'";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(selectSQL);

            preparedStatement.setString(1, codigo);

            ResultSet resultado = preparedStatement.executeQuery(selectSQL);

            resultado.last();// se coloca en el ultimo registro recibido.

            System.out.println("Cantidad de registros" + resultado.getRow());

            if (resultado.getRow() > 0) {
                resultado.beforeFirst();

                uni = new Universidad();

                while (resultado.next()) {

                    uni.setId(resultado.getInt("id"));
                    uni.setCodigo(resultado.getString("codigo"));
                    uni.setNombre(resultado.getString("nombre_universidad"));
                    uni.setDireccion(resultado.getString("direccion"));
                    uni.setTelefonos(resultado.getString("telefonos"));
                    uni.setEmail(resultado.getString("email"));
                    

                }
                resultado.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(UniversidadCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return uni;

    }

    public boolean modificarUniversidad(Universidad uni) {
        boolean flag = false;
        try {
            Singleton.getInstance().setAutoCommit(false);
            String sql = "UPDATE  universidad SET (codigo='?',nombre_universidad='?',"
                    + "direccion='?', telefonos='?',email='?', estatus='?'"
                    + " WHERE id=?)";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(sql);
            preparedStatement.setString(1, uni.getCodigo());
            preparedStatement.setString(2, uni.getNombre());
            preparedStatement.setString(3, uni.getDireccion());
            preparedStatement.setString(4, uni.getTelefonos());
            preparedStatement.setString(5, uni.getEmail());
            preparedStatement.setString(3, "Activo");
            preparedStatement.setInt(7, uni.getId());

            preparedStatement.execute();

            if (preparedStatement.execute()) {
                System.out.println("El registro de la Universidad ha sido actualizado.");
            } else {
                System.out.println("Error: el registro no pudo ser actualizado.");

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

    // Método para eliminar una Asignatura.
    public boolean eliminarUniversidad(Universidad uni) {
        boolean flag = false;
        try {
            Singleton.getInstance().setAutoCommit(false);
            String sql = "DELETE FROM universidad WHERE id=?";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(sql);
            preparedStatement.setInt(1, uni.getId());

            preparedStatement.execute();

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

}

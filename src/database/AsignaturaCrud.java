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
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.List;
import modelos.Asignatura;


public class AsignaturaCrud 
{

    public AsignaturaCrud() {}
  
public boolean registrarAsignatura(Asignatura asigna) {
        boolean flag = false;
        try {
            Singleton.getInstance().setAutoCommit(false);
            String sql = "INSERT INTO asignatura (codigo,nombre_asignatura,estatus"
                    + " carrera_id, semestre_id, profesor_id)"
                    + " VALUES(?,?,?,?,?,?)";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(sql);
            
            //No se necesita pedir el ID en el insert ya que es auto incrementable en BD.
            preparedStatement.setString(1, asigna.getCodigo());
            preparedStatement.setString(2, asigna.getNombre());
            preparedStatement.setString(3, "Activo");
            preparedStatement.setInt(4, asigna.getCarreraId());
            preparedStatement.setInt(5, asigna.getSemestreId());
            preparedStatement.setInt(6, asigna.getProfesorId());

            preparedStatement.execute();

            if (preparedStatement.execute()) {
                System.out.println("Asignatura registrada.");
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
    public List<Asignatura> buscarAsignaturas() {
        List<Asignatura> asigna = null;
        try {
            Singleton.getInstance().setAutoCommit(false);

            String selectSQL = "SELECT * FROM asignatura";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(selectSQL);

            ResultSet resultado = preparedStatement.executeQuery(selectSQL);

            resultado.last();// se coloca en el ultimo registro recibido.

            System.out.println("Cantidad de registros" + resultado.getRow());

            if (resultado.getRow() > 0) {
                resultado.beforeFirst();

                asigna = new ArrayList<>();

                while (resultado.next()) {
                    Asignatura asignatura = new Asignatura();

                    asignatura.setId(resultado.getInt("id"));
                    asignatura.setCodigo(resultado.getString("codigo"));
                    asignatura.setNombre(resultado.getString("nombre_asignatura"));
                    asignatura.setCarreraId(resultado.getInt("carrera_id"));
                    asignatura.setSemestreId(resultado.getInt("semestre_id"));
                    asignatura.setProfesorId(resultado.getInt("profesor_id"));

                    asigna.add(asignatura);
                }
                resultado.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AsignaturaCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asigna;

    }

    public Asignatura buscarUnaAsignatura(String codigo) {
        Asignatura asigna = null;
        try {
            Singleton.getInstance().setAutoCommit(false);

            String selectSQL = "SELECT * FROM asignatura WHERE codigo='?'";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(selectSQL);

            preparedStatement.setString(1, codigo);

            ResultSet resultado = preparedStatement.executeQuery(selectSQL);

            resultado.last();// se coloca en el ultimo registro recibido.

            System.out.println("Cantidad de registros" + resultado.getRow());

            if (resultado.getRow() > 0) {
                resultado.beforeFirst();

                asigna = new Asignatura();

                while (resultado.next()) {

                    asigna.setId(resultado.getInt("id"));
                    asigna.setCodigo(resultado.getString("codigo"));
                    asigna.setNombre(resultado.getString("nombre_asignatura"));
                    asigna.setCarreraId(resultado.getInt("carrera_id"));
                    asigna.setSemestreId(resultado.getInt("semestre_id"));
                    asigna.setProfesorId(resultado.getInt("profesor_id"));

                }
                resultado.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(AsignaturaCrud.class.getName()).log(Level.SEVERE, null, ex);
        }
        return asigna;

    }

    public boolean modificarAsignatura(Asignatura asigna) {
        boolean flag = false;
        try {
            Singleton.getInstance().setAutoCommit(false);
            String sql = "UPDATE  asignatura SET (codigo='?',nombre_asignatura='?',"
                    + " estatus='?',carrera_id='?', semestre_id='?', profesor_id='?'"
                    + " WHERE id=?)";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(sql);
            preparedStatement.setString(1, asigna.getCodigo());
            preparedStatement.setString(2, asigna.getNombre());
            preparedStatement.setString(3, "Activo");
            preparedStatement.setInt(4, asigna.getCarreraId());
            preparedStatement.setInt(5, asigna.getSemestreId());
            preparedStatement.setInt(6, asigna.getProfesorId());
            preparedStatement.setInt(7, asigna.getId());

            preparedStatement.execute();

            if (preparedStatement.execute()) {
                System.out.println("Asignatura actualizada.");
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
    public boolean eliminarAsignatura(Asignatura asigna) {
        boolean flag = false;
        try {
            Singleton.getInstance().setAutoCommit(false);
            String sql = "DELETE FROM asignatura WHERE id = ? ";
            PreparedStatement preparedStatement = Singleton.getInstance().prepareStatement(sql);
            preparedStatement.setInt(1, asigna.getId());

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


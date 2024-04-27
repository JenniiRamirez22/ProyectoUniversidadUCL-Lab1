
package modelos;
import java.util.ArrayList;

/**
 * Estudiantes:
 * Jennifer Ramirez C.I 26.480.892
 * Daniel Mosquera C.I 26.779.308
 * Yovani Navas C.I 26.668.030
 * Alyeluz Perez C.I 21.129.930
 * Samary Vargas C.I 26.835.762
 * 
 */

public class Universidad {
    private String codigo;
    private String nombre;
    private String direccion;
    private String telefonos;
    private String email;
    private int id;
    public ArrayList<Decanato> decanatos = new ArrayList();

    public Universidad(int id,String codigo, String nombre, String direccion, String telefonos, String email) {
        this.id=id;
        this.codigo = codigo;
        this.nombre= nombre;
        this.direccion = direccion;
        this.telefonos = telefonos;
        this.email = email;
    }

    public Universidad() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
       
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(String telefonos) {
        this.telefonos = telefonos;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Decanato> getDecanatos() {
        return decanatos;
    }

    public void setDecanatos(ArrayList<Decanato> decanatos) {
        this.decanatos = decanatos;
    }
    
   
}

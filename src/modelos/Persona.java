
package modelos;

/**
 * Estudiantes:
 * Jennifer Ramirez C.I 26.480.892
 * Daniel Mosquera C.I 26.779.308
 * Yovani Navas C.I 26.668.030
 * Alyeluz Perez C.I 21.129.930
 * Samary Vargas C.I 26.835.762
 * 
 */

public class Persona {
    
   public int id;
   public String codigo,nombres, apellidos,direccion,telefonos, email, genero;
    
    
  public Persona() {
      super();
  }
  
  public Persona(int id,String codigo, String nombres, String apellidos,String genero, String direccion, 
          String telefonos, String email ){
    super();
    this.id=id;
    this.codigo = codigo;
    this.nombres = nombres;
    this.apellidos = apellidos;
    this.direccion = direccion;
    this.telefonos = telefonos;
    this.email = email;
    this.genero = genero;
  
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

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

  
  
}

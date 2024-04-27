/**
 * 
 *      Integrantes:
 *          Mosquera, Daniel   C.I: 26.779.308
 *          Navas, Yovani      C.I: 26.668.030
 *          Perez, Alyeluz     C.I: 21.129.930
 *          Ramirez, Jennifer  C.I: 26.480.892
 *          Vargas, Samary     C.I: 26.835.762
 */
package controlador;

import database.DecanatoCrud;
import database.UsuarioConexion;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import modelos.Usuario;
import vistas.Inicio_Sesion;
import vistas.View_Menuu;

public class Controlador_InicioSesion implements java.awt.event.ActionListener{
    private Usuario us;
    private UsuarioConexion usc;
    private Inicio_Sesion ini; //esta es la vista
    private DecanatoCrud dec;
    
   
    public Controlador_InicioSesion(/*Usuario us, UsuarioConexion usc, Inicio_Sesion ini, DecanatoCrud dec*/) {
        /*this.us = us;
        this.usc = usc;
        this.ini = ini;
        this.dec = dec;*/
        
        us = new Usuario();
        usc = new UsuarioConexion();
        ini = new Inicio_Sesion();
        dec = new DecanatoCrud();
        
        ini.addEvents(this);
        //llenar comboBox
        dec.obtenerListadoDecanatos(ini.comboBox_dec);
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==ini.btn_ini){
            if(ini.txt_usuario_ini.getText().equals("") || ini.txt_contraseña_ini.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Los campos estan vacios");
            }else{
                String codigo = ini.txt_usuario_ini.getText();
                String clave = ini.txt_contraseña_ini.getText();
                us = usc.login(codigo, clave);
                if(us.getCodigo()!=null){
                    View_Menuu menuu = new View_Menuu();//llamamos e instanciamos la vista a donde direcciona
                    menuu.setVisible(true); //para que se pueda mostrar
                    this.ini.dispose();
                }
            }
        }else{}
    }
    
    
    
}

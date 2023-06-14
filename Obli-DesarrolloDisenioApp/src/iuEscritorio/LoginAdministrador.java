
package iuEscritorio;

import java.awt.Frame;
import logica.Fachada;


public class LoginAdministrador extends LoginAbstracto {

      public LoginAdministrador(Frame parent, boolean modal) {
        super(parent, modal, "LOGIN ADMINISTRADOR");
    }

    
    @Override
    public Object llamarLogin(String nom, String pass) {
        return Fachada.getInstancia().loginAdministrador(nom, pass);
    }

    @Override
    public void proximoCasoUso(Object obj) {
        new MenuAdministradorDialogo(obj).setVisible(true);
        
    }
    
}

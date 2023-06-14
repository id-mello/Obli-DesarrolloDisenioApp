
package iuEscritorio;

import java.awt.Frame;
import logica.Fachada;


public class LoginPropietario extends LoginAbstracto {

    public LoginPropietario(Frame parent, boolean modal) {
        super(parent, modal, "LOGIN PROPIETARIO");
    }

   

    @Override
    public Object llamarLogin(String cedula, String pass) {
        return Fachada.getInstancia().loginPropietario(cedula, pass);
    }

    @Override
    public void proximoCasoUso(Object obj) {
        new tablaControlPropietarioDialogo(obj).setVisible(true);
    }
    
    
}

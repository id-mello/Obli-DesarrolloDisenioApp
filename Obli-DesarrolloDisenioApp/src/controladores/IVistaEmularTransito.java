

package controladores;

import java.util.ArrayList;
import logica.Puesto;
import logica.Transito;


public interface IVistaEmularTransito {
    
    public void mostrarPuestos(ArrayList<Puesto> puestos);
    
    public void mostrarTransito(Transito transito);
    
    public void error(String message);
    
}

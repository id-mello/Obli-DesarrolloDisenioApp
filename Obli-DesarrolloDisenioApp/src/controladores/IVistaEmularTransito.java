

package controladores;

import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;
import logica.Puesto;


public interface IVistaEmularTransito {
    
    public void mostrarPuestos(ArrayList<Puesto> puestos);
    
    public void error(String message);
    
}

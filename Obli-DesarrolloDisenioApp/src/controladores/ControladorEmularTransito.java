

package controladores;


import java.util.ArrayList;
import logica.Fachada;
import logica.PeajeException;
import logica.Propietario;
import logica.Puesto;


public class ControladorEmularTransito {
    
    
    
    private IVistaEmularTransito iVista;

    public ControladorEmularTransito(IVistaEmularTransito iVista) {
        this.iVista = iVista;
        mostrarPuestos();
    }

    private void mostrarPuestos() {
        ArrayList<Puesto> puestos = Fachada.getInstancia().getPuestos();
        iVista.mostrarPuestos(puestos);
    }
    
    
    public void emularUnTransito(Puesto puesto, String matricula) {
    
        try {
            
            Propietario p = Fachada.getInstancia().existeVehiculoMatricula(matricula);
            p.agregarUnTransito(puesto);
         
        } catch (PeajeException ex) {
            iVista.error(ex.getMessage());
        }
        
    }
    
    
}

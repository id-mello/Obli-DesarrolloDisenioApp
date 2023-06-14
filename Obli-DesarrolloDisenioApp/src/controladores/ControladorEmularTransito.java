

package controladores;


import java.util.ArrayList;
import logica.Fachada;
import logica.PeajeException;
import logica.Puesto;
import logica.Transito;
import logica.Vehiculo;



public class ControladorEmularTransito{
    
    
    
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
            Vehiculo v = Fachada.getInstancia().buscarVehiculoMatricula(matricula);
            Transito transito = v.getPropietario().agregarUnTransito(puesto, v);
            iVista.mostrarTransito(transito);
        } catch (PeajeException ex) {
            iVista.error(ex.getMessage());
        }
        
    }

    
}

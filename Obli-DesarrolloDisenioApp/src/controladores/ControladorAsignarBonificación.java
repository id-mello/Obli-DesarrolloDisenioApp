
package controladores;

import java.util.ArrayList;
import logica.Bonificacion;
import logica.Fachada;
import logica.PeajeException;
import logica.Propietario;
import logica.Puesto;



public class ControladorAsignarBonificación {
    
    
    private IVistaAsignarBonificacion iVista;
    private Propietario propietario;

    public ControladorAsignarBonificación(IVistaAsignarBonificacion iVista) {
        this.iVista = iVista;
        mostrarBonificaciones();
        mostrarPuestos();
    }
    
    
    private void mostrarBonificaciones(){
        ArrayList<Bonificacion> bonificaciones = Fachada.getInstancia().getBonificaciones();
        iVista.mostrarBonificaciones(bonificaciones);
    }
    
    private void mostrarPuestos(){
        ArrayList<Puesto> puestos = Fachada.getInstancia().getPuestos();
        iVista.mostrarPuestos(puestos);
    }
    
    public void buscarPropietarioPorCI(String cedula){
        
         try {
            propietario = Fachada.getInstancia().buscarPropietarioPorCI(cedula);
            iVista.mostrarAsignaciones(propietario); 
        } catch (PeajeException ex) {        
            iVista.error(ex.getMessage());
        }
        
       
        
    }

    public void agregarBonificacion(String cedula, Bonificacion bonificacion, Puesto puesto) {
        
        try {
            propietario.agregarBonificacion(bonificacion, puesto);
        } catch (PeajeException ex) {        
            iVista.error(ex.getMessage());
        }
        
        
    }

}

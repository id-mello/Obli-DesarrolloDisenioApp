
package controladores;

import java.util.ArrayList;
import logica.Bonificacion;
import logica.Fachada;
import logica.Propietario;
import logica.Puesto;



public class ControladorAsignarBonificación {
    
    
    private IVistaAsignarBonificacion iVista;


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
        
        Propietario propietario = Fachada.getInstancia().buscarPropietarioPorCI(cedula);
        
        iVista.mostrarAsignaciones(propietario);
        
    }

    
    
    
}

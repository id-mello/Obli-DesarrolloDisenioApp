
package controladores;

import java.util.ArrayList;
import logica.Bonificacion;
import logica.Fachada;
import logica.PeajeException;
import logica.Propietario;
import logica.Puesto;
import observador.Observable;
import observador.Observador;



public class ControladorAsignarBonificación implements Observador{
    
    private IVistaAsignarBonificacion iVista;
    private Propietario propietario;
    private String ultimaCedula = "";
    
    public ControladorAsignarBonificación(IVistaAsignarBonificacion iVista)  {
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
            ultimaCedula = cedula; 
            propietario = Fachada.getInstancia().buscarPropietarioPorCI(cedula);
            propietario.agregarObservador(this);
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

    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(Propietario.eventos.cambioBonificacionesAsignadas)){
            buscarPropietarioPorCI(ultimaCedula);
        }
    }

}


package controladores;

import logica.Propietario;
import observador.Observable;
import observador.Observador;


public class ControladorTablaControlPropietario implements Observador {

    private IVistaTablaControlPropietario vista;
    
    private Propietario propietario;

    public ControladorTablaControlPropietario(IVistaTablaControlPropietario pvista, Propietario u) {
       this.propietario = u;
       this.vista = pvista;
       u.agregarObservador(this);
       mostrarDatos(propietario);
       
    }
    
    public Propietario traerPropietario(){
        return propietario;
    }
    
    public void mostrarDatos(Propietario p){
        vista.mostrarDatosPropetario(p);
    }

    public void borrarNotificacion(int indexNotificacion) {
            propietario.borrarNotificacion(indexNotificacion);
            vista.mostrarDatosPropetario(propietario);
        
    }
    
    @Override
    public void actualizar(Object evento, Observable origen) {
       if(evento.equals(Propietario.eventos.actualizarContadoresVehiculo) || evento.equals(Propietario.eventos.listaRecargas)
           || evento.equals(Propietario.eventos.cambioNotificacion) || evento.equals(Propietario.eventos.cambioBonificacionesAsignadas))    
        {
            mostrarDatos(propietario);
        }
    }
    
}

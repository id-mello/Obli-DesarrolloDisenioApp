
package controladores;

import java.util.ArrayList;
import java.util.Date;
import logica.Administrador;
import logica.SistemaUsuarios;
import logica.Fachada;
import logica.Propietario;
import logica.Recarga;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author gsandona
 */
public class ControladorAprobarCargaAdministrador implements Observador{
    private VistaAprobarCargaAdministrador vistaAprobarCargaAdministrador;
    
    private Administrador administrador;
    
    public ControladorAprobarCargaAdministrador(VistaAprobarCargaAdministrador vista, Administrador propietario) {
       this.administrador = propietario;
       this.vistaAprobarCargaAdministrador = vista;
    }
    
    public ArrayList<Recarga> traerListaRecargas(){
        ArrayList<Recarga> listaRecargas = Fachada.getInstancia().ListadeRecargasPendientes();
        return listaRecargas;
    }

    public void aprobarRecarga(Date fecha, String propietario, double monto) {
        
   

        for (Recarga recarga : Fachada.getInstancia().ListadeRecargasPendientes()) {
            if (recarga.getFecha().equals(fecha) &&
                recarga.getNombrePropietario().equals(propietario) &&
                recarga.getMonto() == monto) {

                // Realiza las operaciones para aprobar la recarga
                // Por ejemplo, actualiza el saldo del propietario
                Propietario propietarioRecarga = Fachada.getInstancia().traerPropietario(propietario);
                propietarioRecarga.agregarSaldo(monto);
                
                recarga.setEstado("aprobado");
                
                // Elimina la recarga de la lista de pendientes
                Fachada.getInstancia().quitarRecargaPendiente(recarga);

                // Notifica a la vista que la recarga ha sido aprobada
                //vistaAprobarCargaAdministrador.RecargaAprobada();
                vistaAprobarCargaAdministrador.RecargaAprobada();
              
            }
        }
    
        // Si no se encontró la recarga, notifica a la vista que ha ocurrido un error
        vistaAprobarCargaAdministrador.error("No se encontró la recarga seleccionada");
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(SistemaUsuarios.eventos.cambioListaRecargasPendientes)){
            traerListaRecargas();
        }
    }
    
  
}

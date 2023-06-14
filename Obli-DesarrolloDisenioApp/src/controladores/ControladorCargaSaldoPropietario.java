
package controladores;


import logica.Fachada;
import logica.PeajeException;
import logica.Propietario;
import logica.Recarga;
import logica.SistemaUsuarios;
import observador.Observable;
import observador.Observador;

public class ControladorCargaSaldoPropietario implements Observador{
    private IVistaCargaSaldoPropietario vistaCargarSaldoPropietario;
   
    private Propietario propietario;
    

    public ControladorCargaSaldoPropietario(IVistaCargaSaldoPropietario vista, Propietario propietario) {
       this.propietario = propietario;
       this.vistaCargarSaldoPropietario = vista;
       mostrarDetallePropietario();
       
    }
    

    public void mostrarDetallePropietario(){
        vistaCargarSaldoPropietario.mostrarDetallePropietario(propietario.getNombre(), propietario.getSaldo());
    }
    
    public void agregarRecargaSaldo(double monto) {
        
        try {
            propietario.agregarObservador(this);
            Recarga r = propietario.cargarRecarga(monto);
            Fachada.getInstancia().AgregarRecargaPendiente(r);
            
        } catch (PeajeException ex) {
            vistaCargarSaldoPropietario.error(ex.getMessage());
        }
        
        vistaCargarSaldoPropietario.RecargaCreada();
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(SistemaUsuarios.eventos.cambioSaldoPropietario) || evento.equals(SistemaUsuarios.eventos.cambioListaRecargasPendientes)){
            mostrarDetallePropietario();
        }
  
    }
}

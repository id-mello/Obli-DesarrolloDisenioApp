
package controladores;

import java.util.ArrayList;
import logica.Administrador;
import logica.SistemaUsuarios;
import logica.Fachada;
import logica.Propietario;
import logica.Recarga;
import observador.Observable;
import observador.Observador;


public class ControladorAprobarCargaAdministrador implements Observador{
    private IVistaAprobarCargaAdministrador vistaAprobarCargaAdministrador;
    
    private Administrador administrador;
    
    public ControladorAprobarCargaAdministrador(IVistaAprobarCargaAdministrador vista, Administrador u) {
       this.administrador = u;
       this.vistaAprobarCargaAdministrador = vista;
       traerListaRecargas();
    }
    

    public void traerListaRecargas(){
        administrador.agregarObservador(this);
        ArrayList<Recarga> listaRecargas = Fachada.getInstancia().ListadeRecargasPendientes();
        vistaAprobarCargaAdministrador.MostrarRecargas(listaRecargas);
    }

    public void aprobarRecarga(int index) {
        administrador.agregarObservador(this);
        Fachada.getInstancia().aprobarRecarga(index,administrador);
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if( evento.equals(SistemaUsuarios.eventos.cambioListaRecargasPendientes)){
            traerListaRecargas();
        }
    }
    
  
}

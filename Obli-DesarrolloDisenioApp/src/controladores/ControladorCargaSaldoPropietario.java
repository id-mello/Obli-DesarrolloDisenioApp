/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;


import logica.Fachada;
import logica.PeajeException;
import logica.Propietario;
import logica.Recarga;
import logica.SistemaUsuarios;
import observador.Observable;
import observador.Observador;

/**
 *
 * @author Usuario
 */
public class ControladorCargaSaldoPropietario implements Observador{
    private VistaCargaSaldoPropietario vistaCargarSaldoPropietario;
   
    private Propietario propietario;
    

    public ControladorCargaSaldoPropietario(VistaCargaSaldoPropietario vista, Propietario propietario) {
       this.propietario = propietario;
      
       this.vistaCargarSaldoPropietario = vista;
    }
    
    public String mostrarNombrePropietario(){
        return propietario.getNombre();
    }
    
    public double mostrarSaldoPropietario(){
        return propietario.getSaldo();
    }
    public void agregarRecargaSaldo(double monto) throws PeajeException{
        try {
            Recarga r = propietario.cargarRecarga(monto);
            Fachada.getInstancia().AgregarRecargaPendiente(r);
        } catch (PeajeException ex) {
            vistaCargarSaldoPropietario.error(ex.getMessage());
        }
     
      
      vistaCargarSaldoPropietario.RecargaCreada();
    }

    @Override
    public void actualizar(Object evento, Observable origen) {
        if(evento.equals(SistemaUsuarios.eventos.cambioSaldoPropietario)){
            mostrarSaldoPropietario();
        }
    }
}

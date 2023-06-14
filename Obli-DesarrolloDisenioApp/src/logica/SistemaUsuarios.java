
package logica;

import java.util.ArrayList;
import java.util.Date;
import observador.Observable;
import observador.Observador;
 



public class SistemaUsuarios extends Observable{
    
    private ArrayList<Administrador> usuarioAdministrador = new ArrayList();
    private ArrayList<Propietario> listaPropietarios = new ArrayList();
    private ArrayList<Recarga> listaRecargaPendiente = new ArrayList();
    public enum eventos{cambioListaRecargasPendientes,cambioSaldoPropietario,cambioTablaPropietario};
    
 
    public void agregarAdministrador(String nombre, String cedula, String contraseña){
       usuarioAdministrador.add(new Administrador(nombre, cedula, contraseña));
    }
    
    public void agregarPropietario(String nombreCompleto, String cedula, String pass) {
        listaPropietarios.add(new Propietario( nombreCompleto, cedula, pass));       
    }
    
     public ArrayList<Recarga> getListaRecargaPendiente() {
        return listaRecargaPendiente;
    }

    public void setListaRecargaPendiente(ArrayList<Recarga> listaRecargaPendiente) {
        this.listaRecargaPendiente = listaRecargaPendiente;
    }
    

    public ArrayList<Propietario> getListaPropietarios() {
        return listaPropietarios;
    }
    
    
    ////////////////    USUARIOS   //////////////////////////
    
    public Administrador loginAdministrador(String ci, String pass) {
        
        
        Administrador a = (Administrador) buscarUsuarioLogin(ci, pass, usuarioAdministrador);
        
        return (Administrador)  a; 
    }
    
    public Propietario loginPropietario(String cedula, String password){
        
        Propietario p = (Propietario) buscarUsuarioLogin(cedula, password, listaPropietarios);
        
        return  p;
    }

    private Usuario buscarUsuarioLogin(String ci,String pass,ArrayList usuarios){
        Usuario u;
        for(Object obj:usuarios){
            u = (Usuario)obj;
            if(u.getCedula().equals(ci) && u.getContraseña().equals(pass)){
                return u;
            }
        }
        return null;
    }

    
    public Propietario buscarPropietarioPorCI(String cedula) throws PeajeException{
    
        Propietario propietario = null;
        
        int i = 0;
        while(i < listaPropietarios.size() && propietario == null){
            
            if(listaPropietarios.get(i).getCedula().equals(cedula)) propietario=listaPropietarios.get(i);
            i++;
        }
        
        if(propietario == null) throw new PeajeException("No existe el propietario.");
        
        return propietario;
    }
    
    
    ////////////////    VEHICULO   //////////////////////////
    
    Vehiculo buscarVehiculoMatricula(String matricula) throws PeajeException {
        Vehiculo v = null;
        int i = 0;
        
        while(i<listaPropietarios.size() && v == null){
            
            Propietario p = listaPropietarios.get(i);
            v = p.buscarVehiculoMatricula(matricula);
            i++;
        }
        
        if(v == null)throw new PeajeException("No existe el vehículo.");
        
        return v;    
    }

    
    ////////////////    RECARGA   //////////////////////////
    
    public void agregarRecargaPendiente(Recarga r) {
        listaRecargaPendiente.add(r);
        avisar(eventos.cambioListaRecargasPendientes);
    }
    
    
    public void aprobarRecarga(int index,Administrador adm) {
        
        Recarga recargaSeleccionada = listaRecargaPendiente.get(index);
        Propietario p = recargaSeleccionada.getPropietario();
        
        p.actulizarRecarga(adm,recargaSeleccionada);
        listaRecargaPendiente.remove(recargaSeleccionada);
        
        p.avisar(eventos.cambioListaRecargasPendientes);
        adm.avisar(eventos.cambioListaRecargasPendientes);
    }
    
}


package logica;

import java.util.ArrayList;
import observador.Observable;
 



public class SistemaUsuarios extends Observable{
    
    private ArrayList<Administrador> usuarioAdministrador = new ArrayList();
    private ArrayList<Propietario> listaPropietarios = new ArrayList();
    private ArrayList<Recarga> listaRecargaPendiente = new ArrayList();
    
    public enum eventos{cambioListaRecargasPendientes,cambioSaldoPropietario};
    
 
    public void agregarAdministrador(String nombre, String cedula, String contraseña){
       usuarioAdministrador.add(new Administrador(nombre, cedula, contraseña));
    }
    
    public void agregarPropietario(String nombreCompleto, String cedula, String pass) {
        listaPropietarios.add(new Propietario( nombreCompleto, cedula, pass));       
    }
    
    public Administrador loginAdministrador(String ci, String pass) {
        Administrador a = (Administrador) buscarUsuarioLogin(ci, pass, usuarioAdministrador);
        
        return a; 
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
    
    public ArrayList<Recarga> getListaRecargaPendiente() {
        return listaRecargaPendiente;
    }

    public void setListaRecargaPendiente(ArrayList<Recarga> listaRecargaPendiente) {
        this.listaRecargaPendiente = listaRecargaPendiente;
    }
    
    public void quitarRecargaPendiente(Recarga r){
        listaRecargaPendiente.remove(r);
        avisar(eventos.cambioListaRecargasPendientes);
    }

    public ArrayList<Propietario> getListaPropietarios(){
        return listaPropietarios;
    }
    
    public Vehiculo buscarVehiculoMatricula(String matricula) throws PeajeException{
        
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
}

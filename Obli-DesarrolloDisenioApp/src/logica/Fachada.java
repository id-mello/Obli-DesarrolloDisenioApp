
package logica;

import java.util.ArrayList;
import observador.Observable;

/**
 *
 * @author Usuario
 */
public class Fachada extends Observable{
    
    private SistemaUsuarios sistemaUsuarios = new SistemaUsuarios();
    private SistemaPeaje sistemaPeaje = new SistemaPeaje();
    private static Fachada instancia = new Fachada();
    
      public static Fachada getInstancia() {
        return instancia;
    }
      
    private Fachada() {
    }
    
     public void agregarUsarioAdministrador(String nombre, String cedula, String pass) {
        sistemaUsuarios.agregarAdministrador(nombre, cedula, pass);
    }
     
     public void agregarPuesto(String nombre, String direccion){
         sistemaPeaje.AgregarPuesto(nombre, direccion);
    }
     
    public void AgregarPropietario(String nombreCompleto, String cedula, String pass){
        sistemaUsuarios.agregarPropietario(nombreCompleto, cedula, pass);
    }
    
    public void crearCategorias(String nombre){
        sistemaPeaje.crearCategoria(nombre);
    }
    
     public void agregarTarifaPuesto(Puesto puesto, double monto, Categoria cat){
        sistemaPeaje.agregarTarifaPuesto(puesto, monto, cat);
    }    
     
    public Administrador loginAdministrador(String ci, String pass) {
         return sistemaUsuarios.loginAdministrador(ci, pass);
    } 
     
    public Propietario loginPropietario(String cedula, String password){
        return sistemaUsuarios.loginPropietario(cedula, password);
    }
    
    public ArrayList<Categoria> getCategorias(){
        return sistemaPeaje.getListaCategorias();
    }
    
    public ArrayList<Bonificacion> getBonificaciones(){
        return sistemaPeaje.getBonificaciones();
    }
    
    public ArrayList<Puesto> getPuestos(){
        return sistemaPeaje.getPuestos();
    }
    
    public void agregarBoniTrabajador(String nombre, String descripcion, double descuento){
        sistemaPeaje.AgregarBonificacionTrabajo(nombre, descripcion, descuento);
    }
     
    public void agregarBoniExonerado(String nombre, String descripcion, double descuento){
        sistemaPeaje.AgregarBonificacionExonerado(nombre, descripcion, descuento);
    }
     
    public void agregarBoniFrecuente(String nombre, String descripcion, double descuento){
        sistemaPeaje.AgregarBonificacionFrecuente(nombre, descripcion, descuento);
    }
    
    public Propietario buscarPropietarioPorCI(String cedula) throws PeajeException{
        return sistemaUsuarios.buscarPropietarioPorCI(cedula);
    }
     
    public ArrayList<Recarga> ListadeRecargasPendientes(){
    
        return sistemaUsuarios.getListaRecargaPendiente();
    }
    
    public void AgregarRecargaPendiente(Recarga r){
    
         sistemaUsuarios.agregarRecargaPendiente(r);
    }
    
    public Propietario traerPropietario(String usuario){
        
        ArrayList<Propietario> listaPropietarios = sistemaUsuarios.getListaPropietarios();

        for (Propietario propietario : listaPropietarios) {
            if (propietario.getNombre().equals(usuario)) {
                return propietario;
            }
        }
        return null;
    }
    
    public void agregarSaldo(String usu,double monto ){
        Propietario propietarioRecarga = traerPropietario(usu);
        propietarioRecarga.agregarSaldo(monto);
       
    }

    public Vehiculo buscarVehiculoMatricula(String matricula) throws PeajeException {
        return sistemaUsuarios.buscarVehiculoMatricula(matricula);
    }
    
    public void aprobarRecarga(int index,Administrador adm){
        
        sistemaUsuarios.aprobarRecarga(index,adm);
        
       
    }
}

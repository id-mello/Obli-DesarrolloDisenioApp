/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Fachada {
    
    private SistemaAcceso controlAcceso = new SistemaAcceso();
    private SistemaPeaje controlSistema = new SistemaPeaje();
    private static Fachada instancia = new Fachada();
    
      public static Fachada getInstancia() {
        return instancia;
    }
      
    private Fachada() {
    }
    
     public void agregarUsarioAdministrador(String nombre, String pass, String nombreCompleto) {
        controlAcceso.agregarAdministrador(nombre, pass, nombreCompleto);
    }
     
     public void agregarPuesto(String nombre, String direccion){
         controlSistema.AgregarPuesto(nombre, direccion);
    }
     
    public void AgregarPropietario(String nombreCompleto, String cedula, String pass){
        controlAcceso.agregarPropietario(nombreCompleto, cedula, pass);
    }
    
   
    
    public void crearCategorias(String nombre){
        controlSistema.crearCategoria(nombre);
    }
    
     public void agregarTarifaPuesto(Puesto puesto, double monto, Categoria cat){
        controlSistema.agregarTarifaPuesto(puesto, monto, cat);
    }

    public Object loginAdministrador(String ci, String pass) {
         return controlAcceso.loginAdministrador(ci, pass);
    }
    
    
    
    
    ///////////////////////////////////////////////////// NUEVO  /////////////////////////////////////////////////////
    
    public Propietario loginPropietario(String cedula, String password){
        return controlAcceso.loginPropietario(cedula, password);
    }
     
    public ArrayList<Categoria> getCategorias(){
        return controlSistema.getListaCategorias();
    }
    
    public ArrayList<Bonificacion> getBonificaciones(){
        return controlSistema.getBonificaciones();
    }
    
    public ArrayList<Puesto> getPuestos(){
        return controlSistema.getPuestos();
    }
    
    public void agregarBoniTrabajador(String nombre, String descripcion, double descuento){
        controlSistema.AgregarBonificacionTrabajo(nombre, descripcion, descuento);
    }
     
    public void agregarBoniExonerado(String nombre, String descripcion, double descuento){
        controlSistema.AgregarBonificacionExonerado(nombre, descripcion, descuento);
    }
     
    public void agregarBoniFrecuente(String nombre, String descripcion, double descuento){
        controlSistema.AgregarBonificacionFrecuente(nombre, descripcion, descuento);
    }
    
   
     
     
}

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
    
    ///////////////////////////////////////////////////// NUEVO  /////////////////////////////////////////////////////
    
     
    public Administrador loginAdministrador(String ci, String pass) {
         return sistemaUsuarios.loginAdministrador(ci, pass);
    } 
     
    public Propietario loginPropietario(String cedula, String password){
        return sistemaUsuarios.loginPropietario(cedula, password);
    }
     
//    public ArrayList<Propietario> getListaPropietarios(){
//        return controlAcceso.getListaPropietarios();
//    }
    
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
     
     
}

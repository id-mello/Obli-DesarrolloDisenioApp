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
public class SistemaPeaje {
    private ArrayList<Puesto> puestos = new ArrayList();
    private ArrayList<Bonificacion> bonificaciones = new ArrayList();
    private ArrayList<Categoria> listaCategorias = new ArrayList();

       
    public void crearCategoria(String nombre) {
        listaCategorias.add(new Categoria(nombre));
    }
    
    
    public void agregarTarifaPuesto(Puesto puesto, double monto, Categoria cat){
        puesto.agregarTarifa(monto, cat);
    }
    
 
    public void AgregarPuesto(String nombre, String direccion){
        puestos.add(new Puesto(nombre, direccion));
    }
    
    public void AgregarBonificacionTrabajo(String nombre,String descripcion, double descuento){
        bonificaciones.add(new Trabajador(nombre, descripcion, descuento));
        
    }
        public void AgregarBonificacionFrecuente(String nombre,String descripcion, double descuento){
        bonificaciones.add(new Frecuente(nombre, descripcion, descuento));
        
    }
        public void AgregarBonificacionExonerado(String nombre,String descripcion, double descuento){
        bonificaciones.add(new Exonerado(nombre, descripcion, descuento));
        
    }
        
         public ArrayList<Puesto> getPuestos() {
        return puestos;
    }
         
         
   ///////////////////////////////////////////////////// NUEVO  /////////////////////////////////////////////////////

    public ArrayList<Bonificacion> getBonificaciones() {
        return bonificaciones;
    }
   

    public ArrayList<Categoria> getListaCategorias() {
        return listaCategorias;
    }
}

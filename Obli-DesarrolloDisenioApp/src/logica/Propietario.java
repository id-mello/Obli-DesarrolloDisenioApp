/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;


import java.time.LocalDate;
import java.util.ArrayList;

public class Propietario extends Usuario{
    private double saldo;
    private ArrayList<Vehiculo> listaVehiculos;
    private ArrayList<BonificacionAsignada> listaBonificaciones;
    private ArrayList<Transito> listaTransitos;
    private ArrayList<Notificacion> listaNotificaciones;
    private ArrayList<Recarga> listaRecargas;


    public Propietario(String nombre, String cedula, String contraseña) {
        super(nombre, cedula, contraseña);
        this.saldo = 0;
        this.listaVehiculos = new ArrayList();
        this.listaBonificaciones = new ArrayList();
        this.listaTransitos = new ArrayList();
        this.listaNotificaciones = new ArrayList();
        this.listaRecargas = new ArrayList();
    }

    public double getSaldo() {
        return saldo;
    }

    public ArrayList<Vehiculo> getListaVehiculos() {
        return listaVehiculos;
    }

    public ArrayList<BonificacionAsignada> getListaBonificaciones() {
        return listaBonificaciones;
    }

    public ArrayList<Transito> getListaTransitos() {
        return listaTransitos;
    }

    public ArrayList<Notificacion> getListaNotificaciones() {
        return listaNotificaciones;
    }

    public ArrayList<Recarga> getListaRecargas() {
        return listaRecargas;
    }
    
    public void agregarVehículo(String mat, String modelo, String color, Categoria cat){
        listaVehiculos.add(new Vehiculo(mat, modelo, color,cat, this));
    }
    
    
    public void agregarBonificacion(Bonificacion bonificacion, Puesto puesto) throws PeajeException{

        int i = 0;
        while(i < listaBonificaciones.size()){
          
            if(listaBonificaciones.get(i).getPuesto().equals(puesto))throw new PeajeException("Ya tiene una bonificación asignada para ese puesto");
            i++;
        }
        
        BonificacionAsignada nuevaBonificacion = new BonificacionAsignada(bonificacion, puesto, LocalDate.now());

        getListaBonificaciones().add(nuevaBonificacion);
    }
    
    
    
    public void agregarSaldo(double monto){
        this.saldo += monto;
    }
    
    public void restarSaldo(double tarifa){
        this.saldo -= tarifa;
    }
    
    
    public Recarga cargarRecarga(double monto) throws PeajeException{
          if(monto < 1 ) throw new PeajeException("Monto Invalido");
        Recarga r = new Recarga(monto, "pendiente",this.getNombre());
        listaRecargas.add(r);
        return r;
    }
    
    
    
    public Vehiculo buscarVehiculoMatricula(String matricula){

        Vehiculo vehiculo = null;

        for(Vehiculo v : listaVehiculos ){
            if(v.getMatricula().equals(matricula)) return vehiculo = v;
        }
        
        return vehiculo;
    }
            
            
    public Transito agregarUnTransito(Puesto puesto, Vehiculo vehiculo)throws PeajeException{
        
        
        BonificacionAsignada bonificacionAsignada = existeBonificacionEnPuesto(puesto);
        Transito transito = new Transito(puesto,this, bonificacionAsignada, vehiculo);
        
        if(saldo < transito.getMonto()) throw new PeajeException("Saldo insuficiente: " + saldo);
        
        
        listaTransitos.add(transito);
        listaNotificaciones.add(new Notificacion("Pasaste por el puesto " + puesto.getNombre() + " con el vehículo " + vehiculo.getMatricula()));
        
        restarSaldo(transito.getMonto());
        if(saldo < transito.getMonto()) listaNotificaciones.add(new Notificacion("Tu saldo actual es de $" + saldo + ". Te recomendamos hacer una recarga"));
        return transito;
    }
   
    public BonificacionAsignada existeBonificacionEnPuesto(Puesto puesto){

        for(BonificacionAsignada b: listaBonificaciones){
            if(b.getPuesto().equals(puesto)) return b;
        } 
  
        return null;
    }

  
}

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
    private ArrayList<AsignarBonificacion> listaBonificaciones;
    private ArrayList<RegistroTransito> listaTransitos;
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

    public ArrayList<AsignarBonificacion> getListaBonificaciones() {
        return listaBonificaciones;
    }

    public ArrayList<RegistroTransito> getListaTransitos() {
        return listaTransitos;
    }

    public ArrayList<Notificacion> getListaNotificaciones() {
        return listaNotificaciones;
    }

    public ArrayList<Recarga> getListaRecargas() {
        return listaRecargas;
    }
    
    public void agregarVehículo(String mat, String modelo, String color, Categoria cat){
        listaVehiculos.add(new Vehiculo(mat, modelo, color,cat));
    }
    
    
    public void agregarBonificacion(Bonificacion bonificacion, Puesto puesto) throws PeajeException{

        int i = 0;
        while(i < listaBonificaciones.size()){
          
            if(listaBonificaciones.get(i).getPuesto().equals(puesto))throw new PeajeException("“Ya tiene una bonificación asignada para ese puesto");
            i++;
        }
        
        AsignarBonificacion nuevaBonificacion = new AsignarBonificacion(bonificacion, puesto, LocalDate.now());

        getListaBonificaciones().add(nuevaBonificacion);
    }
    
    
    
    public void agregarSaldo(double monto){
        this.saldo += monto;
    }
    
    
    
    public Recarga cargarRecarga(double monto) throws PeajeException{
          if(monto < 1 ) throw new PeajeException("Monto Invalido");
        Recarga r = new Recarga(monto, "pendiente",this.getNombre());
        listaRecargas.add(r);
        return r;
    }
    
    
    
    public boolean existeVehiculoMatricula(String matricula){
    
        boolean encontrado = false;
        int i = 0;

        while(i<getListaVehiculos().size() && !encontrado){

            if(getListaVehiculos().get(i).getMatricula().equals(matricula)) encontrado = true;
            i++;
        }

        return encontrado;
    }
            
            
    public void agregarUnTransito(Puesto puesto){
    
        
    }

  
}

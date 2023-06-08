/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;


import java.util.ArrayList;
import java.util.Date;

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
    
    public void agregarVehículo(String mat, String modelo, String color, Categoria cat) throws Exception{
        listaVehiculos.add(new Vehiculo(mat, modelo, color,cat));
    }
    
    
    public void agregarBonificacion(Bonificacion bonificacion, Puesto puesto){
    
        getListaBonificaciones().add(new AsignarBonificacion(bonificacion,puesto));
    }
    
    public void agregarRecarga(double montoRecarga){
        
        Recarga recarga = new Recarga();
        
        listaRecargas.add(recarga);
    
    }

  
}

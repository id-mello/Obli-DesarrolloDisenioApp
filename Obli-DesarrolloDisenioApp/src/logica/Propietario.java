
package logica;

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
    
    
    ////////////////    VEHICULO   //////////////////////////
    
    public void agregarVehículo(String mat, String modelo, String color, Categoria cat){
        listaVehiculos.add(new Vehiculo(mat, modelo, color,cat,this));
    }
    
    Vehiculo buscarVehiculoMatricula(String matricula) {
        Vehiculo vehiculo = null;
        String matFormateada = matricula.toUpperCase();
        for(Vehiculo v : listaVehiculos ){
            if(v.getMatricula().equals(matFormateada)) return vehiculo = v;
        }
        
        return vehiculo;
    }


    
////////////////    SALDO   //////////////////////////
    
    public void agregarSaldo(double monto){
        this.saldo += monto;
        avisar(eventos.actualizarSaldos);
    }
    
    public void restarSaldo(double tarifa){
        this.saldo -= tarifa;
        avisar(eventos.actualizarSaldos);
    }
    
    
////////////////    NOTIFICACIONES  //////////////////////////
    
    public void agregarNotificacion(String mensaje){
        
        Notificacion noti = new Notificacion(mensaje);
        listaNotificaciones.add(noti);
        avisar(eventos.cambioNotificacion);
    }
    
    public void borrarNotificacion(int indexNotificacion) {
        
        listaNotificaciones.remove(listaNotificaciones.get(indexNotificacion));             
        avisar(eventos.cambioNotificacion);    
        
    }
    
    
    ////////////////    TRANSITO  //////////////////////////
    
    public Transito agregarUnTransito(Puesto puesto, Vehiculo vehiculo)throws PeajeException{
        
        
        BonificacionAsignada bonificacionAsignada = existeBonificacionEnPuesto(puesto);
        Transito transito = new Transito(puesto,this, bonificacionAsignada, vehiculo);
        
        if(saldo < transito.getMontoFinal()) throw new PeajeException("Saldo insuficiente: " + saldo);
        
        
        listaTransitos.add(transito);
        vehiculo.aumentarMontoTotal(transito.getMontoFinal());
        vehiculo.setCantTransitos();
        avisar(eventos.actualizarContadoresVehiculo);
        String mensajeNotificacion = "Pasaste por el puesto " + puesto.getNombre() + " con el vehículo " + vehiculo.getMatricula();
        agregarNotificacion(mensajeNotificacion);
        
        restarSaldo(transito.getMontoFinal());
        
        mensajeNotificacion = "Tu saldo actual es de $" + saldo + ". Te recomendamos hacer una recarga";
        if(saldo < transito.getMontoFinal()) agregarNotificacion(mensajeNotificacion);
        
        return transito;
    }

    
    ////////////////    BONIFICACIONES  //////////////////////////
    
    public BonificacionAsignada existeBonificacionEnPuesto(Puesto puesto){

        for(BonificacionAsignada b: listaBonificaciones){
            if(b.getPuesto().equals(puesto)) return b;
        } 
  
        return null;
    }
    
    public void agregarBonificacion(Bonificacion bonificacion, Puesto puesto) throws PeajeException{
        int i = 0;
        while(i < listaBonificaciones.size()){
          
            if(listaBonificaciones.get(i).getPuesto().equals(puesto))throw new PeajeException("Ya tiene una bonificación asignada para ese puesto");
            i++;
        }
        
        BonificacionAsignada nuevaBonificacion = new BonificacionAsignada(bonificacion, puesto);
        
        listaBonificaciones.add(nuevaBonificacion);
        avisar(eventos.cambioBonificacionesAsignadas);
    }
    
    
    ////////////////    RECARGA   //////////////////////////
    
    public Recarga cargarRecarga(double monto) throws PeajeException{
        
        
        if(monto < 1 ) throw new PeajeException("Monto Invalido");
        
        Recarga r = new Recarga(monto, "pendiente",this);
        listaRecargas.add(r);
        avisar(eventos.listaRecargas);

        return r;
    }
    
    public void actulizarRecarga(Administrador adm, Recarga recargaSeleccionada) {
        
        agregarSaldo(recargaSeleccionada.getMonto());
        recargaSeleccionada.actualizarRecarga(adm);
        avisar(eventos.listaRecargas);
        
        
        String mensajeNotificacion = "Tu recarga de $ " + recargaSeleccionada.getMonto() + " fue aprobada";        
        agregarNotificacion(mensajeNotificacion);
    }
    
    
  
}

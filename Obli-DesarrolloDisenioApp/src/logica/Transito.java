
package logica;

import java.time.LocalDate;



public class Transito {
    
    private LocalDate fecha;
    private Puesto puesto;
    private Double monto; 
    private Propietario propietario;
    private BonificacionAsignada bonificacion;
    private Vehiculo vehiculo; 

    public Transito(Puesto puesto, Propietario propietario, BonificacionAsignada bonificacion, Vehiculo vehiculo) {
        this.fecha = LocalDate.now();
        this.puesto = puesto;
        this.monto = obtenerMonto(puesto,propietario,vehiculo,bonificacion);
        this.propietario = propietario;
        this.bonificacion = bonificacion;
        this.vehiculo = vehiculo;
    }
    

    public LocalDate getFecha() {
        return fecha;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public Double getMonto() {
        return monto;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public BonificacionAsignada getBonificacion() {
        return bonificacion;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    
    public double obtenerMonto(Puesto puesto, Propietario propietario, Vehiculo vehiculo, BonificacionAsignada bonificacion){
        
        double tarifa = puesto.buscarTarifaCategoria(vehiculo.getCategoria());
                
        if(bonificacion != null){
        
            tarifa = bonificacion.getBonificacion().calculoDescuento(propietario.getListaTransitos(), tarifa, puesto);
        }

        return tarifa;    
    }
    
    
}

package logica;

import java.time.LocalDate;



public class Transito {
    
    private LocalDate fecha;
    private Puesto puesto;
    private Double montoFinal; 
    private Propietario propietario;
    private String bonificacion;
    private Vehiculo vehiculo; 
    private double tarifaPuesto;
    private double montoBonificacion;

    public Transito(Puesto puesto, Propietario propietario, BonificacionAsignada bonificacion, Vehiculo vehiculo) {
        
        this.fecha = LocalDate.now();
        this.puesto = puesto;
        this.tarifaPuesto = obtenerTarifaPuesto(puesto, vehiculo);
        this.montoFinal = obtenerMontoFinal(puesto,propietario,tarifaPuesto,bonificacion);
        this.propietario = propietario;
        if(bonificacion != null){
            this.bonificacion = bonificacion.getBonificacion().getNombre();
            this.montoBonificacion = tarifaPuesto-montoFinal;
        }else{
            this.bonificacion = "Sin bonificación";
            this.montoBonificacion = 0;
        }
        this.vehiculo = vehiculo;
    }
    
   
    public LocalDate getFecha() {
        return fecha;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public Double getMontoFinal() {
        return montoFinal;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public String getBonificacion() {
        return bonificacion;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public double getTarifaPuesto() {
        return tarifaPuesto;
    }

    public double getMontoBonificacion() {
        return montoBonificacion;
    }
    
    
    public double obtenerMontoFinal(Puesto puesto, Propietario propietario, double tarifa, BonificacionAsignada bonificacion){
                    
        if(bonificacion != null){
        
            tarifa = bonificacion.getBonificacion().calculoDescuento(propietario.getListaTransitos(), tarifa, puesto);
        }

        return tarifa;    
    }
    
    public double obtenerTarifaPuesto(Puesto puesto, Vehiculo vehiculo){
        double tarifa = puesto.buscarTarifaCategoria(vehiculo.getCategoria());
        return tarifa;
    }
    
    
}

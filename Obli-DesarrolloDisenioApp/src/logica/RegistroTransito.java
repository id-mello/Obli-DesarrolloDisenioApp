
package logica;

import java.util.Date;


public class RegistroTransito {
    
    private Date fecha;
    private Puesto puesto;
    private Double monto; 
    private Propietario propietario;
    private AsignarBonificacion bonificacion;
    private Vehiculo vehiculo; 

    public RegistroTransito(Date fecha, Puesto puesto, Double monto, Propietario propietario, AsignarBonificacion bonificacion, Vehiculo vehiculo) {
        this.fecha = fecha;
        this.puesto = puesto;
        this.monto = monto;
        this.propietario = propietario;
        this.bonificacion = bonificacion;
        this.vehiculo = vehiculo;
    }

    public Date getFecha() {
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

    public AsignarBonificacion getBonificacion() {
        return bonificacion;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }
    
    
    
}

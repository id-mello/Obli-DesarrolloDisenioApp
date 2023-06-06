
package logica;

import java.time.Instant;
import java.util.Date;


public class AsignarBonificacion {
    
    private Bonificacion bonificacion;
    private Puesto puesto;
    private Instant fecha;

    public AsignarBonificacion(Bonificacion bonificacion, Puesto puesto) {
        this.bonificacion = bonificacion;
        this.puesto = puesto;
        this.fecha = Instant.now();
    }

    public Bonificacion getBonificacion() {
        return bonificacion;
    }

    public void setBonificacion(Bonificacion bonificacion) {
        this.bonificacion = bonificacion;
    }

    public Puesto getPuesto() {
        return puesto;
    }

    public void setPuesto(Puesto puesto) {
        this.puesto = puesto;
    }

    public Instant getFecha() {
        return fecha;
    }

    
}

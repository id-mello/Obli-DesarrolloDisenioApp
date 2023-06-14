
package logica;

import java.time.LocalDate;



public class BonificacionAsignada {
    
    private Bonificacion bonificacion;
    private Puesto puesto;
    private LocalDate fecha;
    private String sinBonificacion;

    public BonificacionAsignada(Bonificacion bonificacion, Puesto puesto) {
        
        this.bonificacion = bonificacion;
        this.puesto = puesto;
        this.fecha = LocalDate.now();
    }

    public String getSinBonificacion() {
        return sinBonificacion;
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

    public LocalDate getFecha() {
        return fecha;
    }

    
}

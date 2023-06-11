
package logica;

import java.time.LocalDate;



public class AsignarBonificacion {
    
    private Bonificacion bonificacion;
    private Puesto puesto;
    private LocalDate fecha;

    public AsignarBonificacion(Bonificacion bonificacion, Puesto puesto, LocalDate fecha) {
        
        this.bonificacion = bonificacion;
        this.puesto = puesto;
        this.fecha = fecha;
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

    public void validaciones() throws PeajeException{
    
        if(puesto instanceof Puesto) throw new PeajeException("“Debe especificar un puesto.");
        if(bonificacion instanceof Bonificacion) throw new PeajeException("“Debe especificar una bonificación.");

    }
}

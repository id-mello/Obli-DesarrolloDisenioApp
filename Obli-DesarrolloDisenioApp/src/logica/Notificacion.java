
package logica;

import java.time.LocalDate;


public class Notificacion{
    private LocalDate fecha;
    private String mensaje;

    public Notificacion(String mensaje) {
        this.fecha = LocalDate.now();
        this.mensaje = mensaje;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getMensaje() {
        return mensaje;
    }

}
    
    


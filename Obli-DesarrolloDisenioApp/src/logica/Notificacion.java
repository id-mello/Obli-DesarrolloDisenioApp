/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.time.LocalDate;


/**
 *
 * @author Usuario
 */
public class Notificacion {
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

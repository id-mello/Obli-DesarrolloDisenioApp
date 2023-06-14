/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import observador.Observable;

/**
 *
 * @author Usuario
 */
public abstract class Usuario extends Observable{
    private String nombre;
    private String cedula;
    private String contraseña;

    public enum eventos{cambioBonificacionesAsignadas,cambioNotificacion,listaRecargas,actualizarSaldos,actualizarContadoresVehiculo};
    
    public Usuario(String nombre, String cedula, String contraseña) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.contraseña = contraseña;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
}

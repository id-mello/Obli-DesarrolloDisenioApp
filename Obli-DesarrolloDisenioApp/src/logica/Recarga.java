
package logica;

import java.util.Date;


public class Recarga {
    private Date fecha;
    private double monto;
    private String estado;
    private Administrador usuarioAdministrador;
    private Propietario propietario;

    public Recarga(double monto, String estado, Propietario propietario) {
        this.monto = monto;
        this.estado = estado;
        this.fecha = new Date();
        this.propietario = propietario;
        this.usuarioAdministrador = null;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public void setPropietario(Propietario Propietario) {
        this.propietario = Propietario;
    }

   

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Administrador getUsuarioAdministrador() {
        return usuarioAdministrador;
    }

    public void setUsuarioAdministrador(Administrador usuarioAdministrador) {
        this.usuarioAdministrador = usuarioAdministrador;
    }

    void actualizarRecarga(Administrador adm) {
        usuarioAdministrador = adm;
        estado = "aprobado";
        
    }
    
}


package logica;

import java.util.Date;


public class Recarga {
    private Date fecha;
    private double monto;
    private String estado;
    private Administrador usuarioAdministrador;
    private String nombrePropietario;

    public Recarga(double monto, String estado, String nombrePropietario) {
        this.monto = monto;
        this.estado = estado;
        this.fecha = new Date();
        this.nombrePropietario = nombrePropietario;
        this.usuarioAdministrador = null;
    }

    public String getNombrePropietario() {
        return nombrePropietario;
    }

    public void setNombrePropietario(String nombrePropietario) {
        this.nombrePropietario = nombrePropietario;
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
    
}

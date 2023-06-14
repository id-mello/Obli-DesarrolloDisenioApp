package logica;

import java.util.ArrayList;


public abstract class Bonificacion {
    private String nombre;
    private String descripcion;
    private double descuento;

    public Bonificacion() {
    }

    public Bonificacion(String nombre, String descripcion, double descuento) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.descuento = descuento;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public abstract double calculoDescuento(ArrayList<Transito> lista, double tarifa, Puesto puesto);
   
}

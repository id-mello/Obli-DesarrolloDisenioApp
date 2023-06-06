
package logica;


public class Tarifa {
    private double monto;
    private Categoria categoriaVehiculo;

    Tarifa(double monto, Categoria cat) {
        this.monto = monto;
        this.categoriaVehiculo = cat;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public Categoria getCategoriaVehiculo() {
        return categoriaVehiculo;
    }

    public void setCategoriaVehiculo(Categoria categoriaVehiculo) {
        this.categoriaVehiculo = categoriaVehiculo;
    }
    
    
}

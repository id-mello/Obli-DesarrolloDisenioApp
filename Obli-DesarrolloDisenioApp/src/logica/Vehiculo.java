
package logica;

// PREGUNTAR QUE SE HACE CON CATEGORIA SI HEREDAMOS O ES UN OBJ
public class Vehiculo{
    private String matricula;
    private String modelo;
    private String color;
    private Categoria categoria;
    private Propietario propietario;
    private int cantTransitos;
    private double montoTotal;


    Vehiculo(String mat, String modelo, String color, Categoria cat, Propietario propietario) {
        this.matricula = mat;
        this.modelo = modelo;
        this.color = color;
        this.categoria = cat;
        this.propietario = propietario;
        this.cantTransitos = 0;
        this.montoTotal = 0;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getModelo() {
        return modelo;
    }

    public String getColor() {
        return color;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Propietario getPropietario() {
        return propietario;
    }

    public int getCantTransitos() {
        return cantTransitos;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public void setCantTransitos() {
        this.cantTransitos++;
    }
    
    public void aumentarMontoTotal(double monto){
        this.montoTotal += monto;
    }
    
    
}

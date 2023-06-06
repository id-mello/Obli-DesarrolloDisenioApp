
package logica;

// PREGUNTAR QUE SE HACE CON CATEGORIA SI HEREDAMOS O ES UN OBJ
public class Vehiculo{
    private String matricula;
    private String modelo;
    private String color;
    private Categoria categoria;

    Vehiculo(String mat, String modelo, String color, Categoria cat) {
        this.matricula = matricula;
        this.modelo = modelo;
        this.color = color;
        this.categoria = categoria;
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
}

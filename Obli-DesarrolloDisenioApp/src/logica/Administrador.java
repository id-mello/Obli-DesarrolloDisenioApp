
package logica;


public class Administrador extends Usuario{

    private boolean logueado;
    
    public Administrador(String nombre, String cedula, String contraseña) {
        super(nombre, cedula, contraseña);
        this.logueado = false;
    }

    public boolean isLogueado() {
        return logueado;
    }

    public void setLogueado(boolean logueado) {
        this.logueado = logueado;
    }

    
    
}

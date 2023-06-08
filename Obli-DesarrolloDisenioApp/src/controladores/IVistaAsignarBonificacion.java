
package controladores;

import java.util.ArrayList;
import logica.Bonificacion;
import logica.Propietario;
import logica.Puesto;


public interface IVistaAsignarBonificacion {

    public void mostrarBonificaciones(ArrayList<Bonificacion> bonificaciones);

    public void mostrarPuestos(ArrayList<Puesto> puestos);
    
    public void mostrarAsignaciones(Propietario contacto);
}

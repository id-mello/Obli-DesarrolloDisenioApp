
package logica;


import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Exonerado extends Bonificacion{

    public Exonerado() {
    }

    public Exonerado(String nombre, String descripcion, double descuento) {
        super(nombre, descripcion, descuento);
    }

    @Override
    public double calculoDescuento(ArrayList<Transito> listaTransitos, double tarifa, Puesto puesto) {

        //No pagan el transito en un determinado puesto 
        return getDescuento();
    }

    
}

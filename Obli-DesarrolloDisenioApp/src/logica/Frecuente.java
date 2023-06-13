
package logica;

import java.time.LocalDate;
import java.util.ArrayList;


public class Frecuente extends Bonificacion{

    public Frecuente() {
    }

    public Frecuente(String nombre, String descripcion, double descuento) {
        super(nombre, descripcion, descuento);
    }

    @Override
    public double calculoDescuento(ArrayList<Transito> listaTransitos, double tarifa, Puesto puesto) {
        
        for(Transito t : listaTransitos){
            
            if(t.getFecha().equals(LocalDate.now()) && t.getPuesto().equals(puesto)){
                tarifa = tarifa*0.50;
                return tarifa;
                //50% de descuento a partir del segundo transito realizado en el día por un puesto determinado con el mismo vehículo. 
                //En el primer transito del día (con cada vehículo) no tienen descuento
            }
        }
        
        return tarifa;
    }
    
}

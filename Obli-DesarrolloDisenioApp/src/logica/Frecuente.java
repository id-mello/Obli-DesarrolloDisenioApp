/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Frecuente extends Bonificacion{

    public Frecuente() {
    }

    public Frecuente(String nombre, String descripcion, double descuento) {
        super(nombre, descripcion, descuento);
    }

    @Override
    public double calculoDescuento() {
        
        double monto = 0;
        boolean paso = false;
        
//        for(RegistroTransito rt : ){
//        
//        }
        
        return monto;
    }

//    Tienen un 50% de descuento a partir del segundo transito realizado en el día 
//por un puesto determinado con el mismo vehículo. En el primer transito del día (con cada 
//vehículo) no tienen descuento.

    
}

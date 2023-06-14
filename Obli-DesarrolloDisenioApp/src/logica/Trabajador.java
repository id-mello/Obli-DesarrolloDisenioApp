/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Usuario
 */
public class Trabajador extends Bonificacion{

    
    
    
    public Trabajador(String nombre, String descripcion, double descuento) {
        super(nombre, descripcion, descuento);
    }

    @Override
    public double calculoDescuento(ArrayList<Transito> listaTransitos, double tarifa, Puesto puesto) {
        
        LocalDate fecha = LocalDate.now();
        DayOfWeek diaSemana = fecha.getDayOfWeek();
        if(diaSemana != DayOfWeek.SATURDAY && diaSemana != DayOfWeek.SUNDAY){
            tarifa = tarifa*getDescuento();
            // Tienen un 80% de descuento si el tránsito por el puesto se realiza en un día de semana
        }

        return tarifa;
    }
}

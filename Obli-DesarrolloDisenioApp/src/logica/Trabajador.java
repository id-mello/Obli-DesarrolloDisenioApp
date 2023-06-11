/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Usuario
 */
public class Trabajador extends Bonificacion{

    
    
    
    public Trabajador(String nombre, String descripcion, double descuento) {
        super(nombre, descripcion, descuento);
    }

    @Override
    public double calculoDescuento() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
   
}

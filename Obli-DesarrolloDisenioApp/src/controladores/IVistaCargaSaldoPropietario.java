/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import logica.Propietario;

/**
 *
 * @author Usuario
 */
public interface IVistaCargaSaldoPropietario {
    
    public void mostrarDetallePropietario(String nombre, double saldo);
    
    public void RecargaCreada();

    public void error(String message);
    
}

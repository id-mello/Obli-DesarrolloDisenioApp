/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladores;

import java.util.ArrayList;
import logica.Administrador;
import logica.Recarga;

/**
 *
 * @author Usuario
 */
public interface IVistaAprobarCargaAdministrador {
    public void MostrarRecargas(ArrayList<Recarga> lista);
    
    public void RecargaAprobada();

    public void error(String message);
    
}

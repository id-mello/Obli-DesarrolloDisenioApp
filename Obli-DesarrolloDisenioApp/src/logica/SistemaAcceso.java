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
public class SistemaAcceso {
    
    private ArrayList<Administrador> usuarioAdministrador = new ArrayList();
    private ArrayList<Propietario> listaPropietario = new ArrayList();
    
   /* public void agregarUsarioAdministrador(String nombre,String pass,String nombreCompleto){
        administradores.add(new UsuarioAdministrador(nombre, pass, nombreCompleto));
        
    }*/
    public void agregarAdministrador(String nombre, String cedula, String contraseña){
       usuarioAdministrador.add(new Administrador(nombre, cedula, contraseña));
    }
    
    public void agregarPropietario(String nombreCompleto, String cedula, String pass) {
        listaPropietario.add(new Propietario( nombreCompleto, cedula, pass));       
    }
    
    public Propietario loginPropietario(String cedula, String password){
        
        Propietario p = (Propietario) buscarUsuario(cedula, password, listaPropietario);
        
        return  p;
    }

    private Usuario buscarUsuario(String ci,String pass,ArrayList usuarios){
        Usuario u;
        for(Object obj:usuarios){
            u = (Usuario)obj;
            if(u.getCedula().equals(ci) && u.getContraseña().equals(pass)){
                return u;
            }
        }
        return null;
    }


   

    Object loginAdministrador(String ci, String pass) {
        Administrador a = (Administrador) buscarUsuario(ci, pass, usuarioAdministrador);
        
        return (Administrador)  a; 
    }

    
}

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
public class SistemaUsuarios {
    
    private ArrayList<Administrador> usuarioAdministrador = new ArrayList();
    private ArrayList<Propietario> listaPropietarios = new ArrayList();
    
   /* public void agregarUsarioAdministrador(String nombre,String pass,String nombreCompleto){
        administradores.add(new UsuarioAdministrador(nombre, pass, nombreCompleto));
        
    }*/
    public void agregarAdministrador(String nombre, String cedula, String contraseña){
       usuarioAdministrador.add(new Administrador(nombre, cedula, contraseña));
    }
    
    public void agregarPropietario(String nombreCompleto, String cedula, String pass) {
        listaPropietarios.add(new Propietario( nombreCompleto, cedula, pass));       
    }
    
    public Administrador loginAdministrador(String ci, String pass) {
        Administrador a = (Administrador) buscarUsuarioLogin(ci, pass, usuarioAdministrador);
        
        return (Administrador)  a; 
    }
    
    public Propietario loginPropietario(String cedula, String password){
        
        Propietario p = (Propietario) buscarUsuarioLogin(cedula, password, listaPropietarios);
        
        return  p;
    }

    private Usuario buscarUsuarioLogin(String ci,String pass,ArrayList usuarios){
        Usuario u;
        for(Object obj:usuarios){
            u = (Usuario)obj;
            if(u.getCedula().equals(ci) && u.getContraseña().equals(pass)){
                return u;
            }
        }
        return null;
    }

    
    public Propietario buscarPropietarioPorCI(String cedula){
    
        Propietario propietario = null;
        
        int i = 0;
        while(i <= listaPropietarios.size() && propietario == null){
            
            if(listaPropietarios.get(i).getCedula() == cedula) propietario=listaPropietarios.get(i);
            i++;
        }
        
        return propietario;
    }
    
    

}

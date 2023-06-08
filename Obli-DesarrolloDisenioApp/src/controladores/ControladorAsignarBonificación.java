
package controladores;

import java.util.ArrayList;
import javax.swing.JTable;
import logica.Bonificacion;
import logica.Fachada;
import logica.Propietario;
import logica.Puesto;



public class ControladorAsignarBonificación {
    
    
    private IVistaAsignarBonificacion iVista;
    private Propietario propietario;

    public ControladorAsignarBonificación(IVistaAsignarBonificacion iVista) {
        this.iVista = iVista;
        mostrarBonificaciones();
        mostrarPuestos();
    }
    
    
    private void mostrarBonificaciones(){
        ArrayList<Bonificacion> bonificaciones = Fachada.getInstancia().getBonificaciones();
        iVista.mostrarBonificaciones(bonificaciones);
    }
    
    private void mostrarPuestos(){
        ArrayList<Puesto> puestos = Fachada.getInstancia().getPuestos();
        iVista.mostrarPuestos(puestos);
    }
    
    public void buscarPropietarioPorCI(String cedula){
        
        propietario = Fachada.getInstancia().buscarPropietarioPorCI(cedula);
        
        iVista.mostrarAsignaciones(propietario);
        
    }

    public void agregarBonificacion(String cedula, Bonificacion bonificacion, Puesto puesto) {
        
        
        propietario.agregarBonificacion(bonificacion, puesto);
        
    }

    
    
    
}

//
// @Override
//    public void mostrarContactos(ArrayList<Contacto> contactos) {
//    
//        ArrayList<String> listado = new ArrayList();
//        for (Contacto c : contactos) {
//            listado.add(formatear(c));
//        }
//        listaResultado.setListData(listado.toArray());
//    }
//
//    private String formatear(Contacto c) {
//        return c.getNombre() + " (" + c.getTelefono() + ")";
//    }
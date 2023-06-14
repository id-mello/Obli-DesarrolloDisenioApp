
package sistemapeaje;

import logica.Fachada;
import logica.Propietario;



public class DatosPruebas {
    private static Fachada fachada = Fachada.getInstancia();
    
   public static void cargar() throws Exception{
       
       //AGREGAR USUARIOS ADM Y PROP
        fachada.agregarUsarioAdministrador("Gino Sandona","12345678","admin" );
        fachada.agregarUsarioAdministrador("Ignacio De Mello","87654321", "admin2" );
       
        

       
        fachada.AgregarPropietario("Diego Rolan", "11111111", "1");
        fachada.AgregarPropietario( "Washington Abreu","22222222","1");
        fachada.AgregarPropietario( "Walter Gargano","33333333","1");
       
        fachada.agregarPuesto("Pando", "Ruta IB, Km33");
        fachada.agregarPuesto("Solís", "Ruta IB, Km81");
       
        fachada.agregarBoniExonerado("Exonerados", "No pagan el transito en un determinado puesto", 100);
        fachada.agregarBoniFrecuente("Frecuentes", "50% de descuento a partir del segundo transito realizado en el día por un puesto determinado con el mismo vehículo", 50);
        fachada.agregarBoniTrabajador("Trabajadores", "80% de descuento si el tránsito por el puesto se realiza en un día de semana", 80);
      
        fachada.crearCategorias("Auto");        
        fachada.crearCategorias("Camion");
        fachada.crearCategorias("Omnibus");
        fachada.crearCategorias("Moto");

        fachada.agregarTarifaPuesto(fachada.getPuestos().get(0), 100, fachada.getCategorias().get(0));
        fachada.agregarTarifaPuesto(fachada.getPuestos().get(0), 150, fachada.getCategorias().get(1));
        fachada.agregarTarifaPuesto(fachada.getPuestos().get(0), 145, fachada.getCategorias().get(2));
        fachada.agregarTarifaPuesto(fachada.getPuestos().get(0), 30, fachada.getCategorias().get(3));

        fachada.agregarTarifaPuesto(fachada.getPuestos().get(1), 100, fachada.getCategorias().get(0));
        fachada.agregarTarifaPuesto(fachada.getPuestos().get(1), 155, fachada.getCategorias().get(1));
        fachada.agregarTarifaPuesto(fachada.getPuestos().get(1), 160, fachada.getCategorias().get(2));
        fachada.agregarTarifaPuesto(fachada.getPuestos().get(1), 30, fachada.getCategorias().get(3));

        Propietario p = (Propietario) fachada.loginPropietario("11111111", "1");
        p.agregarVehículo("SBX0000", "Nissan Note", "Gris", fachada.getCategorias().get(0));
        p.agregarVehículo("SMB456", "Kawasaki", "Negra", fachada.getCategorias().get(3));
        
        
        p = (Propietario) fachada.loginPropietario("22222222", "1");
        p.agregarVehículo("SBB1234", "Ford Focus", "Blanco", fachada.getCategorias().get(0));
        p.agregarVehículo("SBT1111", "Scania", "Rojo", fachada.getCategorias().get(1));
        
        p = (Propietario) fachada.loginPropietario("33333333", "1");
        p.agregarVehículo("SBN4555", "Mercedes Benz", "Blanco", fachada.getCategorias().get(2));
   }
   
   public static void probar(){
      
   }
    
}




/*
  private static Fachada fachada = Fachada.getInstancia();
    
    public static void cargar(){
       
        fachada.agregarUsarioAgenda("a", "a", "Ana");
        fachada.agregarUsarioAgenda("b", "b", "Beatriz");
        fachada.agregarUsarioAgenda("c", "c", "Carlos");
        
        fachada.agregarUsarioAdministrador("x", "x", "Ximena");
        fachada.agregarUsarioAdministrador("y", "y", "Yamandu");
        
        fachada.crearTipoContacto("Particular");
        fachada.crearTipoContacto("Familiar");
        fachada.crearTipoContacto("Laboral");
        
         fachada.crearTipoTelefono("Fijo");
         fachada.crearTipoTelefono("Celular");
         fachada.crearTipoTelefono("Internacional");
        
    }
    public static void probar() throws AgendaException{
        Conexion c = fachada.loginAgenda("a","a");
        UsuarioAgenda u = c.getUsuario();
        u.getAgenda().crearContacto("Juan Perez",
                                    "12345678",
                                    fachada.getTiposContacto().get(0),
                                    fachada.getTiposTelefono().get(0));
        
        System.out.println("Nombre completo: " + u.getNombreCompleto());
        System.out.println("Cantidad contactos: " + u.getAgenda().cantidadContactos());
        System.out.println("Contactos:");
        System.out.println(u.getAgenda().getContactos());
    }
*/
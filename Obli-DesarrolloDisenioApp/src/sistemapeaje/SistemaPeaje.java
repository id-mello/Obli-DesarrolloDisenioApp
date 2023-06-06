package sistemapeaje;

import iuEscritorio.SistemaPeajeApp;

public class SistemaPeaje {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        
        DatosPruebas.cargar();
        new SistemaPeajeApp().setVisible(true);
    }
    
}

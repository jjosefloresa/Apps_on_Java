package aplicacionoracle;

import org.jdesktop.application.Application;
import org.jdesktop.application.SingleFrameApplication;

public class AplicacionOracleApp extends SingleFrameApplication {

    @Override protected void startup() {
        show(new AplicacionOracleView(this));
    }

    @Override protected void configureWindow(java.awt.Window root) {
    }

    public static AplicacionOracleApp getApplication() {
        return Application.getInstance(AplicacionOracleApp.class);
    }

    public static void main(String[] args) {
        //launch(AplicacionOracleApp.class, args);
        Exemplo called =  new Exemplo();
        //Oracle_ddl salida = new Oracle_ddl();
        ConexionBD ob = new ConexionBD();
        //ob.main(args);
        //salida.setVisible(true);
        called.setVisible(true);
    }
}

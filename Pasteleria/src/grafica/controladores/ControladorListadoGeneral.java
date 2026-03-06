package grafica.controladores;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Properties;

import grafica.ventanas.VentanaListadoGeneral;
import interfaz.IFachada;
import logica.valueobjects.VOPostre;

public class ControladorListadoGeneral {

    private IFachada fachada;
    private VentanaListadoGeneral ven;

    public ControladorListadoGeneral(VentanaListadoGeneral ven) {
        this.ven = ven;

        try {
            Properties p = new Properties();
            String nomArch = "config/datos.properties";
            p.load(new FileInputStream(nomArch));

            String ip = p.getProperty("ipServidor");
            String puerto = p.getProperty("puertoServidor");

            String ruta = "//" + ip + ":" + puerto + "/Pasteleria";
            fachada = (IFachada) Naming.lookup(ruta);

        } catch (Exception e) {
            e.printStackTrace();
            ven.mostrarMensaje("No se pudo conectar con el servidor.");
        }
    }
    
    //Obtiene la lsita de Postres de la Fachada y la pasa a la ventana
    public void ObtenerListaPostresdeFachada() {
        try {
            ArrayList<VOPostre> lista = fachada.ListadoGeneralPostre();
            ven.cargarTablaPostresVentana(lista);
            
        } catch (RemoteException e) {
            ven.mostrarMensaje("Error de conexión con el servidor.");
            e.printStackTrace();
        } catch (Exception e) {
            ven.mostrarMensaje("Error al cargar el listado.");
            e.printStackTrace();
        }
    }
}
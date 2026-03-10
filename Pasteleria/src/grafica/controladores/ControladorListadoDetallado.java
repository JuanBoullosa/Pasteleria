package grafica.controladores;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Properties;

import grafica.ventanas.VentanaListadoGeneral;
import interfaz.IFachada;
import logica.excepciones.AlfanumericoException;
import logica.excepciones.PostreException;
import logica.excepciones.PrecioException;
import logica.negocio.Light;
import logica.valueobjects.VOLightDetallado;
import logica.valueobjects.VOPostre;
import logica.valueobjects.VOPostreDetallado;
import grafica.ventanas.VentanaListadoDetallado;

public class ControladorListadoDetallado {

	private IFachada fachada;
    private VentanaListadoDetallado ven;

    public ControladorListadoDetallado(VentanaListadoDetallado ven) {
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
            ven.mostrarMensaje("No se pudo conectar con el servidor.");
        }
    }
    
    public void ObtenerVOPostreDetallado(String codigo) {
    	 try {
    		 VOPostreDetallado vop = fachada.ListarPostreDetallado(codigo);
    		 
    		 ven.cargarPostresVentana(vop);
    		 
    	 } catch (AlfanumericoException e) {
     	    ven.mostrarMensaje(e.darMensaje());
     	} catch (PostreException e) {
     	    ven.mostrarMensaje(e.darMensaje());	 	  
         } catch (RemoteException e) {
             ven.mostrarMensaje("Error de conexión con el servidor.");
         } catch (Exception e) {
             ven.mostrarMensaje("Error al cargar el listado.");
         }
    }
}

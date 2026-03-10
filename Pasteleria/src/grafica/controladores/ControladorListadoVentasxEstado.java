package grafica.controladores;

import interfaz.IFachada;
import logica.valueobjects.VOVenta;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.LinkedList;
import java.util.Properties;

import grafica.ventanas.VentanaListadoVentasxEstado;

public class ControladorListadoVentasxEstado {
	
	private IFachada fachada;
	private VentanaListadoVentasxEstado ven;
	
	public ControladorListadoVentasxEstado(VentanaListadoVentasxEstado ven) 
	{
		this.ven = ven;
		
		try {
		    Properties p = new Properties();
		    String nomArch = "config/datos.properties";
		    p.load(new FileInputStream(nomArch));

		    String ip = p.getProperty("ipServidor");
		    String puerto = p.getProperty("puertoServidor");

		    String ruta = "//" + ip + ":" + puerto + "/Pasteleria";

		    // IMPORTANTE: asignar al atributo fac
		    fachada = (IFachada) Naming.lookup(ruta);

		} catch (Exception e) {
		    ven.mostrarMensaje("No se pudo conectar con el servidor.");
		}
			}
	
	public void cargarListado(String Estado) {
       try {
            
	
            LinkedList<VOVenta> lista2 = fachada.ListadoVentasxEstado(Estado);
	
            ven.cargarTabla(lista2);
            
        } catch (RemoteException e) {
            ven.mostrarMensaje("Error de conexión con el servidor.");
        } catch (Exception e) {
            ven.mostrarMensaje("Error al cargar el listado.");
        }
    }
}



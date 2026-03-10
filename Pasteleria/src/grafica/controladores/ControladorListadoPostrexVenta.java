package grafica.controladores;

import interfaz.IFachada;
import grafica.ventanas.VentanaListadoPostreXVenta;

import logica.valueobjects.VOPostreCantidad;
import logica.valueobjects.VOVenta;
import logica.excepciones.NroVentaException;
import logica.excepciones.NoPoseePostreException;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Properties;

public class ControladorListadoPostrexVenta {
	
	private IFachada fachada;
	private VentanaListadoPostreXVenta ven;

	
	public ControladorListadoPostrexVenta(VentanaListadoPostreXVenta ven) 
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

	public void cargarListado(String numVenta) {
	       try {
	    	   
	    	   
	    	   if(numVenta == null || numVenta.isEmpty()) {
	    		   ven.mostrarMensaje("Ingrese un Numero de Venta");
	    		   return;
	    	   }
	    	   	int num = Integer.parseInt(numVenta);
	    	   	
	            ArrayList<VOPostreCantidad> lista2 = fachada.ListadoPostresVenta(num);
		
	            ven.cargarTabla(lista2);
	            
	       } catch (NumberFormatException e) {
	           ven.mostrarMensaje("El número de venta debe ser numérico.");

	       } catch (NroVentaException e) {
	           ven.mostrarMensaje(e.darMensaje());

	       } catch (NoPoseePostreException e) {
	           ven.mostrarMensaje(e.darMensaje());

	       } catch (RemoteException e) {
	           ven.mostrarMensaje("Error de conexión con el servidor.");
	       }
	}
}
	   

	    
	


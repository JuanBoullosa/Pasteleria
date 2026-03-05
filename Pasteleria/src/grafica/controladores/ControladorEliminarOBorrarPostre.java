package grafica.controladores;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Properties;

import grafica.ventanas.VentanaEliminarOBorrarPostre;

import interfaz.IFachada;
import logica.excepciones.*;

public class ControladorEliminarOBorrarPostre {
	
	private IFachada	fachada	;
	private VentanaEliminarOBorrarPostre ven;
	
	public ControladorEliminarOBorrarPostre (VentanaEliminarOBorrarPostre ven  ) 
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
	            e.printStackTrace();
	            ven.mostrarInfo("No se pudo conectar con el servidor.");
	        }
	}
	
	
	public void EliminarOBorrarPostre (String codigo, String numventa, String cant )
	{
		
		
		try
		{
			  if ( codigo == null || codigo.isBlank()) {
	              ven.mostrarError("Ingrese codigo");
	              return;
			  }
			  if ( numventa == null || numventa.isBlank()) {
	              ven.mostrarError("Ingrese numero de venta");
	              return;
			  }
			  if ( cant == null || cant.isBlank()) {
	              ven.mostrarError("Ingrese cantidad");
	              return;
			  }
			  
			  
			  
			  String c = codigo;
			     int n = Integer.parseInt(numventa);
			     int can = Integer.parseInt(cant);
			
			     fachada.eliminarOBorrarPostreEs_Vendidos(c, can, n); //CODIGO,  CANTIDAD, NUMERO DE VENTA
		         ven.mostrarInfo("Postre eliminado correctamente");
		         ven.limpiar();

		}
		
		
		catch (NumberFormatException e) {
			ven.mostrarInfo("Número de venta y cantidad deben ser enteros");
		}
		catch (CantidadException e)
		{
			ven.mostrarInfo(e.darMensaje());

		}
		catch (AlfanumericoException e)
		{
			ven.mostrarInfo(e.darMensaje());

		}
		catch (PostreException e)
		{
			ven.mostrarInfo(e.darMensaje());

		}
		catch (ExisteVentaException e)
		{
			ven.mostrarInfo(e.darMensaje());

		}	
		catch (RemoteException e)
		{
			ven.mostrarInfo("Error de comunicacion con el servidor");

		}	
		
		;
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	

}

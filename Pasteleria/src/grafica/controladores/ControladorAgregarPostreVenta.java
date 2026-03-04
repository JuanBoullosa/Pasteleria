package grafica.controladores;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Properties;

import grafica.ventanas.VentanaAgregarPostreEnVenta;
import grafica.ventanas.VentanaNuevaVenta;
import interfaz.IFachada;
import logica.excepciones.AlfanumericoException;
import logica.excepciones.CantidadException;
import logica.excepciones.ExisteVentaException;
import logica.excepciones.IngresoCantidadException;
import logica.excepciones.LimiteUnidadesException;
import logica.excepciones.PostreException;


public class ControladorAgregarPostreVenta {
	
	
	private IFachada fachada;
	private VentanaAgregarPostreEnVenta ven;
	
	public ControladorAgregarPostreVenta (VentanaAgregarPostreEnVenta ven  ) 
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
	
	
	
	public void AgregarPostreVenta( String codigo, String numventa, String cant    )
	{
		
		
              
		
		try {
			
			
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
			
		
			fachada.agregarPostreEnVenta(c, can, n); //CODIGO,  CANTIDAD, NUMERO DE VENTA
            ven.mostrarInfo("Postre agregado correctamente");
			ven.limpiar();
			
			
		}
		
		catch (RemoteException e) {
    	    ven.mostrarInfo("Error de comunicacion con el servidor");
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
		catch (IngresoCantidadException e)
		{
			ven.mostrarInfo(e.darMensaje());;
		}
		catch (LimiteUnidadesException e)
		{
			ven.mostrarInfo(e.darMensaje());
		}catch (Exception e) {
	        ven.mostrarError("Error inesperado: " + e.getMessage());
	    }
		
		
		
		
		
		
		
	}
	
	
	
	

}

package grafica.controladores;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Properties;

import grafica.ventanas.VentanaNuevaVenta;
import interfaz.IFachada;
import logica.excepciones.FechaException;
import logica.valueobjects.VOVentaIngreso;

public class ControladorNuevaVenta {
	
	private IFachada fachada;
	private VentanaNuevaVenta ven;
	
	public ControladorNuevaVenta (VentanaNuevaVenta ven  ) 
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

	
	
	public void NuevaVenta(String dia, String mes, String anio, String direccion){
		
		try
		{
			  if (direccion == null || direccion.isBlank()) {
	                ven.mostrarError("La dirección no puede ser vacía.");
	                return;
	            }

			
		
					int d = Integer.parseInt(dia);
				     int m = Integer.parseInt(mes);
				     int a = Integer.parseInt(anio);

				     LocalDate fecha = LocalDate.of(a, m, d);
				     if (fecha.isAfter(LocalDate.now())) {
				    	    ven.mostrarError("La fecha no puede ser mayor a la fecha actual.");
				    	    return;
				    	}
				     VOVentaIngreso vov = new VOVentaIngreso(direccion, fecha);

				     fachada.nuevaVenta(vov);
				     ven.limpiar();
					
			
		}
			catch (RemoteException e) {
	    	    ven.mostrarInfo("Error de comunicacion con el servidor");
	    	}
			catch (FechaException e)
			{
				ven.mostrarInfo(e.darMensaje());;
			}
			catch (NumberFormatException e) {
		         ven.mostrarError("Ingrese correctamente la fecha.");
		    }catch (Exception e) {
		         ven.mostrarError("Error al iniciar venta: " + e.getMessage());
		    }
	
		
	}
	
}



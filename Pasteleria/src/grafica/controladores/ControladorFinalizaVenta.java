package grafica.controladores;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Properties;

import grafica.ventanas.VentanaFinalizaVenta;
import interfaz.IFachada;
import logica.excepciones.ExisteVentaException;
import logica.excepciones.FinalizadaException;
import logica.excepciones.IndicacionException;

public class ControladorFinalizaVenta {
	private IFachada fachada;
	private VentanaFinalizaVenta ven;
	
	public ControladorFinalizaVenta(VentanaFinalizaVenta ven)
	
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
    ven.mostrarError("No se pudo conectar con el servidor.");
}
	}

public void finalizarVenta(String numVenta, String indicacion) {
	try
	{
		
		if(numVenta == null || numVenta.isEmpty()) {
 		   ven.mostrarError("Ingrese un Numero de Venta");
 		   return;
		 }
		
		int num = Integer.parseInt(numVenta);

		float monto = fachada.finalizarVenta(num, indicacion);  // NUMERO DE VENTA, INDICACION
		
		if(indicacion.equalsIgnoreCase("CONFIRMAR")) {
			if(monto == 0) {
				ven.mostrarError("La venta no posee Postres.");
			} else {
				ven.mostrarError("Venta Finalizada\nMonto a pagar: $" + monto);
				ven.limpiar();
			}
		}else {
			ven.mostrarError("Venta Cancelada y eliminada.");
			ven.limpiar();
		}
	} catch (NumberFormatException e) {
        ven.mostrarError("El número de venta debe ser numérico.");
       
	}catch (ExisteVentaException e)
	{
		ven.mostrarError(e.darMensaje());
		
	}
	catch (IndicacionException e)
	{
		ven.mostrarError(e.darMensaje());
		
	}
	catch (FinalizadaException e)
	{
		ven.mostrarError(e.darMensaje());
		
	}
 catch (RemoteException e) {
    ven.mostrarError("Error de comunicacion con el servidor");
}
	
}

}

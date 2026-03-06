package grafica.controladores;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.Properties;

import grafica.ventanas.VentanarecaudacionXPostreXfecha;
import interfaz.IFachada;
import logica.excepciones.*;
import logica.valueobjects.VORecaudado;


public class ControladorRecaudacionXPostreXfecha {
	
	private IFachada fachada;
	private VentanarecaudacionXPostreXfecha ven;
	
	public ControladorRecaudacionXPostreXfecha ( VentanarecaudacionXPostreXfecha ven )
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
	
	public void RecaudacioneXPostreXfecha ( String codigo, String dia, String mes, String anio  )
	{
	try {
		
		  if (codigo == null || codigo.isBlank()) {
              ven.mostrarInfo("El codigo no puede ser nulo.");
              return;
		  }
		  if (dia == null || dia.isBlank() || mes == null || mes.isBlank() || anio == null || anio.isBlank()) {
	            ven.mostrarError("Ingrese día, mes y año.");
	            return;
	        }
		  
			int d = Integer.parseInt(dia);
		     int m = Integer.parseInt(mes);
		     int a = Integer.parseInt(anio);
              
		     LocalDate fecha = LocalDate.of(a, m, d);
		     VORecaudado vo = fachada.recaudacionXPostreXfecha(codigo.trim(), fecha);

		     ven.mostrarResultado(vo);
		     //fachada.recaudacionXPostreXfecha(codigo, fecha);
		
		
		
	}catch (RemoteException e) {
	    ven.mostrarInfo("Error de comunicacion con el servidor");
	}
	catch(AlfanumericoException e) {
		ven.mostrarInfo(e.darMensaje());;
	}
	catch(PostreException e) {
		ven.mostrarInfo(e.darMensaje());;
	}
		
	
	}
	
	

}

package grafica.controladores;

import grafica.ventanas.Menu;
import java.io.FileInputStream;
import java.rmi.Naming;
import java.util.Properties;

import interfaz.IFachada;

public class ControladorMenu {
	
	private  IFachada fachada;
	private Menu ven;
	
	public ControladorMenu (Menu ven ){ 
		
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
	
	
	public void RespaldarMenu ()
	{
		
		  try {
	            fachada.respaldar();
	            ven.mostrarInfo("Sistema respaldado correctamente.");
		    } catch (Exception e) {
		        ven.mostrarError("Error al respaldar: " + e.getMessage());
	        }
		
      
	}
	
	

}

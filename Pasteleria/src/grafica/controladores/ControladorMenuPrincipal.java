package grafica.controladores;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.util.Properties;
import grafica.ventanas.MenuPrincipal;

import grafica.ventanas.MenuPrincipal;
import interfaz.IFachada;

public class ControladorMenuPrincipal {

	
	private  IFachada fachada;
	private MenuPrincipal ven;
	
	public ControladorMenuPrincipal (MenuPrincipal ven ){ 
		
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
	
	
	public void RespaldarMenuPrincipal ()
	{
		
		  try {
	            fachada.respaldar();
	            ven.mostrarInfo("Sistema respaldado correctamente.");
		    } catch (Exception e) {
		        ven.mostrarError("Error al respaldar: " + e.getMessage());
	        }
		
      
	}



	
	
	
	
	
	
}

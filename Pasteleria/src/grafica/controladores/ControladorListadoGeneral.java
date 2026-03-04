package grafica.controladores;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Properties;

import javax.swing.JOptionPane;

import grafica.ventanas.VentanaAltaPostre;
import interfaz.IFachada;
import logica.excepciones.AlfanumericoException;
import logica.excepciones.PostreException;
import logica.excepciones.PrecioException;
import logica.valueobjects.VOLight;
import logica.valueobjects.VOPostre;
import grafica.ventanas.VentanaListadoGeneral;
import javax.swing.JOptionPane;
public class ControladorListadoGeneral {
	private IFachada fachada;
    private VentanaListadoGeneral ven;

    public ControladorListadoGeneral (VentanaListadoGeneral ven) {
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
            ven.mostrarMensaje("No se pudo conectar con el servidor.");
        }
        
        try {
			ArrayList<VOPostre> lista = fachada.ListadoGeneralPostre();
			ven.cargarTabla(lista);
        	} 	
        	catch (Exception e) {
    			System.out.println("Error lista");
    			e.printStackTrace();
    		};
    }
    
    
}
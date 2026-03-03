package grafica.controladores;

import java.io.FileInputStream;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.util.Properties;

import interfaz.IFachada;
import logica.excepciones.AlfanumericoException;
import logica.excepciones.PostreException;
import logica.excepciones.PrecioException;
import logica.valueobjects.VOLight;
import logica.valueobjects.VOPostre;
import grafica.ventanas.VentanaAltaPostre;

public class ControladorAltaPostre {

    private IFachada fachada;
    private VentanaAltaPostre ven;

    public ControladorAltaPostre(VentanaAltaPostre ven) {
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
    }

    public void altaPostre(String codigo, String nombre, String precioStr, boolean esLight, String edulcorante, String descripcion) {
    	

    	if (codigo.isEmpty() || nombre.isEmpty() || precioStr.isEmpty()) {
    	    ven.mostrarMensaje("Codigo, Nombre y Precio son obligatorios.");
    	    return;
    	}

    	if (esLight && (edulcorante.isEmpty() || descripcion.isEmpty())) {
    	    ven.mostrarMensaje("Edulcorante y Descripcion son obligatorios para Light.");
    	    return;
    	}
    	
    	float precio;

    	try {
    	    precio = Float.parseFloat(precioStr);
    	} catch (NumberFormatException e) {
    	    ven.mostrarMensaje("El precio debe ser un numero valido");
    	    return;
    	}

    	try {
    	    VOPostre vo;

    	    if (esLight) {
    	        vo = new VOLight(codigo, nombre, precio, edulcorante, descripcion);
    	    } else {
    	        vo = new VOPostre(codigo, nombre, precio);
    	    }

    	    fachada.registrarPostre(vo);

    	    ven.mostrarMensaje("Postre registrado correctamente.");
    	    ven.limpiarCampos();

    	} catch (AlfanumericoException e) {
    	    ven.mostrarMensaje(e.darMensaje());
    	} catch (PrecioException e) {
    	    ven.mostrarMensaje(e.darMensaje());
    	} catch (PostreException e) {
    	    ven.mostrarMensaje(e.darMensaje());
    	} catch (RemoteException e) {
    	    ven.mostrarMensaje("Error de comunicacion con el servidor");
    	}
    }
}
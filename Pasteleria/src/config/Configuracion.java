package config;

import java.util.Properties;
import java.io.*;

public class Configuracion {
	
	private String ipServidor;
    private String puertoServidor;
    private String nomArchivo;

    public Configuracion() {
        try {
            Properties p = new Properties();
            String nomArch = "config/datos.properties";

            // Abro el archivo properties y leo los datos de configuración
            p.load(new FileInputStream(nomArch));

            ipServidor = p.getProperty("ipServidor");
            puertoServidor = p.getProperty("puertoServidor");
            nomArchivo = p.getProperty("nomArchivo");

        }
        catch (IOException e) {
        	System.err.println("Error al leer el archivo de configuración");
        }
    }
    
    public String getIpServidor() 
    {
        return ipServidor;
    }

    public String getPuertoServidor() 
    {
        return puertoServidor;
    }
    
    public String getnomArchivo() 
    {
        return nomArchivo;
    }
}

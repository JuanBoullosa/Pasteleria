package config;

import java.util.Properties;
import java.io.*;

public class Configuracion {
	
	private String ipServidor;
    private String puertoServidor;
    private String rutaRespaldo;

    public Configuracion() {
        try {
            Properties p = new Properties();
            String nomArch = "config/sistema.properties";

            // Abro el archivo properties y leo los datos de configuración
            p.load(new FileInputStream(nomArch));

            ipServidor = p.getProperty("ipServidor");
            puertoServidor = p.getProperty("puertoServidor");
            rutaRespaldo = p.getProperty("rutaRespaldo");

        }
        catch (IOException e) {
            e.printStackTrace();
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
    
    public String getrutaRespaldo() 
    {
        return rutaRespaldo;
    }
}

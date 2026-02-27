package cliente;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.Properties;

import interfaz.IFachada;
import logica.excepciones.*;

public class MainCliente 
{
	public static void main(String[] args)
	{
		try 
		{
			//obtengo ip y puerto de un archivo de configuracion
			Properties p = new Properties();
			String nomArch = "config/datos.properties";
			p.load (new FileInputStream (nomArch));
			String ip = p.getProperty("ipServidor");
			String puerto = p.getProperty("puertoServidor");
			String ruta = "//" + ip + ":" + puerto + "/Pasteleria";
			
			//accedo remotamente a la cuenta bancaria publicada en el servidor
			IFachada fachada = (IFachada) Naming.lookup(ruta);
			
			// PROBAR UNA LLAMADA (ejemplo)
            System.out.println("Conectado al servidor RMI.");

            
            //ACA VAN LOS METODOS 
            System.out.println("Cantidad postres: " + fachada.ListadoGeneralPostre().size());

			
		}
		catch (MalformedURLException e) // si la ruta no esta bien formada
		{
			e.printStackTrace();
		}
		catch (RemoteException e) // si ocurre cualquier problema de red
		{
			e.printStackTrace();
		}
		catch (NotBoundException e) // si la ruta esta bien formada pero el servidor esta bajo
		{
			e.printStackTrace();
		}
		catch (FileNotFoundException e) // si no encuentra el archivo de configuracion
		{
			e.printStackTrace();
		}
		catch (IOException e) // si ocurre cualquier otro error de E/S
		{
			e.printStackTrace();
		} 
	}
}

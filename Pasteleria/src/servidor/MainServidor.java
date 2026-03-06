package servidor;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.Properties;

import config.Configuracion;
import fachada.Fachada;
import logica.excepciones.RecuperarException;
import logica.valueobjects.VOPersistencia;
import persistencia.Persistencia;

public class MainServidor
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
			int port = Integer.parseInt(puerto);
			
			//pongo a correr el rmiregistry
			LocateRegistry.createRegistry(port);
			
			//publico el objeto remoto en dicha ip y puerto
			String ruta = "//" + ip + ":" + puerto + "/Pasteleria";
			Fachada fachada = new Fachada();
			
			//INVOCAR A RECUPERAR****
			
			try { 
				fachada.recuperar();
				System.out.println("Se restauro el sistema correctamente.");
			} catch (Exception e) {
				System.out.println("No existe respaldo previo.");
				e.printStackTrace();
			}
			
			
			
			System.out.println("Antes de publicar");
			Naming.rebind(ruta, fachada);
			System.out.println("Luego de publicar");
			
	
			
			
			
			
		}
		catch (RemoteException e) // si ocurre cualquier problema de red
		{
			e.printStackTrace();
		}
		catch (MalformedURLException e) // si la ruta no esta bien formada
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

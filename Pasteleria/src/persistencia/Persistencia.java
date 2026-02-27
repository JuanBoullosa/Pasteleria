package persistencia;

	import java.io.*;
	import logica.excepciones.RespaldoException;
	import logica.excepciones.RecuperarException;
	import logica.valueobjects.VOPersistencia;

	public class Persistencia {
		public void respaldar (String nomArch, VOPersistencia vo)
				throws RespaldoException
				{try{
					
				File archivo = new File(nomArch);
				 if (!archivo.exists()) {
					 archivo.createNewFile();
				 }
				// Abro el archivo y creo un flujo de comunicación hacia él
				FileOutputStream f = new FileOutputStream(nomArch);
				ObjectOutputStream o = new ObjectOutputStream(f);
				// Escribo el arreglo de vehículos en el archivo a través del flujo
				o.writeObject (vo);
				o.close();
				f.close();
				}
				catch(Exception e)
				{e.printStackTrace();
				throw new RespaldoException("error al respaldar");
				}
				}

				
				public VOPersistencia recuperar (String nomArch)
				throws RecuperarException{
				try {
				File archivo = new File (nomArch);
				if(!archivo.exists()) {
					throw new RecuperarException("No existe archivo con ese nombre");
				}
		        // Abro el archivo y creo un flujo de comunicación hacia él
				FileInputStream f = new FileInputStream(nomArch);
				ObjectInputStream o = new ObjectInputStream(f);
				// Leo  desde el archivo a través del flujo
				VOPersistencia vo = (VOPersistencia) o.readObject();
				o.close();
				f.close();
				return vo;
				}
				catch(Exception e)
				{e.printStackTrace();
				throw new RecuperarException("error al recuperar el archivo");
				}
				}
			
	}



package logica.excepciones;

public class FechaException extends Exception {

	private String mensaje;
	
	public FechaException(String mensaje)
	{
		this.mensaje = mensaje;
		
	}
	
	public String darMensaje()
	{
		return mensaje;
	}
	
}




package logica.excepciones;

public class NoPoseePostreException extends Exception{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensaje;
	
	public NoPoseePostreException(String mensaje)
	{
		this.mensaje = mensaje;
		
	}
	public String darMensaje()
	{
		return mensaje;
	}
}





package logica.excepciones;

public class IndicacionException extends Exception {

	private String mensaje;
	public IndicacionException(String mensaje)
	{
		this.mensaje = mensaje;
		
	}
	
	public String darMensaje()
	{
		return mensaje;
	}
	
}





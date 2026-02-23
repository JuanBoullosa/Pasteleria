package logica.excepciones;

public class ExisteVentaException extends Exception {
	private String mensaje;
	public ExisteVentaException(String mensaje)
	{
		this.mensaje = mensaje;
		
	}
	public String darMensaje()
	{
		return mensaje;
	}
	

}





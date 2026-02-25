package logica.excepciones;

public class EstadoVentaException extends Exception  {
	private String mensaje;
	public EstadoVentaException(String mensaje)
	{
		this.mensaje = mensaje;
		
	}
	public String getMensaje()
	{
		return mensaje;
	}
	

}

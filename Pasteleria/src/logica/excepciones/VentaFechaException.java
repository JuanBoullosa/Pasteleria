package logica.excepciones;

public class VentaFechaException extends Exception {

	private String mensaje;
	public VentaFechaException(String mensaje)
	{
		this.mensaje = mensaje;
		
	}
	public String darMensaje()
	{
		return mensaje;
	}
}

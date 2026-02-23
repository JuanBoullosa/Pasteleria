package logica.excepciones;

public class CantidadException  extends Exception {
	
	
	private String mensaje;
	
	public CantidadException(String mensaje)
	{
		this.mensaje = mensaje;
		
	}
	public String darMensaje()
	{
		return mensaje;
	}
	
	

}







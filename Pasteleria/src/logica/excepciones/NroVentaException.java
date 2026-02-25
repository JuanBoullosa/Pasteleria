package logica.excepciones;

public class NroVentaException extends Exception {

	private String mensaje;
	public NroVentaException(String mensaje) 
	{
		this.mensaje = mensaje; 
    }
    
	public String getMensaje()
	{ 
		return mensaje; 
	}
}

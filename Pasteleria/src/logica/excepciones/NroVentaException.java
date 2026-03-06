package logica.excepciones;

public class NroVentaException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String mensaje;
	public NroVentaException(String mensaje) 
	{
		this.mensaje = mensaje; 
    }
    
	public String darMensaje()
	{ 
		return mensaje; 
	}
}

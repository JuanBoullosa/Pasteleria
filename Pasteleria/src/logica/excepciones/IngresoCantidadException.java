package logica.excepciones;

public class IngresoCantidadException extends Exception {

	
	private String mensaje;
	
	public IngresoCantidadException(String mensaje) {
		this.mensaje = mensaje; }
    
	public String darMensaje()
	{ 
		return mensaje; }
	}

package logica.excepciones;

public class AlfanumericoException extends Exception {
	 
	private String mensaje;
	public AlfanumericoException(String mensaje) 
    {this.mensaje = mensaje; }
    
	public String darMensaje()
	{ 
		return mensaje; }
	}

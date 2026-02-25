package logica.excepciones;

public class RecuperarException extends Exception {
	   
 private String mensaje;
 public RecuperarException(String mensaje) 
 {this.mensaje = mensaje; }

	public String darMensaje()
	{ return mensaje; }
	}


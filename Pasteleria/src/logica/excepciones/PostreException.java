package logica.excepciones;

public class PostreException extends Exception {

    
      private String mensaje;
      public PostreException(String mensaje) 
      {this.mensaje = mensaje; }
    
	public String darMensaje()
	{ return mensaje; }
	}

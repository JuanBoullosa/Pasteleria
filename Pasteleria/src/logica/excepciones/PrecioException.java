package logica.excepciones;

public class PrecioException extends Exception {
	   
	      private String mensaje;
	      public PrecioException(String mensaje) 
	      {this.mensaje = mensaje; }
	    
		public String darMensaje()
		{ return mensaje; }
		}


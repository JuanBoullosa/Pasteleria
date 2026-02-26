package logica.excepciones;

public class FinalizadaException extends Exception {
	
			private String mensaje;
	
			public FinalizadaException(String mensaje)
			{
				this.mensaje = mensaje;
				
			}
			
			public String darMensaje()
			{
				return mensaje;
			}

}



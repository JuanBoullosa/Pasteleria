package logica.excepciones;

public class LimiteUnidadesException extends Exception {


		private String mensaje;
		public LimiteUnidadesException(String mensaje)
		{
			this.mensaje = mensaje;
			
		}
		public String darMensaje()
		{
			return mensaje;
		}
	
	
}




package logica.excepciones;

public class RespaldoException extends Exception {
	   
    private String mensaje;
    public RespaldoException(String mensaje) 
    {this.mensaje = mensaje; }
  
	public String darMensaje()
	{ return mensaje; }
	}



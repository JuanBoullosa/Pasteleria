package logica.negocio;
import java.io.Serializable;

public class Postre implements Serializable {
	private static final long serialVersionUID= 1L;
	
	private String codigo;
	private String nombre;
	private float precio;
	
	
	
	public Postre(String codigo, String nombre,float precio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	
	public String getTipoPostre() {
		return"Comun";
	}
	
	
	

	
}

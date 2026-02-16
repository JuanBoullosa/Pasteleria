package logica.valueobjects;

public class VOPostreDetallado {
	
	private float precio;
	private String nombre;
	private String codigo;
	private String tipo;
	
	
	public VOPostreDetallado(float precio, String nombre, String codigo, String tipo) {
		super();
		this.precio = precio;
		this.nombre = nombre;
		this.codigo = codigo;
		this.tipo = tipo;
	}
	
	public float getPrecio() {
		return precio;
	}
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	

}

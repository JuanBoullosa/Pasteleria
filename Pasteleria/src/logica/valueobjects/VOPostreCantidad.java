package logica.valueobjects;

public class VOPostreCantidad extends VOPostreDetallado{

	private float precio;
	private String nombre;
	private String codigo;
	private String tipo;
		
	
	public VOPostreCantidad(float precio, String nombre, String codigo, String tipo, float precio2, String nombre2,
			String codigo2, String tipo2) {
		super(precio, nombre, codigo, tipo);
		precio = precio2;
		nombre = nombre2;
		codigo = codigo2;
		tipo = tipo2;
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

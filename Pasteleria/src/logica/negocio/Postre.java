package logica.negocio;

public class Postre {

	private float precio;
	private String nombre;
	private String codigo;
	
	public Postre(String codigo, String nombre,float precio ) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
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

	// SOLO PARA LAS PRUEBAS HAY QUE BORRAR 
	public void toPostre() {
		System.out.println(
				"\nPrecio: "+ getPrecio() + 
				"\nNombre: "+ getNombre() + 
				"\nCodigo: "+ getCodigo() 
				);
	}
	
	
	
}

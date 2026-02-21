package logica.valueobjects;
import logica.negocio.Postre;

public class VOPostre {

	private float precio;
	private String nombre;
	private	String codigo;
	
	
	
	public VOPostre(float precio, String nombre, String codigo) {
		super();
		this.precio = precio;
		this.nombre = nombre;
		this.codigo = codigo;
	}
	

	public VOPostre (Postre p)	{
		this.codigo = p.getCodigo();
		this.nombre = p.getNombre();
		this.precio = p.getPrecio();
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
		public void toVOPostre() {
			System.out.println(
					"\nPrecio: "+ getPrecio() + 
					"\nNombre: "+ getNombre() + 
					"\nCodigo: "+ getCodigo() 
					);
		}
	
}

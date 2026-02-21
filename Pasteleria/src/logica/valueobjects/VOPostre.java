package logica.valueobjects;
import logica.negocio.Postre;

public class VOPostre {

	private	String codigo;
	private String nombre;
	private float precio;
	
	
	
	
	
	public VOPostre(String codigo, String nombre, float precio) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.precio = precio;
		
		
	}
	

	public VOPostre (Postre p)	{
		this.codigo = p.getCodigo();
		this.nombre = p.getNombre();
		this.precio = p.getPrecio();
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
	
	
	
	
	
	// SOLO PARA LAS PRUEBAS HAY QUE BORRAR 
		public void toVOPostre() {
			System.out.println(
					"\nPrecio: "+ getPrecio() + 
					"\nNombre: "+ getNombre() + 
					"\nCodigo: "+ getCodigo() 
					);
		}
	
}

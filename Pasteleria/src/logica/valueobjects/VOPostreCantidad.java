package logica.valueobjects;
import logica.negocio.Postre;

public class VOPostreCantidad extends VOPostreDetallado{

	private int cantidad;
	
	

	public VOPostreCantidad(float precio, String nombre, String codigo, String tipo, int cantidad) {
		super(codigo, nombre, precio, tipo);
		this.cantidad = cantidad;
	}
	
	public VOPostreCantidad(Postre p, int cant) {
		super(p, cant);
		this.cantidad = cant;
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public void toVOVenta() {
		System.out.println(
				"\nCodigo: "+ getCodigo() + 
				"\nNombre: "+ getNombre() + 
				"\nPrecio: "+ getPrecio() +
			//	"\nTipo : "+ getMontoTotal() +
				"\nCantidad: "+ getCantidad()
				);
	}
}

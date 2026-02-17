package logica.valueobjects;

public class VOPostreCantidad extends VOPostreDetallado{

	private int cantidad;
	
	

	public VOPostreCantidad(float precio, String nombre, String codigo, String tipo, int cantidad) {
		super(precio, nombre, codigo, tipo);
		this.cantidad = cantidad;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	
}

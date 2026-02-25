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
	
	public String toString() {
	    String resu;

	    resu = "\n Codigo" + " - " + getCodigo();
	    resu = resu + "\n Nombre" + " - " + getNombre();
	    resu = resu + "\n Precio" + " - " + "$" + getPrecio();
	    resu = resu + "\n Tipo" + " - " + getTipo();
	    resu = resu + "\n Cantidad" + " - " + getCantidad();

	    return resu;
	}
}

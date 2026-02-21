package logica.colecciones;
import java.util.LinkedList;
import logica.negocio.Venta;

public class Ventas {

	private LinkedList <Venta> listaVentas;

	//Constructor
	public Ventas()
	{
		listaVentas = new LinkedList <Venta> ();
		
	}

	//agregar por el final
	public void insBack(Venta V){
	listaVentas.addLast(V);
	}

	
	
	
	
}

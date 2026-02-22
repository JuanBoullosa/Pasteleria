package logica.colecciones;
import java.util.ArrayList;
import java.util.LinkedList;
import logica.negocio.Light;
import logica.negocio.Postre;
import logica.negocio.Venta;
import logica.valueobjects.VOLight;
import logica.valueobjects.VOPostre;
import logica.valueobjects.VOPostreDetallado;
import logica.valueobjects.VOVenta;


public class Ventas {

	private LinkedList <Venta> listaVentas;

	//Constructor
	public Ventas()
	{
		listaVentas = new LinkedList <Venta> ();
		
	}

	//agregar por el final
	public void insBack(Venta V)
	{
		listaVentas.addLast(V);
	}
	
	//agregar por el final
	public void insBackVOVentaDetalle(Venta V)
	{
		listaVentas.addLast(V);
	}
	

	//Muestra lo que cargas a mano
	public ArrayList<VOVenta> obtenerVentas() {
		ArrayList<VOVenta> listaVentasObtenido = new ArrayList<VOVenta>();
		
		for (Venta v: listaVentas ) {
			VOVenta vov = new VOVenta(v);	
			listaVentasObtenido.add(vov);		
		}
		return listaVentasObtenido;
		}
	/*
	//Requerimiento 4
	public ArrayList<VOVenta> obtenerVentaIngreso (){
		ArrayList<VOVenta> ListaDeVentaIngreso = new ArrayList<VOVenta> ();
		for (Venta v: listaVentas) {
			
		}
		
	
	}
	*/
	
	
	
}

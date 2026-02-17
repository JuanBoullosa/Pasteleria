package logica.colecciones;
import java.util.ArrayList;
import logica.negocio.Es_Vendido;


public class Es_Vendidos {
	private ArrayList <Es_Vendido> arrayEsVendido;
	
	public  Es_Vendidos()
	{
		arrayEsVendido = new ArrayList<Es_Vendido> ();
	}
	//agregar un elemento a la lista
	public void insertar(Es_Vendido esV)
	{
		arrayEsVendido.add(esV);
	}
	
	//Largo de la secuencia
	public int largo()
	{
		return arrayEsVendido.size();
	}
		
		
}

	
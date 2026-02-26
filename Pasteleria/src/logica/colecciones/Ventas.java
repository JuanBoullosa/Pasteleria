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
import logica.valueobjects.VOVentaIngreso;
import java.io.Serializable;

public class Ventas implements Serializable {
	private static final long serialVersionUID= 1L;
	

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
	
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	//retorno valores de la ultima venta
	public Venta getUltimaVenta() {
		if (listaVentas.isEmpty()) return null;
		return listaVentas.getLast() ;
	}
	
	//Asigno siguiente numero a la venta
	public int getProximoNumero() {
		Venta ultima = getUltimaVenta();
		if (ultima == null) {
			return 1;
		}else {
			return ultima.getNumero() + 1;
		}
		
	}
	//Fecha valida
	public Boolean FechaInvalida(VOVentaIngreso vovi)
	{
		Venta ult = getUltimaVenta();
		if (ult != null && vovi.getFecha().isBefore(ult.getFecha())) {
			return true; // fecha inválida
	    }else {
	    	return false;
	    }
	}
	
	//Requerimiento 4
	public void altaVenta(VOVentaIngreso vovi) {
		//Venta ult = getUltimaVenta();
		
		String estado;
		estado = "PROCESO";
		float montoTotal = 0;
		int num = getProximoNumero();
		Es_Vendidos sec = new Es_Vendidos();
		
		Venta v= new Venta(
				num,
				vovi.getFecha(),
				vovi.getDireccionEnvio(),
				estado,
				montoTotal,
				sec
				);
				
		listaVentas.addLast(v);
	}
	// Requerimiento 5
	//public void Insertar 
	

	//Buscar si existe la venta segun el numero dado - Sirve para requerimiento 5
	public Venta obtenerVenta(int numeroVenta)
	{
		for (Venta ven: listaVentas)
		{
			if(numeroVenta == ven.getNumero())
			{
				return ven;
			}
		}
		return null;
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

	
	//Req8
		public LinkedList <VOVenta> ListaVentaXEstado (String Estado)
		{
			LinkedList <VOVenta> ListRaVentaXEstadoRes = new LinkedList<>();
			
			for (Venta v : listaVentas) {
		        if (Estado.equals("P")) {
		            if (v.getEstado().equals("PROCESO")) {
		            	ListRaVentaXEstadoRes.addLast(new VOVenta(v));
		            }
		        } else if (Estado.equals("F")) {
		            if (v.getEstado().equals("FINALIZADA")) {
		            	ListRaVentaXEstadoRes.addLast(new VOVenta(v));
		            }
		        } else if (Estado.equals("T")) {
		        	ListRaVentaXEstadoRes.addLast(new VOVenta(v));
		        }
		    }	
			return ListRaVentaXEstadoRes ;
		}
	
	//REQUERIMIENTO 7 parte a
		public void eliminarVenta(int numVenta)
		{
			for(int i =0 ; i < listaVentas.size(); i++ )
			{
				if(listaVentas.get(i).getNumero() == numVenta)
					{
						listaVentas.remove(i);
						return;
					}
			}
		}
	//REQUERIMIENTO 7 parte b
	    public void confirmarVenta(int numVenta) {
	        for (Venta v : listaVentas) {
	            if (v.getNumero() == numVenta) {
	                v.setEstado("FINALIZADA");
	                return;
	            }
	        }
	    }
		
		
		
		
		
		
	


		
	
}

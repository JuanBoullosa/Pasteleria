package logica.colecciones;
import java.util.ArrayList;
import logica.negocio.Es_Vendido;
import logica.negocio.Postre;
import logica.valueobjects.VOPostreDetallado;


public class Es_Vendidos {
	private ArrayList <Es_Vendido> arrayEsVendido;
	
	public  Es_Vendidos()
	{
		arrayEsVendido = new ArrayList<Es_Vendido> ();
	}
	//agregar un elemento a la lista
	public void insertar(Es_Vendido esV)
	{
		
		int total = 0;
	    for (Es_Vendido e : arrayEsVendido) {
	        total = total + e.getCantidad();
	    }

	    if (total + esV.getCantidad() > 40) {
	        System.out.println(" Tirar EXCEPCION : Supera el límite permitido de postres (40)");
	    }
	    
	    for (Es_Vendido e : arrayEsVendido) {
	        if (e.getPostre().getCodigo().equals(esV.getPostre().getCodigo())) {
	            e.setCantidad(e.getCantidad() + esV.getCantidad());
	        }
	    }
	    arrayEsVendido.add(esV);
	    
	  }
		
	//Largo de la secuencia
	public int largo()
	{
		return arrayEsVendido.size();
	}
			
	public ArrayList <VOPostreDetallado> ListadoEsVendidos()  {
		
		ArrayList <VOPostreDetallado> Listresu;
		Listresu = new ArrayList<VOPostreDetallado> ();	
		
		for(Es_Vendido esv: arrayEsVendido )
		{
			int cant=0;
			for(Es_Vendido esv1: arrayEsVendido) {
				Postre i = esv1.getPostre();	
				esv.getPostre().getCodigo().equals(i.getCodigo());
				cant = cant + esv1.getCantidad();
			}
			VOPostreDetallado res = new VOPostreDetallado(esv.getPostre(),cant);
			res.toString();
			Listresu.add(res);
		}
		return Listresu;
	}
	
	public int getTotalUnidades() {
		int total = 0;
	    for (Es_Vendido e : arrayEsVendido) {
	        total = total + e.getCantidad();
	    }
	    return total;
	}
	
}	
	


	
package logica.colecciones;
import java.util.ArrayList;
import logica.negocio.Es_Vendido;
import logica.negocio.Postre;
import logica.valueobjects.VOPostre;
import logica.valueobjects.VOPostreDetallado;


public class Es_Vendidos {
	private ArrayList <Es_Vendido> arrayEsVendido;
	
	public  Es_Vendidos()
	{
		arrayEsVendido = new ArrayList<Es_Vendido> ();
	}
	
	
	
	
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	//Requerimiento 5

	//Funcion aux 1 - Requerimiento 5 - sumar o insertar postre valido en Es_Vendidos
	public boolean insertarPostreEs_Vendidos (Postre p, int unidades)
	{
	
		int cantUnidades = 0;
		for (Es_Vendido ev : arrayEsVendido) 
		{
			cantUnidades = cantUnidades + ev.getCantidad();
		}
		if (cantUnidades + unidades > 40) {
			return false;
		}
		
		for (Es_Vendido ev: arrayEsVendido){
			if (ev.getPostre().getCodigo().equals(p.getCodigo())) {
				ev.sumarCantidad(unidades);
				return true;
			}
		}
		arrayEsVendido.add(new Es_Vendido(p,unidades ));
		return true;
			
	}
	
	
	
	
	

	// //Funcion aux 2  - Requerimiento 5 - Actualizar monto total plata
	public float actualizarMontoTotal() 
	{
		float monto = 0;
		for ( Es_Vendido ev: arrayEsVendido) {
			monto = monto + ev.getPostre().getPrecio()*ev.getCantidad();
		}
		return monto;
	}
	
	
	//Requerimiento 6
	//Funcion aux 1 - Requerimiento 6 - restar o eliminar cantidad postre valido en Es_Vendidos
	public void eliminarPostreEs_Vendidos(Postre p, int unidades) 
	{
			
		for (int i = 0; i < arrayEsVendido.size(); i++) {

	        Es_Vendido ev = arrayEsVendido.get(i);

	        if (ev.getPostre().getCodigo().equals(p.getCodigo())) {

	            int cantidad = ev.getCantidad();

	            if (cantidad - unidades > 0) {
	                ev.restarCantidad(unidades);
	            } else {
	                arrayEsVendido.remove(i); 

	            return;
	            }
	       }
		}
	}
	
	
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%

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
	
	public ArrayList<Es_Vendido> getArrayEsVendido() {
	    return arrayEsVendido;
	}
	
	
}	
	


	
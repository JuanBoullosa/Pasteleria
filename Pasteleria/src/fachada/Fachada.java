package fachada;

import logica.colecciones.Postres;
import logica.colecciones.Ventas;
import logica.excepciones.*;
import logica.negocio.Light;
import logica.negocio.Postre;
import logica.valueobjects.VOLight;
import logica.valueobjects.VOPostre;


public class Fachada {
	
	private Postres dicPostres;
	private Ventas  secVentas;
	
	public Fachada()
	{
		dicPostres = new Postres();
		secVentas = new Ventas();
	}
	
	public void registrarPostre(VOPostre voP)throws PostreException, PrecioException
	{
		
		if(voP.getPrecio() <= 0)
		{
			String msg = "El precio del postre no corresponde";
			throw new PrecioException(msg);
		}
		if (dicPostres.member(voP.getCodigo())){
			String msg = "Ya existe un postre con el mismo codigo";
			throw new PostreException(msg);
		}
		Postre p;

	    if (voP instanceof VOLight) {

	        VOLight vol = (VOLight) voP;

	        p = new Light(
	            vol.getCodigo(),
	            vol.getNombre(),
	            vol.getPrecio(),
	            vol.getEndulzante(),
	            vol.getDescripcion()
	        );

	    } else {
		 p = new Postre(
				voP.getCodigo(),
				voP.getNombre(),
				voP.getPrecio());	
}
		dicPostres.insert(voP.getCodigo(), p);
		}
	
	
	public VOPostre ListarPostreDetallado(String codigo) throws PostreException 
	{
		if(!dicPostres.member(codigo)) {
			String msg = "No existe un postre con ese codigo";
			throw new PostreException(msg);
			
		}
		Postre p = dicPostres.find(codigo);
		if (p instanceof Light) {
			Light l = (Light) p;

			return new VOLight(
					l.getCodigo(),
					l.getNombre(),
					l.getPrecio(),
	                l.getEndulzante(),
	                l.getDescripcion()
					);
		}
			else {
				return  new VOPostre(
						
						p.getCodigo(),
						p.getNombre(),
						p.getPrecio()
						);
						
			}
		
	
	}
	
}

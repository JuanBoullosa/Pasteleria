package fachada;

import logica.colecciones.Postres;
import logica.colecciones.Ventas;
import logica.excepciones.*;
import logica.negocio.Postre;
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
		
		Postre p = new Postre(
				voP.getCodigo(),
				voP.getNombre(),
				voP.getPrecio());
	
		dicPostres.insert(voP.getCodigo(), p);
	
}
}

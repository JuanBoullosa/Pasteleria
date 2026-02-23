package fachada;

import java.util.ArrayList;

import logica.colecciones.Postres;
import logica.colecciones.Ventas;
import logica.excepciones.*;
import logica.negocio.Light;
import logica.negocio.Postre;
import logica.valueobjects.VOLight;
import logica.valueobjects.VOPostre;
import logica.valueobjects.VOPostreDetallado;
import logica.valueobjects.VOVenta;
import logica.valueobjects.VOVentaIngreso;

public class Fachada {
	
	private Postres dicPostres;
	private Ventas  secVentas;
	
	public Fachada()
	{
		dicPostres = new Postres();
		secVentas = new Ventas();
	}
	
	
	private Postre convertirAPostre(VOPostre vo) {

	    if (vo instanceof VOLight) {
	        VOLight vl = (VOLight) vo;

	        return new Light(
	                vl.getCodigo(),
	                vl.getNombre(),
	                vl.getPrecio(),
	                vl.getEndulzante(),
	                vl.getDescripcion()
	        );
	    }

	    return new Postre(
	            vo.getCodigo(),
	            vo.getNombre(),
	            vo.getPrecio()
	    );
	}
	
	
	//Requerimiento 1
	public void registrarPostre(VOPostre voP)throws AlfanumericoException, PostreException, PrecioException
	{
		
	    if (!voP.getCodigo().matches("^[a-zA-Z0-9]+$")) {
	        String msg= "El codigo debe ser alfanumerico";
	    	throw new AlfanumericoException(msg);
	    }
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
	
	//Requerimiento 3
	public VOPostre ListarPostreDetallado(String codigo) throws AlfanumericoException,PostreException 
	{
	    if (!codigo.matches("^[a-zA-Z0-9]+$")) {
	        String msg= "El codigo debe ser alfanumerico";
	    	throw new AlfanumericoException(msg);
	    }
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
	
	// Reqierimiento 2
	public ArrayList<VOPostreDetallado> ListadoGeneralPostre() 
	{
		return dicPostres.obtenerPostresDetallado();
	}
	
	
	//Requerimiento 4
	public void nuevaVenta(VOVentaIngreso vovi) throws FechaException 
	{
		
		if (secVentas.FechaInvalida(vovi))
		{
			String msg= "La fecha no es valida";
		    throw new FechaException(msg);
        }
		secVentas.altaVenta(vovi);
	}
	
	
	//Requerimiento 5
	public void agregarPostreEnVenta (VOPostre vop, int cantidad, int numVenta) throws CantidadException,AlfanumericoException, PostreException, ExisteVentaException, LimiteUnidadesException
	{
		
		if(cantidad <= 0)
		{
			String msg= "Cantidad no valida, debe ser mayor a 0";
		    throw new CantidadException(msg);
		}
		if (!vop.getCodigo().matches("^[a-zA-Z0-9]+$")) {
		    String msg= "El codigo debe ser alfanumerico";
		    throw new AlfanumericoException(msg);
		}
		if(!dicPostres.member(vop.getCodigo())) {
			String msg = "No existe un postre con ese codigo";
			throw new PostreException(msg);
			
		}
		if (secVentas.existeVenta(numVenta) == null)
		{
			String msg= "No existe venta con ese numero";
		    throw new ExisteVentaException(msg);
		}
			
		
		int antesTotal = secVentas.existeVenta(numVenta).getSecEsVendido().getTotalUnidades();
		secVentas.existeVenta(numVenta).altaPostreEnVenta(convertirAPostre(vop), cantidad);
		int despuesTotal = secVentas.existeVenta(numVenta).getSecEsVendido().getTotalUnidades();
	
		if (despuesTotal==antesTotal)
		{
			String msg = "Supera el maximo de unidades que es 40";
			throw new LimiteUnidadesException(msg);
		}
	}
	
	
	
	
	//funcion que sirve para ver como cargo las listas ingresadas (no es un requerimiento)
	public ArrayList<VOVenta> ListaDeVentasIngresadas()
	{
		return secVentas.obtenerVentas();
	}
	
	
	
	
	
	
}

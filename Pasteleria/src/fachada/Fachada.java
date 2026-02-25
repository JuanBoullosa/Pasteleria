package fachada;

import java.util.ArrayList;

import logica.colecciones.Postres;
import logica.colecciones.Ventas;
import logica.excepciones.*;
import logica.negocio.Light;
import logica.negocio.Postre;
import logica.valueobjects.VOLight;
import logica.valueobjects.VOPostre;
import logica.valueobjects.VOPostreCantidad;
import logica.valueobjects.VOPostreDetallado;
import logica.valueobjects.VOVenta;
import logica.valueobjects.VOVentaIngreso;
import logica.valueobjects.VOLightDetallado;
import logica.excepciones.NroVentaException;
import logica.negocio.Venta;
import persistencia.*;
import logica.valueobjects.VOEstadoSistema;

public class Fachada {
	
	private Postres dicPostres;
	private Ventas  secVentas;
	
	public Fachada()
	{
		dicPostres = new Postres();
		secVentas = new Ventas();
	}
	
	
	
	// CREO QUE NO LO ESTAMOS USANDO 
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

		if (voP.getTipoPostre().equals("Light")) {

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
		        voP.getPrecio()
		    );
		}
		dicPostres.insert(p.getCodigo(), p);
	  }

	// Reqierimiento 2
	public ArrayList<VOPostre> ListadoGeneralPostre() 
	{
		return dicPostres.obtenerPostresDetallado();
	}
	
	//Requerimiento 3
	public VOPostreDetallado ListarPostreDetallado(String codigo) throws AlfanumericoException,PostreException 
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

			return new VOLightDetallado(
					l.getCodigo(),
					l.getNombre(),
					l.getPrecio(),
					l.getTipoPostre(),
	                l.getEndulzante(),
	                l.getDescripcion()
					);
		}
			else {
				return  new VOPostreDetallado(						
						p.getCodigo(),
						p.getNombre(),
						p.getPrecio(),
						p.getTipoPostre()
						);
			}
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
	public void agregarPostreEnVenta (String codigo, int cantidad, int numVenta) throws CantidadException,AlfanumericoException, PostreException, ExisteVentaException, LimiteUnidadesException,IngresoCantidadException
	{
		
		if(cantidad <= 0)
		{
			String msg= "Cantidad no valida, debe ser mayor a 0";
		    throw new CantidadException(msg);
		}
		if (!codigo.matches("^[a-zA-Z0-9]+$")) {
		    String msg= "El codigo debe ser alfanumerico";
		    throw new AlfanumericoException(msg);
		}
		if(!dicPostres.member(codigo)) {
			String msg = "No existe un postre con ese codigo";
			throw new PostreException(msg);
			
		}
		if (secVentas.obtenerVenta(numVenta) == null)
		{
			String msg= "No existe venta con ese numero";
		    throw new ExisteVentaException(msg);
		}
		
		if (cantidad > 40)
		{
			String msg= "La cantidad ingresado es mayor que 40";
		    throw new IngresoCantidadException(msg);
		}
		
		int antesTotal = secVentas.obtenerVenta(numVenta).obtenerDetalleVentas().getTotalUnidades();
		
		if (antesTotal+cantidad>40)
		{
			String msg = "Supera el maximo de unidades que es 40";
			throw new LimiteUnidadesException(msg);
		}
		
		Postre p = dicPostres.find(codigo);
		
			secVentas.obtenerVenta(numVenta).altaPostreEnVenta(p, cantidad);
	}
	
	
	
	//Requerimiento 6
	public void eliminarOBorrarPostreEs_Vendidos (String codigo, int cantidad, int numVenta) throws CantidadException,AlfanumericoException, PostreException, ExisteVentaException
	{
		
		if(cantidad <= 0)
		{
			String msg= "Cantidad no valida, debe ser mayor a 0";
		    throw new CantidadException(msg);
		}
		if (!codigo.matches("^[a-zA-Z0-9]+$")) {
		    String msg= "El codigo debe ser alfanumerico";
		    throw new AlfanumericoException(msg);
		}
		if(!dicPostres.member(codigo)) {
			String msg = "No existe un postre con ese codigo";
			throw new PostreException(msg);
			
		}
		if (secVentas.obtenerVenta(numVenta) == null)
		{
			String msg= "No existe venta con ese numero";
		    throw new ExisteVentaException(msg);
		}
		
		
		Postre p = dicPostres.find(codigo);
		
			secVentas.obtenerVenta(numVenta).bajaPostreEs_Vendidos(p, cantidad);
	}
	
	
	//funcion que sirve para ver como cargo las listas ingresadas (no es un requerimiento)
	public ArrayList<VOVenta> ListaDeVentasIngresadas()
	{
		return secVentas.obtenerVentas();
	}
	
	
	// Requerimiento 8 
	
	public void ListadoPostresVenta(int numero) throws NroVentaException {

	    Venta v = secVentas.obtenerVenta(numero);

	    if (v == null) {
	        String msg = "No existe venta con ese numero";
	        throw new NroVentaException(msg);
	    }

	    ArrayList<VOPostreCantidad> lista = v.ObtenerListadoPostresVenta();

	    for (VOPostreCantidad voc : lista) {
	        System.out.println(voc);
	    }
	}
	
	//requerimiento 11
	
		public void respaldar() throws RespaldoException {

		    Persistencia p = new Persistencia();

		    VOEstadoSistema vo = this.exportarDatos();

		    p.respaldar("pasteleria.dat", vo);
		}

		
		
		//requerimiento 12
		
		public void recuperar() throws RecuperarException {

		    Persistencia p = new Persistencia();

		    VOEstadoSistema estado = p.recuperar("pasteleria.dat");

		    this.importarDatos(estado);
		}

		    
		 public VOEstadoSistema exportarDatos() {
		     return new VOEstadoSistema(dicPostres, secVentas);
		    }
		
		 public void importarDatos(VOEstadoSistema vo) {
		        this.dicPostres = vo.getPostres();
		        this.secVentas = vo.getVentas();
		    }
		 
		//funcion que sirve para ver como cargo las listas ingresadas (no es un requerimiento)
		public ArrayList<VOVenta> ListaDeVentasIngresadas()
		{
			return secVentas.obtenerVentas();
		}
		


}

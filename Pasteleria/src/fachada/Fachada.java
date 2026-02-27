package fachada;

import java.util.ArrayList;
import java.util.LinkedList;

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
import logica.valueobjects.VOPersistencia;
import java.time.LocalDateTime;
import logica.valueobjects.VORecaudado;
import logica.monitor.*;
import config.Configuracion;

public class Fachada {
	
	private Postres dicPostres;
	private Ventas  secVentas;
	private Monitor monitor;
	
	public Fachada()
	{
		dicPostres = new Postres();
		secVentas = new Ventas();
		monitor = new Monitor();
	}
	
	

	//Requerimiento 1
	public void registrarPostre(VOPostre voP)throws AlfanumericoException, PostreException, PrecioException
	{
		monitor.comienzoEscritura();
	    if (!voP.getCodigo().matches("^[a-zA-Z0-9]+$")) {
	        String msg= "El codigo debe ser alfanumerico";
	        monitor.terminoEscritura();
	        throw new AlfanumericoException(msg);
	    }
		if(voP.getPrecio() <= 0)
		{
			String msg = "El precio del postre no corresponde";
			monitor.terminoEscritura();
			throw new PrecioException(msg);
		}
		if (dicPostres.member(voP.getCodigo())){
			String msg = "Ya existe un postre con el mismo codigo";
			monitor.terminoEscritura();
			throw new PostreException(msg);
		}
		Postre p;

		if ("Light".equals(voP.getTipoPostre())) {

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
		dicPostres.insert(voP.getCodigo(), p);
		monitor.terminoEscritura();
	  }

	// Reqierimiento 2
	public ArrayList<VOPostre> ListadoGeneralPostre() 
	{
		monitor.comienzoLectura();
		ArrayList<VOPostre> resu = dicPostres.obtenerPostresDetallado();
		monitor.terminoLectura();
		return resu;
	}
	
	//Requerimiento 3
	public VOPostreDetallado ListarPostreDetallado(String codigo) throws AlfanumericoException,PostreException 
	{
		monitor.comienzoLectura();
		if (!codigo.matches("^[a-zA-Z0-9]+$")) {
			monitor.terminoLectura();
	        String msg= "El codigo debe ser alfanumerico";
	    	throw new AlfanumericoException(msg);
	    }
		if(!dicPostres.member(codigo)) {
			monitor.terminoLectura();
			String msg = "No existe un postre con ese codigo";
			throw new PostreException(msg);
			
		}
		Postre p = dicPostres.find(codigo);
		if (p instanceof Light) {
			Light l = (Light) p;

			VOPostreDetallado vo =  new VOLightDetallado(
					l.getCodigo(),
					l.getNombre(),
					l.getPrecio(),
					l.getTipoPostre(),
	                l.getEndulzante(),
	                l.getDescripcion()
					);
			monitor.terminoLectura();
			return vo;
		}
			else {
				VOPostreDetallado vo = new VOPostreDetallado(						
						p.getCodigo(),
						p.getNombre(),
						p.getPrecio(),
						p.getTipoPostre()
						);
				monitor.terminoLectura();
				return vo;
			}
	}
	
	
	//Requerimiento 4
	public void nuevaVenta(VOVentaIngreso vovi) throws FechaException 
	{
		monitor.comienzoEscritura();
		if (secVentas.FechaInvalida(vovi))
		{
			monitor.terminoEscritura();
			String msg= "La fecha no es valida";
		    throw new FechaException(msg);
        }
		secVentas.altaVenta(vovi);
		monitor.terminoEscritura();
	}
	
	
	//Requerimiento 5
	public void agregarPostreEnVenta (String codigo, int cantidad, int numVenta) throws CantidadException,AlfanumericoException, PostreException, ExisteVentaException, LimiteUnidadesException,IngresoCantidadException
	{
		monitor.comienzoEscritura();
		if(cantidad <= 0)
		{
			monitor.terminoEscritura();
			String msg= "Cantidad no valida, debe ser mayor a 0";
		    throw new CantidadException(msg);
		}
		if (!codigo.matches("^[a-zA-Z0-9]+$")) {
			monitor.terminoEscritura();
		    String msg= "El codigo debe ser alfanumerico";
		    throw new AlfanumericoException(msg);
		}
		if(!dicPostres.member(codigo)) {
			monitor.terminoEscritura();
			String msg = "No existe un postre con ese codigo";
			throw new PostreException(msg);
			
		}
		if (secVentas.obtenerVenta(numVenta) == null)
		{
			monitor.terminoEscritura();
			String msg= "No existe venta con ese numero";
		    throw new ExisteVentaException(msg);
		}
		
		if (cantidad > 40)
		{
			monitor.terminoEscritura();
			String msg= "La cantidad ingresado es mayor que 40";
		    throw new IngresoCantidadException(msg);
		}
		
		//
		//int antesTotal = secVentas.obtenerVenta(numVenta).obtenerDetalleVentas().getTotalUnidades();
		Venta v = secVentas.obtenerVenta(numVenta);
		int antesTotal = v.obtenerDetalleVentas().getTotalUnidades();
		
		if (antesTotal+cantidad>40)
		{
			monitor.terminoEscritura();
			String msg = "Supera el maximo de unidades que es 40";
			throw new LimiteUnidadesException(msg);
		}
		
		Postre p = dicPostres.find(codigo);
		
		secVentas.obtenerVenta(numVenta).altaPostreEnVenta(p, cantidad);
		monitor.terminoEscritura();
	}
	
	
	
	//Requerimiento 6
	public void eliminarOBorrarPostreEs_Vendidos (String codigo, int cantidad, int numVenta) throws CantidadException,AlfanumericoException, PostreException, ExisteVentaException
	{
		monitor.comienzoEscritura();
		if(cantidad <= 0)
		{
			monitor.terminoEscritura();
			String msg= "Cantidad no valida, debe ser mayor a 0";
		    throw new CantidadException(msg);
		}
		if (!codigo.matches("^[a-zA-Z0-9]+$")) {
			monitor.terminoEscritura();
		    String msg= "El codigo debe ser alfanumerico";
		    throw new AlfanumericoException(msg);
		}
		if(!dicPostres.member(codigo)) {
			monitor.terminoEscritura();
			String msg = "No existe un postre con ese codigo";
			throw new PostreException(msg);
			
		}
		if (secVentas.obtenerVenta(numVenta) == null)
		{
			monitor.terminoEscritura();
			String msg= "No existe venta con ese numero";
		    throw new ExisteVentaException(msg);
		}
		
		
		Postre p = dicPostres.find(codigo);
		secVentas.obtenerVenta(numVenta).bajaPostreEs_Vendidos(p, cantidad);
		monitor.terminoEscritura();
	}
	
	

	
	// Requerimiento 9 
	
	public void ListadoPostresVenta(int numero) throws NroVentaException {

		monitor.comienzoLectura();
		Venta v = secVentas.obtenerVenta(numero);

	    if (v == null) {
	    	monitor.terminoLectura();
	        String msg = "No existe venta con ese numero";
	        throw new NroVentaException(msg);
	    }

	    ArrayList<VOPostreCantidad> lista = v.ObtenerListadoPostresVenta();
	    monitor.terminoLectura();
	    for (VOPostreCantidad voc : lista) {
	        System.out.println(voc);
	    }
	}
	
	//requerimiento 11
	
		public void respaldar() throws RespaldoException {
			monitor.comienzoEscritura();	
		    Persistencia p = new Persistencia();

		    VOPersistencia vo = this.exportarDatos();
		    Configuracion config = new Configuracion();
		    String nombre = config.getnomArchivo();

		    p.respaldar(nombre, vo);
		    monitor.terminoEscritura();
		}

		
		
		//requerimiento 12
		
		public void recuperar() throws RecuperarException {
			monitor.comienzoEscritura();
			Configuracion config = new Configuracion();
			String nombre = config.getnomArchivo();
		    Persistencia p = new Persistencia();

		    VOPersistencia persistencia = p.recuperar(nombre);

		    this.importarDatos(persistencia);
		    monitor.terminoEscritura();
		}

		    
		 public VOPersistencia exportarDatos() {
		     VOPersistencia vo = new VOPersistencia(dicPostres, secVentas);
		     return vo;
		    }
		
		 public void importarDatos(VOPersistencia vo) {
		        this.dicPostres = vo.getPostres();
		        this.secVentas = vo.getVentas();
		    }
		 /*
		//funcion que sirve para ver como cargo las listas ingresadas (no es un requerimiento)
		public ArrayList<VOVenta> ListaDeVentasIngresadas()
		{
			return secVentas.obtenerVentas();
		}
		*/
		
		// Requerimiento 8 
		
		public void ListadoVentasxEstado(String Estado) throws EstadoVentaException
		{
			// Estado = Estado.toUpperCase();
			monitor.comienzoLectura();
			if (!(Estado.equals("T") || Estado.equals("P") || Estado.equals("F"))) {
				monitor.terminoLectura();	
			    String msg= "Error, El Estado debe ser : \nT = todas las ventas \nP = ventas en proceso \nF = ventas finalizadas";
			    throw new EstadoVentaException(msg);
			}
			
			LinkedList <VOVenta> lista = secVentas.ListaVentaXEstado(Estado);
			monitor.terminoLectura();
			//PARA MOSTRAR HACEMES UN FOR
			for(VOVenta v : lista)
			{
				System.out.println(v.toString());		
			}
			
		}
		
		
		//REQUERIMIENTO 7
		public float finalizarVenta (int numVenta,String indicacion) throws ExisteVentaException,IndicacionException, FinalizadaException 
		{
			monitor.comienzoEscritura();
			if (secVentas.obtenerVenta(numVenta) == null)
			{
				monitor.terminoEscritura();
				String msg= "No existe venta con ese numero";
			    throw new ExisteVentaException(msg);
			}
			if (!(indicacion.equals("CONFIRMAR") || indicacion.equals("CANCELAR"))) {
				monitor.terminoEscritura();
			    String msg= "Indicacion no es valida: Debe ingresar CONFIRMAR O CANCELAR";
			    throw new IndicacionException(msg);
			}
			if (secVentas.obtenerVenta(numVenta).getEstado().equals("FINALIZADA") )
			{
				monitor.terminoEscritura();
				String msg= "La venta ya se encuentra finalizada";
			    throw new FinalizadaException(msg);
			}
			
		    if ((secVentas.obtenerVenta(numVenta).getSecEsVendido() == null ) ||  (indicacion.equals("CANCELAR"))){
		        secVentas.eliminarVenta(numVenta);
		        monitor.terminoEscritura();
		        return 0; //tengo que devolver 0 porque no se puede obtener el numero de venta ya que no existe mas
		        
		        
		    }
		    secVentas.confirmarVenta(numVenta);
		    float resu =  secVentas.obtenerVenta(numVenta).getMontoTotal();
		    monitor.terminoEscritura();
		    return resu;
		}
		

		// Req 10
		public VORecaudado recaudacionXPostreXfecha(String codigo, LocalDateTime fecha ) throws AlfanumericoException,PostreException
		{
			monitor.comienzoLectura();
			if (!codigo.matches("^[a-zA-Z0-9]+$")) {
				monitor.terminoLectura();
		        String msg= "El codigo debe ser alfanumerico";
		    	throw new AlfanumericoException(msg);
		    }
			if(!dicPostres.member(codigo)) {
				monitor.terminoLectura();
				String msg = "No existe un postre con ese codigo";
				throw new PostreException(msg);
			}	
			VORecaudado vor = secVentas.obtenerVentaxFecha(codigo,fecha);
			monitor.terminoLectura();
			return vor;
		}
		
		
		//funcion que sirve para ver como cargo las listas ingresadas (no es un requerimiento)
		public ArrayList<VOVenta> ListaDeVentasIngresadas()
		{
			monitor.comienzoLectura();
			ArrayList<VOVenta> resu = secVentas.obtenerVentas();
			monitor.terminoLectura();
			return resu;
		}
		
		
		/*
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
		*/
		
		
		
		
	
		

}
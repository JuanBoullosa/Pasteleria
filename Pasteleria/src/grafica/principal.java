package grafica;

import logica.colecciones.Postres;
import logica.negocio.Postre;
import logica.negocio.Light;

import java.time.LocalDateTime;
import java.util.ArrayList;
import fachada.Fachada;
import logica.excepciones.*;
import logica.valueobjects.*;
import logica.valueobjects.VOPostre;
import logica.colecciones.Ventas;
import logica.negocio.Venta;
import logica.valueobjects.VOVenta;



public class principal {

	public static void main(String[] args) {
		
		Fachada f = new Fachada();
		
		
		VOVentaIngreso voi1 = new VOVentaIngreso("Rio Danubio M107 S27", LocalDateTime.now());
		VOVentaIngreso voi2 = new VOVentaIngreso("Carabelas M16 S16", LocalDateTime.now());
		VOVentaIngreso voi3 = new VOVentaIngreso("Marquez Castro 243", LocalDateTime.now());
		VOPostre vop1 = new VOPostre("P002", "Torta de Chocolate", 200);
		VOPostre vop4 = new VOLight("P004", "Torta de Coco", 350,"Estevia","Bajo en calorias");
		
		//Ingreso el postre 
		try {
			f.registrarPostre(vop1);
			f.registrarPostre(vop4);
		}
		catch (AlfanumericoException e) {
			System.out.println(e.darMensaje());
		}
		catch (PrecioException e) {
			System.out.println(e.darMensaje());
		}
		catch (PostreException e) {
			System.out.println(e.darMensaje());
		
		};
		
		
		
		//Ingreso las ventas
		try
		{
			f.nuevaVenta(voi1);
			f.nuevaVenta(voi2);
			f.nuevaVenta(voi3);
		}
		catch (FechaException e)
		{
			System.out.println(e.darMensaje());
		};
		
		
		//Ingreso el postre en la venta
		try
		{
			f.agregarPostreEnVenta("P002", -40, 1);
			f.agregarPostreEnVenta("P002", 10, 1);
			f.agregarPostreEnVenta("P004", 1, 2); // agrego el mismo 2 veces
			System.out.println("Lista de ventas:");
			ArrayList<VOVenta> listaingreso = f.ListaDeVentasIngresadas();
			for (VOVenta vovi: listaingreso) {
				System.out.println(vovi);
			}
		}
		catch (CantidadException e)
		{
			System.out.println(e.darMensaje());
		}
		catch (AlfanumericoException e)
		{
			System.out.println(e.darMensaje());
		}
		catch (PostreException e)
		{
			System.out.println(e.darMensaje());
		}
		catch (ExisteVentaException e)
		{
			System.out.println(e.darMensaje());
		}
		catch (IngresoCantidadException e)
		{
			System.out.println(e.darMensaje());
		}
		catch (LimiteUnidadesException e)
		{
			System.out.println(e.darMensaje());
		}
		
		;
		
		// Listado de todos los Postres 
		for (VOPostre vod : f.ListadoGeneralPostre()) {
		    System.out.println(vod.toString());
		}
		
		
		//Prueba 1 postre detallado 
		try {
		    VOPostreDetallado r = f.ListarPostreDetallado("P004");
		    System.out.println(r);  
		} catch (AlfanumericoException e) {
		    System.out.println(e.getMessage()); 
		} catch (PostreException e) {
		    System.out.println(e.getMessage());
		}
	


	try
	{
		System.out.println("Lista de ventas:");
		f.nuevaVenta(voi1);
		f.nuevaVenta(voi2);
		f.nuevaVenta(voi3);
	}
	catch (FechaException e)
	{
		System.out.println(e.darMensaje());
	};

	//Funcion para mostrar ventas ingresadas
	ArrayList<VOVenta> listaingreso = f.ListaDeVentasIngresadas();
	for (VOVenta vovi: listaingreso) {
		System.out.println(vovi);
	}
}

}



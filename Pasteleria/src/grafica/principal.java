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
		

		
		VOPostre vop0 = new VOPostre("P007", "Torta de Chocolate", 10);
		VOLight vop1 = new VOLight("P003", "Torta de Coco",887 ,"Estevia","Bajo en calorias");
		VOLight vop2 = new VOLight("P020", "Torta de Limon",200 ,"Estevia","0 Calorias");
		try {
			f.registrarPostre(vop0);
			//System.out.println("Postre registrado correctamente");
			
			//System.out.println("\nPostres registrado:");
			//VOPostre vo = f.ListarPostreDetallado("P003");
			//System.out.println(vop0);
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
		
		try {
			f.registrarPostre(vop1);
			//System.out.println("Postre registrado correctamente");
			
			//System.out.println("\nPostres registrado:");
			//VOPostre vo = f.ListarPostreDetallado("P003");
			//System.out.println(vop1);
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
		
		
		try {
			f.registrarPostre(vop2);
			//System.out.println("Postre registrado correctamente");
			
			//System.out.println("\nPostres registrado:");
			//VOPostre vo = f.ListarPostreDetallado("P003");
			//System.out.println(vop2);
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
		
		
		ArrayList<VOPostreDetallado> lista = f.ListadoGeneralPostre();
		for (VOPostreDetallado vopd: lista) {
			System.out.println(vopd);
		}
		

			//Probando secuencia de ventas
			VOVentaIngreso voi1 = new VOVentaIngreso("Rio Danubio M107 S27", LocalDateTime.now());
			VOVentaIngreso voi2 = new VOVentaIngreso("Carabelas M16 S16", LocalDateTime.now());
			VOVentaIngreso voi3 = new VOVentaIngreso("Marquez Castro 243", LocalDateTime.now());
			
			
			
			try {
			f.nuevaVenta(voi1);
			//System.out.println("Se logro ingresar la venta correctamente");
			System.out.println("\nVenta registradas:");
			}
			catch (FechaException e)
			{
				System.out.println(e.darMensaje());
			};
		
			try {
			f.nuevaVenta(voi2);
			//System.out.println("Se logro ingresar la venta correctamente");
			//System.out.println("\nVenta registrada:");
			}
			catch (FechaException e)
			{
				System.out.println(e.darMensaje());
			};
			try
			{
				f.nuevaVenta(voi3);
				//System.out.println("Se logro ingresar la venta correctamente");
				//System.out.println("\nVenta registrada:");
			}
			catch (FechaException e)
			{
				System.out.println(e.darMensaje());
			};
			
			
			
			
			///%%%%%%%%%%%%%%%%%%%%          Requerimiento 5 Prueba %%%%%%%%%%%%%%%%%%%
			VOPostre v7 = new VOPostre("P90", "Torta de Chocolate", 300);
			
			try
			{
				f.agregarPostreEnVenta(v7, 6, 60);
				//System.out.println("Se logro ingresar la venta correctamente");
				//System.out.println("\nVenta registrada:");
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
			catch (LimiteUnidadesException e)
			{
				System.out.println(e.darMensaje());
			}
			;
			
			
			ArrayList<VOVenta> listaingreso = f.ListaDeVentasIngresadas();
			for (VOVenta vovi: listaingreso) {
				System.out.println(vovi);
			}
	}

}



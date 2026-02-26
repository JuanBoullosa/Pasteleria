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
		
		// REQUERIMIENTO 12 - RECUPERAR
	      try { 
	            f.recuperar();
	            System.out.println("Se restauro el sistema correctamente.");
	        } catch (Exception e) {
	            System.out.println("No existe respaldo previo.");
	        }
	      

		
		
		//VER POSTRES EN VENTAS
		try 
		{
			System.out.println("\nPostres de la venta 1");
			f.ListadoPostresVenta(1);	
			System.out.println("\nPostres de la venta 2");
			f.ListadoPostresVenta(2);	
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
		

		  
		  	//REQUERIMIENTO 7 FINALIZAR O ELIMINAR VENTA
			System.out.println("\n-----------------------------------------------------------------------------------\n");

			try
			{
				
				//"CANCELAR" O "CONFIRMAR"
				float monto = f.finalizarVenta(2, "CONFIRMAR");
		        System.out.println("\n Venta finalizada. Monto a pagar: $" + monto);

			}
			catch (ExisteVentaException e)
			{
				System.out.println(e.darMensaje());
			}
			catch (IndicacionException e)
			{
				System.out.println(e.darMensaje());
			}
			catch (FinalizadaException e)
			{
				System.out.println(e.darMensaje());
			};
			
			System.out.println("\n------------------------          Lista de ventas          ------------------------");
			ArrayList<VOVenta> listaingreso = f.ListaDeVentasIngresadas();
			for (VOVenta vovi: listaingreso) {
				System.out.println(vovi);
				System.out.println("\n-------------------------------------\n");

			}
			
			//REQUERIMIENTO 11 - RESPALDAR
			  try {
		            f.respaldar();
		            System.out.println("Sistema respaldado correctamente.");
		        } catch (Exception e) {
		            System.out.println("Error al respaldar.");
		        }
			
		}
		
		

}

		
	
		
	
		
		
		



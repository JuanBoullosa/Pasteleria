package cliente;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Properties;

import interfaz.IFachada;
import logica.excepciones.*;
import logica.valueobjects.VOLight;
import logica.valueobjects.VOPostre;
import logica.valueobjects.VOPostreCantidad;
import logica.valueobjects.VOPostreDetallado;
import logica.valueobjects.VORecaudado;
import logica.valueobjects.VOVenta;
import logica.valueobjects.VOVentaIngreso;

public class MainCliente 
{
	public static void main(String[] args)
	{
		
		try 
		{
			//obtengo ip y puerto de un archivo de configuracion
			Properties p = new Properties();
			String nomArch = "config/datos.properties";
			p.load (new FileInputStream (nomArch));
			String ip = p.getProperty("ipServidor");
			String puerto = p.getProperty("puertoServidor");
			String ruta = "//" + ip + ":" + puerto + "/Pasteleria";
			
			//accedo remotamente a la cuenta bancaria publicada en el servidor
			IFachada fachada = (IFachada) Naming.lookup(ruta);
			
			// PROBAR UNA LLAMADA (ejemplo)
            System.out.println("Conectado al servidor RMI: " + ruta);
            
            
           	
			// REQUERIMIENTO 12 - RECUPERAR
            System.out.println("\n---------------------------------------------------------------");
            System.out.println("REQUERIMIENTO 12 - RECUPERAR ARCHIVO");
			try { 
				System.out.println("Se restauro el sistema correctamente.");
			} catch (Exception e) {
				System.out.println("No existe respaldo previo.");
				e.printStackTrace();
			}
			
			          
            //REQUERIMIENTO 1 - REGISTRAR POSTRE
			System.out.println("\n---------------------------------------------------------------");
	        System.out.println("REQUERIMIENTO 1 - REGISTRAR POSTRE");
	        try {
	            
	        	// POSTRE 1 - COMUN
	    		VOPostre vop1 = new VOPostre("P001", "Torta de Chocolate", 50);
	    	    fachada.registrarPostre(vop1);
	            System.out.println("Codigo postre comun registrado: " + vop1.getCodigo());
	    		
	            // POSTRE 2 - LIGHT
	    		VOLight vop2 = new VOLight("P002", "Torta de Coco",200 ,"Estevia","Bajo en calorias");
	    	    fachada.registrarPostre(vop2);
	            System.out.println("Codigo postre light registrado: " + vop2.getCodigo());
	    		
	    		// POSTRE 3 - COMUN
	    		VOPostre vop3 = new VOPostre("P003", "Cheesecake de frutos rojos", 300);
	    	    fachada.registrarPostre(vop3);
	            System.out.println("Codigo postre comun registrado: " + vop3.getCodigo());
	    		
	    		// POSTRE 4 - COMUN
	    		VOPostre vop4 = new VOPostre("P004", "Flan de dulce de leche",150 );
	    	    fachada.registrarPostre(vop4);
	            System.out.println("Codigo postre comun registrado: " + vop4.getCodigo());
	    		
	            
	        } 
			catch (AlfanumericoException e) {
				System.out.println(e.darMensaje());
				e.printStackTrace();
			}
			catch (PrecioException e) {
				System.out.println(e.darMensaje());
				e.printStackTrace();
			}
			catch (PostreException e) {
	            System.out.println(e.darMensaje());
	            e.printStackTrace();
			}

	        
	     
	        //REQUERIMIENTO 2 - LISTADO GENERAL POSTRES
	        System.out.println("\n---------------------------------------------------------------");
	        System.out.println("REQUERIMIENTO 2 - LISTADO GENERAL POSTRES");
	        

	        	try {
				ArrayList<VOPostre> lista = fachada.ListadoGeneralPostre();
				for (VOPostre vopd: lista) {
					System.out.println(vopd.toString());
					
				}
	            } 	
	        	catch (Exception e) {
	    			System.out.println("Error lista");
	    			e.printStackTrace();
	    		};

			
	    	//REQUERIMIENTO 3 - DETALLE DE UN POSTRE	
		    System.out.println("\n---------------------------------------------------------------");
	    	System.out.println("REQUERIMIENTO 3 - DETALLE DE UN POSTRE");
	        try {
	        	System.out.println("\nListado detallado de un postre: ");
	            VOPostreDetallado det = fachada.ListarPostreDetallado("P001");
	            VOPostreDetallado det2 = fachada.ListarPostreDetallado("P002");
	            System.out.println(det);
	            System.out.println(det2);
	        }	catch (AlfanumericoException e) {
				System.out.println(e.darMensaje());
				e.printStackTrace();
			}
			catch (PostreException e) {
	            System.out.println(e.darMensaje());
	            e.printStackTrace();
			
			};
			//REQUERIMIENTO 4 - CREO UNA VENTA
			System.out.println("\n---------------------------------------------------------------");
			System.out.println("REQUERIMIENTO 4 - CREO UNA VENTA");
		    
			try
			{
				// VENTA 1
				VOVentaIngreso voi1 = new VOVentaIngreso("Rio Danubio M107 S23", LocalDate.now());
	    	    fachada.nuevaVenta(voi1);
	            System.out.println("\nLa 1era venta ingresada tiene direccion: " + voi1.getDireccionEnvio());
				// VENTA 2
	            VOVentaIngreso voi2 = new VOVentaIngreso("Carabelas entre Mamboreta y Guazubira", LocalDate.now());
	    	    fachada.nuevaVenta(voi2);
				System.out.println("La 2da venta ingresada tiene el codigo: " + voi2.getDireccionEnvio());
	            // VENTA 3
				VOVentaIngreso voi3 = new VOVentaIngreso("Marquez Castro esq. Av. Giannattasio", LocalDate.now());
	    	    fachada.nuevaVenta(voi3);
				System.out.println("La 3era venta ingresada tiene el codigo: " + voi3.getDireccionEnvio());
				
				
		
			}
			catch (FechaException e)
			{
				System.out.println(e.darMensaje());
				e.printStackTrace();
			};
            
			
			System.out.println("\n---------------------------------------------------------------");
			//REQUERIMIENTO 5 - INGRESO UN POSTRE A UNA VENTA
			System.out.println("REQUERIMIENTO 5 - INGRESO UN POSTRE A UNA VENTA ");
			
			
			try {
			
				fachada.agregarPostreEnVenta("P001", 4, 10); //CODIGO, UNIDADES, NUMERO VENTA
				fachada.agregarPostreEnVenta("P002", 2, 7); 
				System.out.println("\nIngreso correctamente 4 unidades de P001 a la venta 1 y 2 unidades del P002 a la venta numero 2");
				
			}
			catch (CantidadException e)
			{
				System.out.println(e.darMensaje());
				e.printStackTrace();
			}
			catch (AlfanumericoException e)
			{
				System.out.println(e.darMensaje());
				e.printStackTrace();
			}
			catch (PostreException e)
			{
				System.out.println(e.darMensaje());
				e.printStackTrace();
			}
			catch (ExisteVentaException e)
			{
				System.out.println(e.darMensaje());
				e.printStackTrace();
			}
			catch (IngresoCantidadException e)
			{
				System.out.println(e.darMensaje());
				e.printStackTrace();
			}
			catch (LimiteUnidadesException e)
			{
				System.out.println(e.darMensaje());
				e.printStackTrace();
			}
			;
			
			/*
			
			//REQUERIMIENTO 6 - ELIMINO UN POSTRE EN UNA VENTA
			System.out.println("\n---------------------------------------------------------------");
			System.out.println("REQUERIMIENTO 6 - ELIMINO UN POSTRE EN UNA VENTA ");
			
			
			try
			{
				fachada.eliminarOBorrarPostreEs_Vendidos("P001", 2, 1);	 //CODIGO, UNIDADES, NUMERO VENTA
				System.out.println("\nElimino dos postres P001 a la venta 1");
				fachada.eliminarOBorrarPostreEs_Vendidos("P002", 2, 2);
				System.out.println("\nElimino dos postres P002 a la venta 2 y como tiene unidad cero es eliminada de la venta");

			}
			catch (CantidadException e)
			{
				System.out.println(e.darMensaje());
				e.printStackTrace();
			}
			catch (AlfanumericoException e)
			{
				System.out.println(e.darMensaje());
				e.printStackTrace();
			}
			catch (PostreException e)
			{
				System.out.println(e.darMensaje());
				e.printStackTrace();
			}
			catch (ExisteVentaException e)
			{
				System.out.println(e.darMensaje());
				e.printStackTrace();
			}
			;
			
			//REQUERIMIENTO 7 - FINALIZO O CANCELO UNA VENTA SEGUN INDICACION
			System.out.println("\n---------------------------------------------------------------");
			System.out.println("REQUERIMIENTO 7 - FINALIZO O CANCELO UNA VENTA SEGUN INDICACION ");
			
			
			try
			{
				//"CANCELAR" O "CONFIRMAR"
				float monto = fachada.finalizarVenta(1, "CONFIRMAR");  // NUMERO DE VENTA, INDICACION
		        System.out.println("Finalizo venta 1. Monto a pagar: $" + monto);
		        float monto2 = fachada.finalizarVenta(2, "CANCELAR");  // NUMERO DE VENTA, INDICACION
		        System.out.println("Cancelo venta 2 y la elimino");


			}
			catch (ExisteVentaException e)
			{
				System.out.println(e.darMensaje());
				e.printStackTrace();
			}
			catch (IndicacionException e)
			{
				System.out.println(e.darMensaje());
				e.printStackTrace();
			}
			catch (FinalizadaException e)
			{
				System.out.println(e.darMensaje());
				e.printStackTrace();
			};
			
			*/
			//REQUERIMIENTO 8 - LISTADO DE VENTAS SEGUN INDICACION T = TODAS, P = EN PROCESO Y F = FINALIZADA
			System.out.println("\n---------------------------------------------------------------");
			System.out.println("REQUERIMIENTO 8 - LISTADO DE VENTAS SEGUN INDICACION T = TODAS, P = EN PROCESO Y F = FINALIZADA");
			
			try{
				
				System.out.println("\nVentas en PROCESO:");
				fachada.ListadoVentasxEstado("P");
				LinkedList<VOVenta> lista2 = fachada.ListadoVentasxEstado("P");
				for (VOVenta voV2: lista2) {
					System.out.println(voV2.toString());
					
				}
				
				
				System.out.println("\nVentas FINALIZADA :");
				fachada.ListadoVentasxEstado("F");
				LinkedList<VOVenta> lista3 = fachada.ListadoVentasxEstado("F");
				for (VOVenta voV3: lista3) {
					System.out.println(voV3.toString());
					
				}
				
				System.out.println("\nTodas las ventas(menos eliminadas):");
				fachada.ListadoVentasxEstado("T");
				LinkedList<VOVenta> lista4 = fachada.ListadoVentasxEstado("T");
				for (VOVenta voV4: lista4) {
					System.out.println(voV4.toString());
					
				}
				
			}catch(EstadoVentaException e){
				System.out.println(e.getMensaje());
				e.printStackTrace();
			};
			
			
			
			/*
			
			//REQUERIMIENTO 9 - LISTADO DE POSTRES EN UNA VENTA
			System.out.println("\n---------------------------------------------------------------");
			System.out.println("REQUERIMIENTO 9 - LISTADO DE POSTRES EN UNA VENTA ");
			
			try {
				System.out.println("\nTodos los Postres Venta 1: ");
				fachada.ListadoPostresVenta(1);
				ArrayList<VOPostreCantidad> lista2 = fachada.ListadoPostresVenta(1);
				for (VOPostreCantidad vopd: lista2) {
					System.out.println(vopd.toString());
				}
				
				System.out.println("\nTodos los Postres Venta 3: ");
				fachada.ListadoPostresVenta(3);
				ArrayList<VOPostreCantidad> lista3 = fachada.ListadoPostresVenta(3);
				for (VOPostreCantidad vopd: lista3) {
					System.out.println(vopd.toString());
				}
				
			}catch(NroVentaException e) {
				System.out.println(e.getMensaje());
				e.printStackTrace();
			}
			catch(NoPoseePostreException e) {
				System.out.println(e.darMensaje());
				e.printStackTrace();
			}
	
			
			
			
			//REQUERIMIENTO 10 - RECAUDACION POR POSTRE Y FECHA
			System.out.println("\n---------------------------------------------------------------");
			System.out.println("REQUERIMIENTO 10 - RECAUDACION POR POSTRE Y FECHA");
			
			try {
				System.out.println("\nMonto total recaudado y total de unidades vendidas del postre 1:");
				LocalDate fecha = LocalDate.of(2026, 2, 28);
				VORecaudado vor = fachada.recaudacionXPostreXfecha("P001", fecha );
				System.out.println(vor.toString());
			}catch(AlfanumericoException e) {
				System.out.println(e.darMensaje());
				e.printStackTrace();
			}
			catch(PostreException e) {
				System.out.println(e.darMensaje());
				e.printStackTrace();
			}
			
			
			
			
			//REQUERIMIENTO 11 - RESPALDO DE DATOS
			System.out.println("\n---------------------------------------------------------------");
			System.out.println("REQUERIMIENTO 11 - RESPALDO DE DATOS");
			
			  try {
		            fachada.respaldar();
		            System.out.println("Sistema respaldado correctamente.");
		        } catch (Exception e) {
		            System.out.println("Error al respaldar.");
		        }
			
            
            */
            
            
            
     
            //System.out.println("Cantidad postres: " + fachada.ListadoGeneralPostre().size());

			
		}
		catch (MalformedURLException e) // si la ruta no esta bien formada
		{
			e.printStackTrace();
		}
		catch (RemoteException e) // si ocurre cualquier problema de red
		{
			e.printStackTrace();
		}
		catch (NotBoundException e) // si la ruta esta bien formada pero el servidor esta bajo
		{
			e.printStackTrace();
		}
		catch (FileNotFoundException e) // si no encuentra el archivo de configuracion
		{
			e.printStackTrace();
		}
		catch (IOException e) // si ocurre cualquier otro error de E/S
		{
			e.printStackTrace();
		} 
	}
}



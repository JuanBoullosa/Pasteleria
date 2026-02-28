package grafica;


import logica.negocio.Postre;

import logica.negocio.Light;

import java.time.LocalDateTime;
import java.util.ArrayList;
import fachada.Fachada;
import logica.excepciones.*;
import logica.valueobjects.*;
import logica.colecciones.Ventas;
import logica.negocio.Venta;
import logica.colecciones.Es_Vendidos;
import java.rmi.RemoteException;

/// NO BORRAR PRINCIAL SIRVE PARA PROBAR LOCALMENTE 

public class principal {

	public static void main(String[] args) {
		
		try {
	        Fachada f = new Fachada();
	        
	        Postre p1 = new Postre("P001", "Torta de Chocolate", 100);
			Postre p2 = new Postre("P002", "Torta de Limon", 300);
			Postre p3 = new Light("P003", "Torta de Coco", 200,"Estevia","Bajo en calorias");
			Postre p4 = new Light("A003", "Galleta de avena  ", 400 ,"Miel","Fuerte en fibras");
					
			f.getDicPostres().insert(p1.getCodigo(), p1);		
			f.getDicPostres().insert(p2.getCodigo(), p2);
			f.getDicPostres().insert(p3.getCodigo(), p3);
			f.getDicPostres().insert(p4.getCodigo(), p4);
					
			// Requerimiento 1 Alta Postre ok 
			VOPostre vop0 = new VOPostre("A001", "Torta de Chocolate", 600);
			VOLight vop1 = new VOLight("P006", "Torta de Coco",700 ,"Estevia","Bajo en calorias");
			try {
				f.registrarPostre(vop0);
				f.registrarPostre(vop1);
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
			
			
			// Requerimiento 2 Listado General de Postres  código, nombre, precio unitario y tipo
			System.out.println("\nListado General Postres");
			ArrayList<VOPostre> lista = f.ListadoGeneralPostre();
			
			for (VOPostre vop:lista ){
				System.out.println(vop.toString());
			};
			
			
			//3) Listado detallado de un postre
			//SOLO MUESTRA EL POSTRE SI ES INGRESADO CON f.registrarPostre()
			System.out.println("\nRequerimiento 3: Listado detallado de un postre: A001 y P006");
			
			try {
						
				VOPostreDetallado vo1 = f.ListarPostreDetallado("P006");
				System.out.println(vo1.toString());
			}
			catch (AlfanumericoException e) {
				System.out.println(e.darMensaje());
			}
			catch (PostreException e) {
	            System.out.println(e.darMensaje());
			
			};
			
			
			//4) Requemiento 4 
				    LocalDateTime fecha = LocalDateTime.now();	
					
					System.out.println("\nPrueba Venta Cargada con Metodo");
				    // Prueba Ingresar ventas con con Metodo 
				    VOVentaIngreso vovi0 = new VOVentaIngreso ("18 de Julio",fecha);
				    VOVentaIngreso vovi1 = new VOVentaIngreso ("Colonia 998",fecha);
				    VOVentaIngreso vovi2 = new VOVentaIngreso ("Uruguay 1991",fecha);
				    f.getSecVentas().altaVenta(vovi0);
				    f.getSecVentas().altaVenta(vovi1);
				    f.getSecVentas().altaVenta(vovi2);
				    
				    ArrayList<VOVenta> lista5 = f.ListaDeVentasIngresadas();
					for (VOVenta vov:lista5 ) {
						System.out.println(vov.toString());
					}
				  		
		
				// Requerimiento 5 
					
					try {
						f.agregarPostreEnVenta("P001", 3, 1);
						f.agregarPostreEnVenta("P003", 2, 1);
						f.agregarPostreEnVenta("P006", 2, 3);
					}
					catch (CantidadException e) {
						System.out.println(e.darMensaje());
					}
					catch (AlfanumericoException e) {
			            System.out.println(e.darMensaje());
					
					}
					catch (PostreException e) {
			            System.out.println(e.darMensaje());
					
					}
					catch (ExisteVentaException e) {
			            System.out.println(e.darMensaje());
					
					}
					catch (IngresoCantidadException e) {
			            System.out.println(e.darMensaje());
					
					}
					catch (LimiteUnidadesException e) {
			            System.out.println(e.darMensaje());
					
					};
					
					System.out.println("\nPrueba, Se cargan postres en Venta OK");
					ArrayList<VOVenta> lista6 = f.ListaDeVentasIngresadas();
					for (VOVenta vov:lista6 ) {
						System.out.println(vov.toString());
					}
					
					// Requerimiento 6
					
					try {
						f.eliminarOBorrarPostreEs_Vendidos("P001", 1, 1);
						f.eliminarOBorrarPostreEs_Vendidos("P003", 1, 1);
						f.eliminarOBorrarPostreEs_Vendidos("P006", 1, 3);
					}
					catch (CantidadException e) {
						System.out.println(e.darMensaje());
					}
					catch (AlfanumericoException e) {
			            System.out.println(e.darMensaje());
					
					}
					catch (PostreException e) {
			            System.out.println(e.darMensaje());
					
					}
					catch (ExisteVentaException e) {
			            System.out.println(e.darMensaje());
					
					};
					
					System.out.println("\nPrueba, Se Sacan postres en Venta OK, Solo Venta uno queda con un postre de $200");
					ArrayList<VOVenta> lista7 = f.ListaDeVentasIngresadas();
					for (VOVenta vov:lista7 ) {
						System.out.println(vov.toString());
					}
					
					
					
					// Requerimiento 7	
					
					try {
						float resu = f.finalizarVenta(1,"CONFIRMAR");
						float resu1 = f.finalizarVenta(3,"CANCELAR");
						System.out.println("\nSe Finaliza Venta Nro 1 y el Monto tiene que ser $400 es: "+ resu);
						System.out.println("\nSe Cancela Venta Nro 3 NO debe aparecer en la Lista Ventas pero da Resultado "+ resu1);
					}
					catch (ExisteVentaException e) {
			            System.out.println(e.darMensaje());
					
					}
					catch (IndicacionException e) {
			            System.out.println(e.darMensaje());
					
					}
					catch (FinalizadaException e) {
			            System.out.println(e.darMensaje());
					
					};
					
					
					System.out.println("\nNo debe aparaecer Venta Nro 3 Se Cancelo ");
					ArrayList<VOVenta> lista8 = f.ListaDeVentasIngresadas();
					for (VOVenta vov:lista8 ) {
						System.out.println(vov.toString());
					}
					
					// Requerimiento 8
					
					
					
					try{
						System.out.println("\nSolo Venta 2 en Proceso :");
						f.ListadoVentasxEstado("P");
						
						System.out.println("\nSolo Venta 1 FINALIZADA :");
						f.ListadoVentasxEstado("F");
						
						System.out.println("\nTodas las Venta 1 Finalizada, Venta 2 en Proceso, Venta 3 Cancelada NO DEBE APARECER :");
						f.ListadoVentasxEstado("T");
					}catch(EstadoVentaException e){
						System.out.println(e.getMensaje());
					};
					
					
					
					//Requermiento 9
					
					try {
						System.out.println("\nTodos los Postres Venta 1 ");
						f.ListadoPostresVenta(1);
					}catch(NroVentaException e) {
						System.out.println(e.getMensaje());
					}
					
					
					// Requerimeint 10
					
					try {
						System.out.println("\nMonto total recaudado y total de unidades vendidas del postre");
						VORecaudado vor = f.recaudacionXPostreXfecha("P001",fecha );
						System.out.println(vor.toString());
					}catch(AlfanumericoException e) {
						System.out.println(e.darMensaje());
					}
					catch(PostreException e) {
						System.out.println(e.darMensaje());
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

		
		// REQUERIMIENTO 12 - RECUPERAR
	        try { 
	            f.recuperar();
	            System.out.println("Se restauro el sistema correctamente.");
	        } 
	        catch (RecuperarException e) {
	            System.out.println(e.getMessage());
	        }
	        catch (Exception e) {
	            e.printStackTrace();
	        }

	    } 
	    catch (RemoteException e) {
	        e.printStackTrace();
	    }

	} 
	}


	


			
		
	
		
		
		


